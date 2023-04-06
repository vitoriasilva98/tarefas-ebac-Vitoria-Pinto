package br.com.vitoriapinto.switchcase;

import java.util.Scanner;

public class ExemploAnimal {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o nome de um animal: ");
        String texto = s.next();
        String animal = exampleOfIf(texto);
        System.out.println(animal);
    }

    private static String exampleOfIf(String animal) {
        String result;
        switch (animal){
            case "DOG":
            case "CAT":
                result = "domestic animal";
                break;
            case "TIGER":
                result = "wild animal";
                break;
            default:
                result = "unknown animal";
                break;
        }

        return result;
    }
}
