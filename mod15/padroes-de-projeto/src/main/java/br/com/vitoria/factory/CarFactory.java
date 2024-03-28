package br.com.vitoria.factory;

public class CarFactory extends Factory {
    @Override
    Car retrieveCar(String requestGrade) {
        switch(requestGrade) {
            case "A":
                return new Volkswagem(100, "full", "blue");
            case "B":
                return new Toyota(900, "full", "red");
            default:
                System.out.println("The request car was unfortunately not available.");
                return null;
        }
    }
}
