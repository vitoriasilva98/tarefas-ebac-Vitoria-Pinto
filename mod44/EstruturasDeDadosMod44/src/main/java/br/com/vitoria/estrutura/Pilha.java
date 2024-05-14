package br.com.vitoria.estrutura;

public class Pilha {

    private Integer[] pilha;
    private Integer countPilha;

    public Pilha(Integer valuePilha) {
        if (valuePilha != null) {
            this.pilha = new Integer[valuePilha];
            this.countPilha = 0;
        }
    }

    public void push(Integer value) {
        if (countPilha < pilha.length) {
            if (this.countPilha == 0) {
                this.pilha[countPilha] = value;
                countPilha++;
            } else {
                for(int i = size(); i > 0; i--) {
                    this.pilha[i] = this.pilha[i - 1];
                }
                this.pilha[0] = value;
                countPilha++;
            }
        } else {
            System.out.println("\nPilha cheia!");
        }
    }

    public Integer pop() {
        if (countPilha > 0) {
            Integer valueTop = this.pilha[0];
            countPilha--;

            for(int i = 0; i < countPilha; i++) {
                this.pilha[i] = this.pilha[i + 1];
            }

            this.pilha[countPilha] = null;

            return valueTop;
        }
        return -1;
    }

    public Integer top() {
        if (countPilha > 0) {
            return this.pilha[0];
        }
        return -1;
    }

    public boolean isEmpty() {

        if (countPilha == 0) {
            return true;
        }
        return false;
    }

    public Integer size() {
        return countPilha;
    }

    public void printPilha() {
        System.out.println("Pilha");
        for(int i = 0; i < countPilha; i++) {
            System.out.println("|" + pilha[i] + "|");
        }
    }
}
