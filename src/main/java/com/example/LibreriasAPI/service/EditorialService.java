package com.example.LibreriasAPI.service;

import com.example.LibreriasAPI.model.Editorial;

import java.util.List;

public interface EditorialService {
    Editorial agregarEditorial(Editorial editorial);

    List<Editorial> getAllEditoriales();
}
