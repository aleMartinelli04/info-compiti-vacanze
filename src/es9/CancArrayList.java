package es9;

import java.util.List;

public class CancArrayList {
    public void cancellaNumeriPari(List<Integer> lista) {
        lista.removeIf(num -> num % 2 == 0);
    }
}
