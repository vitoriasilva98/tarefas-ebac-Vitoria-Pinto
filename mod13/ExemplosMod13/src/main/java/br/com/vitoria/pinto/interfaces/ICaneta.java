package br.com.vitoria.pinto.interfaces;

public interface ICaneta {

    public void escrever(String texto);
    public String getCor();

    // A partir do java 8 foi adicionado essa implementação a interface
    // onde é possível criar um método com lógica dentro da interface
    // é um método "default", um método padrão, não sendo necessário implmentar
    // nas classes que utilizam a interface.
    default void escreverComumATodas() {
        System.out.println("Escrita igual a todas");
    }
}
