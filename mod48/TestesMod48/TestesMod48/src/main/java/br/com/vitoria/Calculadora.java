package br.com.vitoria;

/**
 * Essa classe chamada calculadora tem 4 métodos que
 * fazem as operações básicas (somar, subtrair, multiplicar e dividir).
 * Cada função tem a entrada de dois parâmetros inteiros e retorno do resultado.
 * A classe também dois métodos auxiliares para verificação de condição.
 */
public class Calculadora {
    
    public Calculadora() {}

    public int adicionar(int a, int b) {
        
        if(valorAEhIgualZero(a)) {
            return b;
        }

        if(valorBEhIgualZero(b)) {
            return a;
        }
        
        return a + b;
    }
    
    public int subtrair(int a, int b) {
        if(valorAEhIgualZero(a)) {
            return b;
        }

        if(valorBEhIgualZero(b)) {
            return a;
        }

        return a - b;
    }
    
    public int multiplicar(int a, int b) {
        if(valorAEhIgualZero(a)) {
            return 0;
        }

        if(valorBEhIgualZero(b)) {
            return 0;
        }

        return a * b;
    }
    
    public int dividir(int a, int b) {

        if(valorAEhIgualZero(a)) {
            return 0;
        }

        if(valorBEhIgualZero(b)) {
            throw new RuntimeException("O dividor não pode ser zero.");
        }

        return a / b;
    }
    
    public boolean valorAEhIgualZero(int valorA) {
        return valorA == 0;
    }

    public boolean valorBEhIgualZero(int valorB) {
        return valorB == 0;
    }
}
