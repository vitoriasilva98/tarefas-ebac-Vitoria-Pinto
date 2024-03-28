package br.com.vitoria.singleton;

public class DemoSingletonPropriedadeSyncronized {

    public static void main(String[] args) {
        Thread t1 = new Thread(new DemoSingletonPropriedadeThread.ThreadFoo()); //
        Thread t2 = new Thread(new DemoSingletonPropriedadeThread.ThreadBar());
        t1.start();
        t2.start();
    }

    // Classe interna
    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            SingletonPropriedade singleton = SingletonPropriedade.getInstance("Teste");
            System.out.println(singleton.getValue());
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            SingletonPropriedade singleton = SingletonPropriedade.getInstance("Teste1");
            System.out.println(singleton.getValue());
        }
    }
}
