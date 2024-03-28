package br.com.vitoria.builder;

public class Gerente {

    BurgerBuilder builder;

//    public Gerente(BurgerBuilder buider) {
//        this.builder = buider;
//    }


    public void setBuilder(BurgerBuilder builder) {
        this.builder = builder;
    }

    public Burger buildBuilder() {
        builder.buildBun();
        builder.buildMeat();
        builder.buildSalad();
        builder.buildCheese();
        builder.buildSauce();

        return builder.build();
    }
}
