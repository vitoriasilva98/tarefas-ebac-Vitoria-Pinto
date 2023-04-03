package org.example;

public class Exemplos {

//    Tipos primitivos em Java
    private int codigo = 1;
    private long codigoMaior = 1235458;
    private double valorDecimal1 = 10.1;
    private boolean status = false;
    private String texto = "gydgyudgyu";
    private float valorDecimal = 10.0f;
    private short shor;
    private byte bi;

    public Exemplos() {}

    public Exemplos(int val) {
        this.codigo = val;
    }

    public String retornaTexto() {
        this.codigo = 0; // Variável de escopo de classe - Acessível dentro da classe
        return "blá blá  blá";
    }

    public int retornaInteiro() {
        int val = 10; // Variável de escopo de método - Só acessível dentro do método
        String texto = "Texto";
        this.texto = null;
        return 10;
    }

    public long retornaLong(long num) {
        return num;
    }
}
