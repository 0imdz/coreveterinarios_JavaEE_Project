package com.example;

import es.core.dao.UsuarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.UserTransaction;

@Named
@RequestScoped
public class LoginBean implements Serializable {

    private String username;
    private String contrasenya;
    private String correo;
    
   @Inject 
   private  UsuarioDAO usuarioDAO;
   @Resource
   private UserTransaction ux; 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * Método que checkea la correcta introducción de un nombre de usuario válido
     * @param nombre_usuario
     * @return
     */
    public boolean checkNombre(String username){
       return username.length() >= 6;
    }
    
    /**
     * Método que checkea la correcta introducción de un nombre de usuario válido
     * @param password
     * @return
     */
    public boolean checkPassword(String contrasenya){
        return contrasenya.matches(".*[A-Z].*") && contrasenya.length() >= 8;
    }
    
    public boolean checkCorreo(String correo){
        return correo.length() >= 10;
    }
    
    public String registro() {     
        if (username!=null && (!username.equals("")) && correo!=null && (!correo.equals("")) && contrasenya!=null && (!contrasenya.equals(""))) {               
           Usuario usuario = new Usuario(username, correo, contrasenya);
           try {
                ux.begin();
                usuarioDAO.addNewUsuario(usuario);
                ux.commit();
                return "perfil";
           } catch(Exception e){
               return "registro_alta";
           }
        } else return "index";  
    } 
    
    public String inicio_sesion() {  
        boolean salir=false;
        if (username!=null && (!username.equals("")) && contrasenya!=null && (!contrasenya.equals(""))) {
           List<Usuario> listaUsuarios=new ArrayList<Usuario>();
           
           try {
                ux.begin();
                listaUsuarios=usuarioDAO.getAllUsuarios();
                ux.commit();                
           } catch(Exception e){
               return "registro";
           }
           for(int i=0; i<listaUsuarios.size(); i++){
                if (username.equals(listaUsuarios.get(i).getNombre()) && contrasenya.equals(listaUsuarios.get(i).getPassword())){
                    salir=true;
                    return "perfil?face-redirect=true";
                }
            }
            
        } else return "registro";
        return null;
    }
}
