package br.com.vitoria.pinto;

import br.com.vitoria.pinto.model.Pessoa;
import br.com.vitoria.pinto.model.PessoaFisica;
import br.com.vitoria.pinto.model.PessoaJuridica;

public class Main {
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Ana");
        pf.setSobrenome("Clara");
        pf.setSexo("Feminino");
        pf.setCpf("123.123.123-12");

        informarDadosPessoais(pf);

        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("Maria");
        pj.setSobrenome("Silva");
        pj.setSexo("Feminino");
        pj.setNomeEmpresa("Bolos e doces Maria");
        pj.setCnpj("11.111.111/00001-11");
        informarDadosPessoais(pj);
    }

    private static void informarDadosPessoais(Pessoa pessoa) {
        if (pessoa instanceof PessoaFisica) {
            PessoaFisica pessoaFisica = (PessoaFisica) pessoa;

            System.out.println("******** Pessoa Física ********");
            System.out.println(pessoaFisica);
            System.out.println();
        } else {
            PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;

            System.out.println("******** Pessoa Jurídica ********");
            System.out.println(pessoaJuridica);
            System.out.println();
        }
    }
}