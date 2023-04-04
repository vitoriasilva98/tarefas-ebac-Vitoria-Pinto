package br.com.vitoriapinto;

public class Exemplos2 {

    public static void main(String[] args) {
        int num1 = 10;
        short num2 = (short) num1; // Casting explícito

        long numL = 1111111111111111111l;
        System.out.println(numL);
        int numI = (int) numL; // Explícito
        System.out.println(numI);

        int idade = 10;
        long idadeL = idade; // Implícito

        byte b = 1;
        short s = b; // Implícito

        byte b1 = (byte) s; // Explícito
        int i = b1; // Implícito

        int i1 = 1;
        byte s1 = (byte) i1;  // Explícito
        long l = i1; // Implícito

        long l1 = 1010101;
        short l2 = (short) l1; // Explícito
        double d = l1; // Implícito

        double d1 = 1.0;
        long l3 = (long) d1;
    }
}
