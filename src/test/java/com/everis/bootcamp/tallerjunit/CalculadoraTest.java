package com.everis.bootcamp.tallerjunit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraTest {
	
	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("Entramos en el @BeforeClass");
	}
	
	@Before
	public void testBefore() {
		System.out.println("Entramos en el @Before");
	}
	
	@Test
	public void testSuma() {
		System.out.println("*testSuma\n");
		Calculadora calc = new Calculadora();
		double res = calc.sum(1, 1);
		assertEquals(2, res, 0);
	}
	
	@After
	public void testAfter() {
		System.out.println("Entramos en el @After");
	}
	@AfterClass
	public static void testAfterClass() {
		System.out.println("Entramos en el @AfterClass");
	}
	@Test
	public void testSub() {
		System.out.println("*testSub\n");
		Calculadora calc = new Calculadora();
		double res = calc.sub(1, 1);
		assertEquals(0, res, 0);
	}
	@Test
	public void testDiv() {
		System.out.println("*testDiv\n");
		Calculadora calc = new Calculadora();
		double res = calc.div(1, 0);
		assertEquals(-1, res, 0);
	}
	
	@Test
	public void testMul() {
		System.out.println("*testMul\n");
		Calculadora calc = new Calculadora();
		double res = calc.mult(2, 2);
		assertEquals(4, res, 0);
	}

}
