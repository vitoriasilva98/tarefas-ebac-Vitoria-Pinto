package br.com.vitoriapinto.ifelse;

public class ExemploPPT2 {
    public static void main(String[] args) {
        int result = 0;

        if (result > 1 && result < 5) {
            System.out.println("Resultado está entre 1 e 5");
        } else if (result >= 5 && result < 8){
            System.out.println("Resultado está entre 5 e 8");
        } else {
            System.out.println("Resultado diferente dos anteriores");
        }
    }
}
