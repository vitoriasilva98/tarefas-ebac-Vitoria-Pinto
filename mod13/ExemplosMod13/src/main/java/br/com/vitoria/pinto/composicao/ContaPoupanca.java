package br.com.vitoria.pinto.composicao;

public class ContaPoupanca {

    private Banco banco;
    private Double saldo;

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
