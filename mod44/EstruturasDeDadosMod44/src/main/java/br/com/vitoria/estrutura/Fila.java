package br.com.vitoria.estrutura;

import java.util.Arrays;

public class Fila {

    private Integer[] fila;
    private Integer sizeFila;

    public Fila(Integer valueFila) {
        if (valueFila != null) {
            this.fila = new Integer[valueFila];
            sizeFila = 0;
        }
    }

    public void enqueue(Integer value) {
        if (sizeFila < fila.length) {
            if (sizeFila == 0) {
                this.fila[sizeFila] = value;
                sizeFila++;
            } else {
                this.fila[sizeFila] = value;
                sizeFila++;
            }
        } else {
            System.out.println("\nFila cheia!");
        }
    }

    public void dequeue() {
        if(!isEmpty()) {
            for (int i = 0; i < sizeFila - 1; i++) {
                this.fila[i] = this.fila[i + 1];
            }

            this.fila[sizeFila - 1] = null;
            sizeFila--;

        } else {
            System.out.println("\nA fila está vazia");
        }
    }

    public Integer rear() {
        if(!isEmpty()) {
            return this.fila[sizeFila - 1];
        } else {
            System.out.println("\nA fila está vazia");
        }
        return -1;
    }

    public Integer front() {
        if(!isEmpty()) {
            return this.fila[0];
        } else {
            System.out.println("\nA fila está vazia");
        }
        return -1;
    }

    public Integer size() {
        return sizeFila;
    }

    public boolean isEmpty() {
        if(sizeFila == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nFila{" +
                "fila=" + Arrays.toString(fila) +
                '}';
    }
}
