package br.com.vitoria.builder;

public class Demo {
    public static void main(String[] args) {
//        Gerente gerente = new Gerente(new CheeseBurgerBuilder());
        Gerente gerente = new Gerente();
        gerente.setBuilder(new CheeseBurgerBuilder());
        Burger burger = gerente.buildBuilder();
        burger.print();

//        Gerente gerente1 = new Gerente(new VeganBurgerBuilder());
        Burger burger1 = gerente.buildBuilder();
        burger1.print();
    }
}
