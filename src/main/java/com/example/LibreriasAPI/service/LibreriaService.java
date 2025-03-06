package com.example.LibreriasAPI.service;

import com.example.LibreriasAPI.model.Libreria;

import java.util.List;

public interface LibreriaService {
    Libreria agregarLibreria(Libreria libreria);

    List<Libreria> getAllLibrerias();

    Libreria agregarLibroALibreria(int libreriaId, int libroId);
}
