package br.com.vitoriapinto;

import java.util.Scanner;

/**
 * @author Vitória Pinto
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer opcao;
        do {
            System.out.println("Deseja realizar o cáculo de média de um aluno? " +
                    "\nDigite 1 - SIM \nDigite 2 - NÃO");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    calculandoMedia(registrandoAluno(scanner));
                    break;
                case 2:
                    System.out.println("Até logo");
                    break;
                default:
                    System.out.println("Número inválido!");
                    break;
            }
        } while (opcao != 2);
    }

    /**
     * O método registra um aluno
     *
     * @param scanner
     * @return Aluno
     */
    public static Aluno registrandoAluno(Scanner scanner) {
        Aluno aluno = new Aluno();

        System.out.println("********************* EBAC: Registrando Aluno *********************");

        do {
            System.out.println("Digite a matrícula do aluno: ");
            aluno.setMatricula(scanner.nextInt());
        } while (aluno.getMatricula() == 0 || aluno.getMatricula() == null || aluno.getMatricula() > 1000);

        do {
            System.out.println("Digite o nome do aluno: ");
            aluno.setNome(scanner.nextLine().trim()); // O método trim remove os caracteres vázios
        } while (aluno.getNome().equals(""));

        do {
            System.out.println("Digite o nome da matéria: ");
            aluno.setMateria(scanner.nextLine().trim()); // O método trim remove os caracteres vázios
        } while (aluno.getMateria().equals(""));

        do {
            System.out.println("Digite a 1ª nota: ");
            aluno.setNota1(scanner.nextDouble());
        } while (aluno.getNota1() > 10);

        do {
            System.out.println("Digite a 2ª nota: ");
            aluno.setNota2(scanner.nextDouble());
        } while (aluno.getNota2() > 10);

        do {
            System.out.println("Digite a 3ª nota: ");
            aluno.setNota3(scanner.nextDouble());
        } while (aluno.getNota3() > 10);

        do {
            System.out.println("Digite a 4ª nota: ");
            aluno.setNota4(scanner.nextDouble());
        } while (aluno.getNota4() > 10);


        return aluno;
    }

    /**
     * O método calcula a média do aluno
     *
     * @param aluno
     */
    private static void calculandoMedia(Aluno aluno) {

        Double media = (aluno.getNota1() + aluno.getNota2() + aluno.getNota3() + aluno.getNota4()) / 4;
        String situacao;

        if (media >= 7) {
            situacao = " foi APROVADO(A)";
        } else if (media >= 5) {
            situacao = " está de RECUPERAÇÃO";
        } else {
            situacao = " foi REPROVADO(A)";
        }

        System.out.println("********************* EBAC: Cáculo de média *********************");
        System.out.println("O(A) aluno(a) " + aluno.getNome() + situacao + " com a média de "
                + media + " \nna matéria de " + aluno.getMateria());
        System.out.println("*****************************************************************\n");
    }
}