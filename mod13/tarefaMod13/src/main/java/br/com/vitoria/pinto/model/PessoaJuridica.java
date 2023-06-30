package br.com.vitoria.pinto.model;

public class PessoaJuridica extends Pessoa {

    private String nomeEmpresa;
    private String cnpj;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + "Nome da Empresa: " + nomeEmpresa + "\n"
                + "CNPJ: " + cnpj;
    }
}
