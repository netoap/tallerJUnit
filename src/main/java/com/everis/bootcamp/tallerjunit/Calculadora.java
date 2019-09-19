package com.everis.bootcamp.tallerjunit;

public class Calculadora {
	
	public Calculadora(){}
	
	public double sum(double a, double b) {
		return a + b;
	}
	public double sub(double a, double b) {
		return a - b;
	}
	public double div(double a, double b) {
		return b!=0 ? a/b : -1;
	}
	public double mult(double a, double b) {
		return a*b;
	}	

}
