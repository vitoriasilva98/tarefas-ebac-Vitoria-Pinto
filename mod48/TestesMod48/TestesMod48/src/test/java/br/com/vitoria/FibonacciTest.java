package br.com.vitoria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {
    @Test
    public void fibonacciZero() {
        Fibonacci fib = new Fibonacci();
        assertEquals(0, fib.fibonacci(0), "Fibonacci de 0 deve ser 0");
    }

    @Test
    public void fibonacciUm() {
        Fibonacci fib = new Fibonacci();
        assertEquals(1, fib.fibonacci(1), "Fibonacci de 1 deve ser 1");
    }

    @Test
    public void fibonacciDez() {
        Fibonacci fib = new Fibonacci();
        assertEquals(55, fib.fibonacci(10), "Fibonacci de 10 deve ser 55");
    }

    @Test
    public void fibonacciCinco() {
        Fibonacci fib = new Fibonacci();
        assertEquals(5, fib.fibonacci(5), "Fibonacci de 5 deve ser 5");
    }
}
