package org.example;

public class Cliente {

    private Integer codigo;
    private String nome;
    private String endereco;

    public Integer getCodigo(){
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void cadastrarEndereco(String endereco) {
        setEndereco(endereco);
    }

    public void imprimirEndereco() {
        System.out.println(this.endereco);
    }

    public String retornarNomeCliente(){
        return "Endreço xxx...";
    }

    /**
     *
     * Método que faz o calculo do valor total
     *
     * @return retorna o valor total
     *
     * @deprecated
     * @see int getValorTotal(int count)
     */

    public int getValorTotal(){
        return 20;
    }

    public int getValorTotal(int count){
        return 20;
    }

}
