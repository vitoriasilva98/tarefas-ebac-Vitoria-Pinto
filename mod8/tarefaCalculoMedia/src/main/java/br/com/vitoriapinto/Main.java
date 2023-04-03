package br.com.vitoriapinto;

/**
 * @author Vitória Pinto
 */

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(001, "João da Silva", "Matemática",
                5.5,6.0,7.8,9.0);
        calculoMedia(aluno1);
    }

    /**
     *
     * Método calcula a média do aluno
     *
     * @param aluno
     */
    private static void calculoMedia(Aluno aluno) {

        Double media = (aluno.getNota1() + aluno.getNota2() + aluno.getNota3() + aluno.getNota4()) / 4;

        System.out.println("************ Média Geral ************");
        System.out.println("O aluno " + aluno.getNome() + " obteve a média de "
                + media + " na matéria de " + aluno.getMateria());
    }
}