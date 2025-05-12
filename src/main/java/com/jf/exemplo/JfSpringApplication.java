package com.jf.exemplo;

import com.jf.exemplo.domain.Categoria;
import com.jf.exemplo.domain.Produto;
import com.jf.exemplo.repositories.CategoriaRepository;
import com.jf.exemplo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JfSpringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
		SpringApplication.run(JfSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto prod1 = new Produto(null, "Computador", 1000.00);
		Produto prod2 = new Produto(null, "Impressora", 500.00);
		Produto prod3 = new Produto(null, "Mouse", 20.00);

		cat1.getProdutos().addAll(List.of(prod1, prod2, prod3));
		cat2.getProdutos().addAll(List.of(prod2));

		prod1.getCategorias().addAll(List.of(cat1));
		prod2.getCategorias().addAll(List.of(cat1, cat2));
		prod3.getCategorias().addAll(List.of(cat1));



		categoriaRepository.saveAll(List.of(cat1, cat2));
		produtoRepository.saveAll(List.of(prod1, prod2, prod3));
	}
}
