package com.example.LibreriasAPI.service;

import com.example.LibreriasAPI.model.Libreria;
import com.example.LibreriasAPI.model.Libro;
import com.example.LibreriasAPI.repository.LibreriaRepository;
import com.example.LibreriasAPI.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibreriaServiceImp implements LibreriaService {
    @Autowired
    private LibreriaRepository libreriaRepository;
    @Autowired
    private LibroRepository libroRepository;

    @Override
    public Libreria agregarLibreria(Libreria libreria) {
        return libreriaRepository.save(libreria);
    }

    @Override
    public List<Libreria> getAllLibrerias() {
        return libreriaRepository.findAll();
    }

    @Override
    public Libreria agregarLibroALibreria(int libreriaId, int libroId) {
        Optional<Libreria> libreriaOpt = libreriaRepository.findById(libreriaId);
        Optional<Libro> libroOpt = libroRepository.findById(libroId);

        if (libreriaOpt.isPresent() && libroOpt.isPresent()) {
            Libreria libreria = libreriaOpt.get();
            Libro libro = libroOpt.get();
            if (!libreria.getListaLibros().contains(libro)) {
                libreria.getListaLibros().add(libro);
            }
            if (!libro.getListaLibrerias().contains(libreria)) {
                libro.getListaLibrerias().add(libreria);
            }
            libroRepository.save(libro);
            libreriaRepository.save(libreria);

            return libreria;
        }
        return null;
    }
}
