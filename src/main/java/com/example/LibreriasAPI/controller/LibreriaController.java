package com.example.LibreriasAPI.controller;

import com.example.LibreriasAPI.model.Libreria;
import com.example.LibreriasAPI.service.LibreriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("librerias")
public class LibreriaController {
    @Autowired
    private LibreriaService libreriaService;

    @PostMapping("/add")
    public ResponseEntity<Libreria> addLibreria(@RequestBody Libreria libreria) {
        return new ResponseEntity<>(libreriaService.agregarLibreria(libreria), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Libreria>> getAllLibrerias() {
        return new ResponseEntity<>(libreriaService.getAllLibrerias(), HttpStatus.OK);
    }

    @PostMapping("/{libreriaId}/addLibro/{libroId}")
    public ResponseEntity<Libreria> agregarLibroALibreria(@PathVariable int libreriaId, @PathVariable int libroId) {
        Libreria libreria = libreriaService.agregarLibroALibreria(libreriaId, libroId);
        return (libreria != null) ? new ResponseEntity<>(libreria, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
