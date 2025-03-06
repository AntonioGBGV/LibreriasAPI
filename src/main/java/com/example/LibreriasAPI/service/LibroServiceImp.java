package com.example.LibreriasAPI.service;

import com.example.LibreriasAPI.model.Autor;
import com.example.LibreriasAPI.model.Editorial;
import com.example.LibreriasAPI.model.Libro;
import com.example.LibreriasAPI.repository.AutorRepository;
import com.example.LibreriasAPI.repository.EditorialRepository;
import com.example.LibreriasAPI.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImp implements LibroService{
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public Libro agregarLibro(Libro libro) {
        Autor autor = autorRepository.findById(libro.getAutor().getId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Editorial editorial = editorialRepository.findById(libro.getEditorial().getId())
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));
        libro.setAutor(autor);
        libro.setEditorial(editorial);
       return libroRepository.save(libro);
    }

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public List<Libro> getLibrosPorLibreria(int libreriaId) {
        return libroRepository.findByListaLibreriasId(libreriaId);
    }
}
