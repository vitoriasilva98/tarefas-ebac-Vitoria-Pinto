package br.com.ebac.animal_service.dto;

public class FuncionarioDTO {

    private String nome;
    private Long qtdResgate;

    public FuncionarioDTO(String nome, Long qtdResgate) {
        this.nome = nome;
        this.qtdResgate = qtdResgate;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQtdResgate() {
        return qtdResgate;
    }

    public void setQtdResgate(Long qtdResgate) {
        this.qtdResgate = qtdResgate;
    }
}
