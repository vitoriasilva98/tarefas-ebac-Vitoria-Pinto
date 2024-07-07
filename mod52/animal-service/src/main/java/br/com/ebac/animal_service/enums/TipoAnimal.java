package br.com.ebac.animal_service.enums;

public enum TipoAnimal {
    CACHORRO("Cachorro"),
    GATO("Gato"),
    PASSARO("Passáro");

    private String nome;

    private TipoAnimal(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
