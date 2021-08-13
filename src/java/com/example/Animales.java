package com.example;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ANIMALES")

public class Animales implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;    
    private String nombre;
    @Column(name="peso_gramos")
    private int peso_gramos;
//    @JoinColumn(name="id_cliente")
//    @ManyToOne
//    private Cliente cliente;

    public Animales() {
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso_gramos() {
        return peso_gramos;
    }

    public void setPeso_gramos(int peso_gramos) {
        this.peso_gramos = peso_gramos;
    }

//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
}
