package br.com.vitoria.pinto.abstratas;

public class Horista extends Empregado {

    private Double precoHora;
    private Double totalHorasTrabalhadas;

    public Double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(Double precoHora) {
        this.precoHora = precoHora;
    }

    public Double getTotalHorasTrabalhadas() {
        return totalHorasTrabalhadas;
    }

    public void setTotalHorasTrabalhadas(Double totalHorasTrabalhadas) {
        this.totalHorasTrabalhadas = totalHorasTrabalhadas;
    }

    @Override
    public Double vencimento() {
        return precoHora * totalHorasTrabalhadas;
    }
}
