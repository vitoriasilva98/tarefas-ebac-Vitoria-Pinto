package br.com.vitoria.estrutura;

public class ListaEncadeada {

    private Node head;
    private int countNode;

    public ListaEncadeada() {
        this.countNode = 0;
    }

    public void push(Node newNode) {

        if (this.head == null) {
            this.head = newNode;
            countNode++;
            return;
        } else {
            Node last = head;

            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
            countNode++;
        }
    }

    public Node pop() {
        if (this.head != null) {

            Node returnLastNode;

            if (head.next == null) {
                returnLastNode = head;
                head = null;
                countNode--;
                return returnLastNode;
            }

            Node last = this.head;
            while (last.next.next != null) {
                last = last.next;
            }

            returnLastNode = last.next;
            last.next = null;
            countNode--;

            return returnLastNode;
        }
        return null;
    }

    public void insert(int index, Node newNode) {
        if (size() > 0) {

            if (index <= (size() - 1) && index >= 0) {

                if (index == 0) {
                    newNode.next = head.next;
                    this.head = newNode;
                    return;
                }

                int countPosicao = 0;
                Node nodeAtual = this.head;
                Node nodeAnterior = this.head;

                while (nodeAtual != null && countPosicao < index) {
                    if(countPosicao == (index - 1)) {
                        nodeAnterior = nodeAtual;
                    }

                    countPosicao++;
                    nodeAtual = nodeAtual.next;
                }

                if (nodeAtual == null) {
                    throw new IndexOutOfBoundsException("Índice fora dos limites");
                }

                newNode.next = nodeAtual.next;
                nodeAnterior.next = newNode;

            } else {
                System.out.println("\nPosição inexistente - Será adicionado ao final");
                push(newNode);
            }

        } else {
            System.out.println("Lista vazia");
        }
    }

    public void remove(int index) {
        if (size() > 0) {

            if (index <= (size() - 1) && index >= 0) {

                if (head.next == null && index == 0) {
                    head = null;
                    countNode--;
                    return;
                }

                int countPosicao = 0;
                Node nodeAtual = this.head;
                Node nodeAnterior = this.head;

                while (nodeAtual != null && countPosicao < index) {
                    if(countPosicao == (index - 1)) {
                        nodeAnterior = nodeAtual;
                    }

                    countPosicao++;
                    nodeAtual = nodeAtual.next;
                }

                if (nodeAtual == null) {
                    throw new IndexOutOfBoundsException("Índice fora dos limites");
                }

                nodeAnterior.next = nodeAtual.next;
                countNode--;

            } else {
                System.out.println("\nPosição inexistente");
            }

        } else {
            System.out.println("Lista vazia");
        }
    }

    public Node elementAt(int index) {

        Node element = null;

        if (size() > 0) {
            if (index <= (size() - 1) && index >= 0) {

                if (index == 0) {
                    element = head;
                } else {
                    int countPosicao = 0;
                    Node nodeAtual = this.head;

                    while (nodeAtual != null && countPosicao < index) {
                        countPosicao++;
                        nodeAtual = nodeAtual.next;
                    }

                    if (nodeAtual == null) {
                        throw new IndexOutOfBoundsException("Índice fora dos limites");
                    }

                    element = nodeAtual;
                }

            } else {
                System.out.println("\nPosição inexistente");
            }

        } else {
            System.out.println("Lista vazia");
        }
        return element;
    }

    public int size() {
        return countNode;
    }

    public void printList() {
        if (this.head != null) {
            System.out.println("\nLista encadeada");

            Node nodeAtual = this.head;
            while (nodeAtual != null) {
                System.out.print(nodeAtual.data + " ");
                nodeAtual = nodeAtual.next;
            }
        } else {
            System.out.println("\nLista vazia");
        }
    }
}
