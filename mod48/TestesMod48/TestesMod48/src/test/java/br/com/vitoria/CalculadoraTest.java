package br.com.vitoria;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {

    @Test
    public void quandoChamarAdicionar_RetornarAdicao() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.adicionar(10, 10);

        assertEquals(20, resultado);
    }

    @Test
    public void quandoChamarAdicionar_RetornarValorB() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.adicionar(0, 10);

        assertEquals(10, resultado);
    }

    @Test
    public void quandoChamarAdicionar_RetornarValorA() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.adicionar(50, 0);

        assertEquals(50, resultado);
    }

    @Test
    public void quandoChamarSubtrair_RetornarSubtracao() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.subtrair(15, 10);

        assertEquals(5, resultado);
    }

    @Test
    public void quandoChamarSubtrair_RetornarValorB() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.subtrair(0, 10);

        assertEquals(10, resultado);
    }

    @Test
    public void quandoChamarSubtrair_RetornarValorA() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.subtrair(50, 0);

        assertEquals(50, resultado);
    }

    @Test
    public void quandoChamarMultiplicar_RetornarMultiplicao() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicar(3, 9);

        assertEquals(27, resultado);
    }

    @Test
    public void quandoChamarMultiplicar_RetornarValorB() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicar(0, 10);

        assertEquals(0, resultado);
    }

    @Test
    public void quandoChamarMultiplicar_RetornarValorA() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicar(50, 0);

        assertEquals(0, resultado);
    }

    @Test
    public void quandoChamarDividir_RetornarDivisao() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.dividir(15, 5);

        assertEquals(3, resultado);
    }

    @Test
    public void quandoChamarDividir_RetornarZeroSeODividendoForZero() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.dividir(0, 10);

        assertEquals(0, resultado);
    }
}
