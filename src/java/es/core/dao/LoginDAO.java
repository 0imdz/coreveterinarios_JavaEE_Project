/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.core.dao;

import com.example.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ismael
 */
@Model //named y requestscope
public class LoginDAO implements Serializable{
    @Inject 
    private UsuarioDAO usuarioDAO;
    
    @PersistenceContext(unitName="CoreVeterinariosWebPU")
    private EntityManager em;
    
    public Usuario getByEmailAndPassword(String nombre, String contrasenya) throws SQLException{
        Query consulta=em.createNativeQuery("SELECT ID, NOMBRE, PASSWORD FROM Usuarios WHERE NOMBRE=? AND PASSWORD=?", Usuario.class);
        
          consulta.setParameter(1, nombre);
          consulta.setParameter(2, contrasenya);
          List<Usuario> resultado = consulta.getResultList();

          if(resultado.size()>0)
              return resultado.get(0);
                      else return null;
    }
}
