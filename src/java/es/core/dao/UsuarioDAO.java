/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.core.dao;

import com.example.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ismael
 */
@Model //named y requestscope
public class UsuarioDAO implements Serializable{
//    @Resource(lookup="jdbc/coreveterinarios")
//    private DataSource datasource;
    
    @PersistenceContext(unitName="CoreVeterinariosWebPU")
    private EntityManager em;
    
    public void addNewUsuario(Usuario usuario){
        em.persist(usuario);
        em.flush();//va a la base de datos y hace un refresco
    }
    
    public List<Usuario> getAllUsuarios(){
        TypedQuery<Usuario> consulta=em.createQuery("SELECT u FROM Usuario u", Usuario.class);
//        em.persist(new Usuario(3, "Nuevo Usuario", "123", "correocorreo"));
        List<Usuario> listaUsuarios=consulta.getResultList();
//        List<Usuario> listaUsuarios=new ArrayList<>();
//        try(Connection conn=datasource.getConnection();
//            Statement stm=conn.createStatement();
//            ResultSet rs=stm.executeQuery("SELECT * FROM USUARIOS")){
//            
//            while(rs.next()){
//                int id=rs.getInt("ID");
//                String nombre=rs.getString("NOMBRE");
//                String pass=rs.getString("PASSWORD");
//                String correo=rs.getString("CORREO");
//                listaUsuarios.add(new Usuario(id, nombre, pass, correo));
//            }
//        };
        return listaUsuarios;
    }
    
//    public List<Usuario> getAllUsuarios(String filtro) throws SQLException{
//        List<Usuario> listaUsuarios=new ArrayList<>();
//        Usuario usuario=new Usuario(1, "ismaelism5", "ismaelismael", "123456789AS");
//        try(Connection conn=datasource.getConnection()){
//            Statement stm=conn.createStatement();
//            ResultSet rs=stm.executeQuery("SELECT * FROM USUARIOS");
//            stm.setString(1, "%"+filtro.toLowerCase()+"%");
//            while(rs.next()){
//                int id=rs.getInt("ID");
//                String nombre=rs.getString("NOMBRE");
//                String pass=rs.getString("PASSWORD");
//                String correo=rs.getString("CORREO");
//                listaUsuarios.add(new Usuario(id, nombre, pass, correo));
//            }
//        };
//        
//        return listaUsuarios;
//    }
}
