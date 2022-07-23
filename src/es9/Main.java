package es9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lista.add(i);
        }
        System.out.println(lista);

        new CancArrayList().cancellaNumeriPari(lista);
        System.out.println(lista);
    }
}
