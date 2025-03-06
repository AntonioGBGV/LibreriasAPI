package com.example.LibreriasAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="librerias")

public class Libreria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String duenio;
    @Column
    private String direccion;

    @ManyToMany(mappedBy = "listaLibrerias", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Libro> listaLibros = new ArrayList<>();

    public Libreria(String nombre, String duenio, String direccion) {
        this.nombre = nombre;
        this.duenio = duenio;
        this.direccion = direccion;
    }

    public Libreria() {
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

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", duenio='" + duenio + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
