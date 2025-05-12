package com.jf.exemplo.services;

import com.jf.exemplo.domain.Categoria;
import com.jf.exemplo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer ID) {
        return categoriaRepository.findById(ID).orElse(null);
    }
}