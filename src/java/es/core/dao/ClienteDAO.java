/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.core.dao;

import com.example.Cliente;
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
public class ClienteDAO implements Serializable{ 
    
    @PersistenceContext(unitName="CoreVeterinariosWebPU")
    private EntityManager em;
    
    public List<Cliente> getAllClientes(){
        TypedQuery<Cliente> consulta=em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        List<Cliente> listaClientes=consulta.getResultList();
        return listaClientes;
    }
}
