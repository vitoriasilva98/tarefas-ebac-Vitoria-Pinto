package br.com.vitoria.pinto.abstratas;

public class Programa {
    public static void main(String[] args) {

        Assalariado empregado = new Assalariado();
        empregado.setCpf("1");
        empregado.setNome("Rodrigo");
        empregado.setSobrenome("Pires");
        empregado.setSalario(100d);
        imprimir(empregado);

        Comissionado comissionado = new Comissionado();
        comissionado.setCpf("2");
        comissionado.setNome("Rodrigo 2");
        comissionado.setSobrenome("Pires");
        comissionado.setTotalVenda(1000d);
        comissionado.setTaxaComissao(01d);
        imprimir(comissionado);

        Horista horista = new Horista();
        horista.setCpf("23");
        horista.setNome("Rodrigo 23");
        horista.setSobrenome("Pires");
        horista.setPrecoHora(100d);
        horista.setTotalHorasTrabalhadas(60d);
        imprimir(horista);
    }

    public static void imprimir(Empregado empregado) {
        if (empregado instanceof Horista) {
            Horista hor = (Horista) empregado;
            System.out.println("O " +  hor.getNome() + " é um "+ hor.getClass().getSimpleName() + ", tem salário de R$: " + hor.vencimento());
        } else {
            empregado.imprimirSobrenome();
            empregado.imprimirValores();
            System.out.println(empregado.getNome() + ", tem salário de R$: " + empregado.vencimento());
        }
    }
}
