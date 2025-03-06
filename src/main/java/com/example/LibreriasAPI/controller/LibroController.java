package com.example.LibreriasAPI.controller;

import com.example.LibreriasAPI.model.Libro;
import com.example.LibreriasAPI.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("libros")

public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping("/add")
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro libro) {
        return new ResponseEntity<>(libroService.agregarLibro(libro), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Libro>> getAllLibros() {
        return new ResponseEntity<>(libroService.getAllLibros(), HttpStatus.OK);
    }

    @GetMapping("/getByLibreria/{id}")
    public ResponseEntity<List<Libro>> getLibrosPorLibreria(@PathVariable int id) {
        return new ResponseEntity<>(libroService.getLibrosPorLibreria(id), HttpStatus.OK);
    }
}
