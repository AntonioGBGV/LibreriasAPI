package com.example.LibreriasAPI.controller;

import com.example.LibreriasAPI.model.Editorial;
import com.example.LibreriasAPI.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {
    @Autowired
    private EditorialService editorialService;

    @PostMapping("/add")
    public ResponseEntity<Editorial> addEditorial(@RequestBody Editorial editorial) {
        return new ResponseEntity<>(editorialService.agregarEditorial(editorial), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Editorial>> getAllEditoriales() {
        return new ResponseEntity<>(editorialService.getAllEditoriales(), HttpStatus.OK);
    }
}
