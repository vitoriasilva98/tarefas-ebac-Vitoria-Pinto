package br.com.vitoriapinto;

public class Exemplo1 {
    public static void main(String[] args) {

        Boolean status = true; // Boxing
        Boolean status1 = Boolean.TRUE; // Autoboxing

        Character c = 'A';

        Integer idade = 10;
        Long cpf = 12345678910l;
        Long cpf1 = Long.valueOf(12345678910l);

        // Unboxing
        boolean status2 = Boolean.TRUE;
        char letra = Character.valueOf('A');
        int idade2 = Integer.valueOf(12);
        long cpf3 = Long.valueOf(12346);
    }
}