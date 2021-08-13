/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ismael
 */
@Entity 
@Table(name="USUARIOS")
public class Usuario implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
//    @NotNull(message="Clave primaria no puede ser nula.")
    private int id;
    @Size(min=5,max = 15, message="El nombre de usuario debe tener menos de 5 y 15 carácteres.")
    private String nombre;
    @Column(name="CORREO")
    private String correo;
    @Column(name = "PASSWORD") 
    private String password;
    

    public Usuario() {
    }
    
    public Usuario(String nombre, String correo, String password) {
//      this.id = id; //no quiero pasarle el id pq se genera solo
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }
    
    public Usuario(int id, String nombre, String correo, String password) {
        this.id = id; //aqui si quiero pasarle el id pq se genera solo
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", password=" + password + ", correo=" + correo + '}';
    }
}
