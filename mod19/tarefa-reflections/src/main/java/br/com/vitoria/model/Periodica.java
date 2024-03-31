package br.com.vitoria.model;

import br.com.vitoria.annotaions.Tabela;

@Tabela(nome = "Periodica")
public class Periodica {
    private Integer numero;
    private String simboloQuimico;
    private String nome;
    private Double pesoAtomico;
}
