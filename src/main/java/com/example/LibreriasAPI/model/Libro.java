package com.example.LibreriasAPI.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name= "libros")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @Column
    private Double precio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_autor")
    private Autor autor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_editorial")
    private Editorial editorial;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "colecciones",
            joinColumns = @JoinColumn(name = "id_libro"),
            inverseJoinColumns = @JoinColumn(name = "id_libreria"))
    private List<Libreria> listaLibrerias = new ArrayList<>();


    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public Libro(int id, String titulo, Double precio) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
    }

    public Libro(String titulo, Double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

    public Libro() {
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public List<Libreria> getListaLibrerias() {
        return listaLibrerias;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public void setListaLibrerias(List<Libreria> listaLibrerias) {
        this.listaLibrerias = listaLibrerias;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
