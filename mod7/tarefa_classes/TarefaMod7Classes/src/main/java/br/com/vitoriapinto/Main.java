package br.com.vitoriapinto;

public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        carro1.setCodigo(1);
        carro1.setFabricante("Hyundai");
        carro1.setModelo("HB20");
        carro1.setPlaca("ABC-1234");
        carro1.setCor("Preto");
        carro1.setAnoLancamento(2018);

        carro1.imprimirInformacaoVeiculo();
        carro1.mudarPlacaParaPadraoMercosul("ABC1D23");
        carro1.imprimirInformacaoVeiculo();
    }
}