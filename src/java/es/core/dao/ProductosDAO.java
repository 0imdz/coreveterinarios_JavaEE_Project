/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.core.dao;

import com.example.Productos;
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
public class ProductosDAO implements Serializable{ 
    
    @PersistenceContext(unitName="CoreVeterinariosWebPU")
    private EntityManager em;
    
    public List<Productos> getAllProductos(){
        TypedQuery<Productos> consulta=em.createQuery("SELECT p FROM Productos p ", Productos.class);
        List<Productos> listaProductos=consulta.getResultList();
        return listaProductos;
    }
}
