package com.example.LibreriasAPI.service;

import com.example.LibreriasAPI.model.Autor;

import java.util.List;

public interface AutorService {
    Autor agregarAutor (Autor autor);

    List<Autor> getAllAutores();
}
