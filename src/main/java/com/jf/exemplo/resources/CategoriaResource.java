package com.jf.exemplo.resources;

import com.jf.exemplo.domain.Categoria;
import com.jf.exemplo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{ID}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable("ID") Integer ID) {
        Categoria obj = categoriaService.buscar(ID);
        return ResponseEntity.ok().body(obj);
    }
}
