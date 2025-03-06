package com.example.LibreriasAPI.repository;

import com.example.LibreriasAPI.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//los metodos por defecto me los da el JPA repository (persist, merge, save, list...) por lo que aquí metemos los métodos adicionales...
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findByTitulo(String titulo);

    List<Libro> findByListaLibreriasId(int libreriaId);

}
