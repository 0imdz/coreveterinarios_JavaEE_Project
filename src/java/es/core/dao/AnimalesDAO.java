/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.core.dao;

import com.example.Animales;
import com.example.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author Ismael
 */
@Model //named y requestscope
@Transactional(value=Transactional.TxType.REQUIRES_NEW)
public class AnimalesDAO implements Serializable{ 
    
    @PersistenceContext(unitName="CoreVeterinariosWebPU")
    private EntityManager em;
    
    public void create(Animales nuevo_animal) {
        em.persist(nuevo_animal);
    }
    
    public List<Animales> getAllAnimales(){
        TypedQuery<Animales> consulta=em.createQuery("SELECT a FROM Animales a ", Animales.class);
        List<Animales> listaAnimales=consulta.getResultList();
        return listaAnimales;
    }
}
