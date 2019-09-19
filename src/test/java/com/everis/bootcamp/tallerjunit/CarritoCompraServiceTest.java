package com.everis.bootcamp.tallerjunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceTest {
	
	@InjectMocks
	static CarritoCompraService carrito;
	
	Articulo articulo; 
	
	@Mock
	BaseDeDatosService bdservice;
	
	@BeforeClass
    public static void setup() {
		carrito = new CarritoCompraService();
    }
	
	@Before
	public void metodoDeInicializacion () {
		
		articulo = new Articulo("Apple", 2.2);		
		//Mockito.when(bdservice.findArticleById(1L)).thenReturn(new Articulo(1L,"Este articulo está mockeado",10D));
		Mockito.when(bdservice.findArticleById(100L)).thenReturn(new Articulo(100L,"Este articulo está mockeado",10D));
	}
	
	@Test
	public void addArticuloTest() {
		System.out.println("addArticuloTest");
		double sizeB= carrito.getArticulos().size();		
		carrito.addArticulo(articulo);
		double sizeF= carrito.getArticulos().size();
		assertTrue(sizeF > sizeB);
	}
	
	@Test
	public void comprobarTotalPriceTest() {
		System.out.println("comprobarTotalPriceTest");
		carrito.limpiarCesta();
		carrito.addArticulo(new Articulo("Apple", 2D));
		carrito.addArticulo(new Articulo("Pera", 2D));
		carrito.addArticulo(new Articulo("Manga", 2D));
		carrito.addArticulo(new Articulo("Banana", 2D));
		carrito.addArticulo(new Articulo("Melao", 2D));
		assertEquals(10, carrito.totalPrice(), 0);		
	}

	@Test
	public void limpiarCestaTest() {
		System.out.println("limpiarCestaTest");
		carrito.addArticulo(articulo);
		carrito.limpiarCesta();
		int sizeOfListArticulo = carrito.getNumArticulo();		
		assertTrue(sizeOfListArticulo == 0);
	}
	
	@Test
	public void calculadorDescuentoTest() {
		double desconto = CarritoCompraService.calculadorDescuento(100, 10);
		assertEquals(90, desconto,0);
	}
	
	@Test
	public void setArticulosTest() {
		carrito.limpiarCesta();
		List<Articulo> listA = Arrays.asList(new Articulo("Apple", 2D),new Articulo("Apple", 2D),new Articulo("Manga", 2D));
		carrito.setArticulos(listA);
		assertEquals(listA, carrito.getArticulos());
	}
	
	@Test
	public void precioArticuloComDescontoTest(){	
		System.out.println("precioArticuloComDescontoTest");
		double actual = carrito.precioArticuloComDesconto(100L, 10);
		assertEquals(9, actual,0);
	}
	

//	@Test
//	public void aplicarDescuentoTeste() {
//		double descuento = carrito.aplicarDescuento(1L, 5D);
//		System.out.println("Precio total ---> " + descuento);
//		assertEquals(descuento, 0.95d, 0);
//	}
	
}
