package br.com.vitoriapinto;

/**
 *
 * @author Vitória Pinto
 */

public class Carro {

    private Integer codigo;
    private String fabricante;
    private String modelo;
    private String placa;
    private String cor;
    private Integer anoLancamento;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    /**
     * Método imprime as informações do Veículo
     */
    public void imprimirInformacaoVeiculo() {
        System.out.println("******* Informações do Veículo *******");
        System.out.println("* Código: " + this.codigo);
        System.out.println("* Fabricante: " + this.fabricante);
        System.out.println("* Modelo: " + this.modelo);
        System.out.println("* Placa: " + this.placa);
        System.out.println("* Cor: " + this.cor);
        System.out.println("* Ano de Lançamento: " + this.anoLancamento);
        System.out.println("**************************************");
    }

    /**
     * Método atualiza a placa para o novo padrão Mercosul
     *
     * @param novaPlaca Código da nova placa
     */
    public void mudarPlacaParaPadraoMercosul(String novaPlaca){
        setPlaca(novaPlaca);
        System.out.println("********** Placa atualizada! **********");
    }
}
