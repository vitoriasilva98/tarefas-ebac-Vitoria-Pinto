package br.com.vitoriapinto.map;

import java.util.HashMap;
import java.util.Map;

public class Mapa {

    public static void main(String[] args) {

        Map<Integer, String> usuarios = new HashMap<>();

        usuarios.put(1, "Roberto");
        usuarios.put(20, "Ricardo");
        usuarios.put(3, "Rafaela");
        usuarios.put(4, "Rebeca");

        System.out.println(usuarios.size()); // 4
        System.out.println(usuarios.isEmpty()); // false

        System.out.println(usuarios.keySet()); // [1, 2, 3, 4]
        System.out.println(usuarios.values()); // [Roberto, Ricardo, Rafaela, Rebeca]
        System.out.println(usuarios.entrySet()); // [1=Roberto, 2=Ricardo, 3=Rafaela, 4=Rebeca]

        System.out.println(usuarios.containsKey(20)); // True
        System.out.println(usuarios.containsValue("Rebeca")); // True

        System.out.println(usuarios.get(20)); // "Ricardo"
        System.out.println(usuarios.remove(1)); // "Roberto"

        for (int chave:  usuarios.keySet()) {
            System.out.println(chave);
        }

        for (String valor: usuarios.values()) {
            System.out.println(valor);
        }

        for (Map.Entry<Integer, String> registro: usuarios.entrySet()) {
            System.out.print(registro.getKey() + " ===> ");
            System.out.println(registro.getValue());
        }
    }
}
