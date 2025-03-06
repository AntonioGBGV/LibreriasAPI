package com.example.LibreriasAPI.service;

import com.example.LibreriasAPI.model.Libro;

import java.util.List;

public interface LibroService {
    //metodos que quiero llamar desde el controller, solo se escribe la firma. Aportan la logica del negocio.
    Libro agregarLibro(Libro libro);

    List<Libro> getAllLibros();

    List<Libro> getLibrosPorLibreria(int libreriaId);
}
