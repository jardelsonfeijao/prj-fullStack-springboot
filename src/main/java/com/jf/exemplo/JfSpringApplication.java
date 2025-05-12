package com.jf.exemplo;

import com.jf.exemplo.domain.Categoria;
import com.jf.exemplo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JfSpringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

    public JfSpringApplication(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(JfSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		categoriaRepository.saveAll(List.of(cat1, cat2));

	}
}
