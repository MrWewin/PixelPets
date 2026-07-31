package com.pixelpets.pixelpets_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Mascota {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String nombre;
    private String especie;
    private String rareza;
    private double precio;
    private int estadoSalud;

    // Constructor vacío (obligatorio para JPA)
    public Mascota() {
    }

    // Constructor con todos los atributos
    public Mascota(Long id, String nombre, String especie, String rareza, double precio, int estadoSalud) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.rareza = rareza;
        this.precio = precio;
        this.estadoSalud = estadoSalud;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRareza() {
        return rareza;
    }

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(int estadoSalud) {
        this.estadoSalud = estadoSalud;
    }
}