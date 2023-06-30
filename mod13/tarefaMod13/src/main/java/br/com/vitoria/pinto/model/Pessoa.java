package br.com.vitoria.pinto.model;

public abstract class Pessoa {

    private String nome;
    private String sobrenome;

    private String sexo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Sobrenome: " + sobrenome + "\n" +
                "Sexo: " + sexo + "\n";
    }
}
