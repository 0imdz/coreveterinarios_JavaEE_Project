/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.core.dao;

import com.example.Animales;
import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Ismael
 */
@Model
@Transactional(value=Transactional.TxType.REQUIRES_NEW)
public class nuevoAnimalDAO implements Serializable {
    @PersistenceContext(unitName = "CoreVeterinariosWebPU")
    private EntityManager em;
    
    public void create(Animales adao) {
        em.persist(adao);
    }
    
    public void delete(Animales adao) {
        em.remove(adao);
    }
    
//    public Usuario addUsuario(Usuario u) throws SQLException{
//        Query consulta=em.createNativeQuery("INSERT INTO USUARIOS(NOMBRE, CORREO, PASSWORD) VALUES(?,?,?)", Usuario.class);
//    
////        consulta.setParameter(1, nombre);
////        consulta.setParameter(2, contrasenya);
////        consulta.setParameter(3, correo);
//        
//        consulta.setParameter(1, u.getNombre());
//        consulta.setParameter(2, u.getCorreo());
//        consulta.setParameter(3, u.getPassword());
//        consulta.executeUpdate();
//        return null;
//    }
}
