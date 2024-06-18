package br.com.vitoria.exercicio;

import java.util.ArrayList;
import java.util.List;

public class Exercicio1 {
    public static List<List<Integer>> subsetsOfSizeN(int[] S, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(S, n, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] S, int n, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < S.length; i++) {
            current.add(S[i]);
            backtrack(S, n, i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        int[] S1 = {1, 2, 3};
        int n1 = 2;
        System.out.println("Subsets of size " + n1 + " from S1:");
        System.out.println(subsetsOfSizeN(S1, n1));

        int[] S2 = {1, 2, 3, 4};
        int n2 = 1;
        System.out.println("Subsets of size " + n2 + " from S2:");
        System.out.println(subsetsOfSizeN(S2, n2));

        int[] S3 = {1, 2, 3, 4, 5, 6, 7, 8};
        int n3 = 3;
        System.out.println("Subsets of size " + n3 + " from S3:");
        System.out.println(subsetsOfSizeN(S3, n3));
    }
}
