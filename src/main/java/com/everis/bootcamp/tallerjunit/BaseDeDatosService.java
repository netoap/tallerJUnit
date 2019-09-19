package com.everis.bootcamp.tallerjunit;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BaseDeDatosService {	
	List<Articulo> lista = Arrays.asList(
		new Articulo(1L,"Apple", 100D),
		new Articulo(2L,"Pera", 100D),
		new Articulo(3L,"Manga", 100D),
		new Articulo(4L,"Banana", 100D),
		new Articulo(5L,"Melao", 100D)
	);
	
	public Articulo findArticleById(Long id) {
		Optional<Articulo> articulo = lista.stream().filter(x->x.getId().equals(id)).findFirst();		
		return articulo.isPresent() ? articulo.get() : null;
	}
	
	
}
