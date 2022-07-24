package es8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        VotoConverter converter = new VotoConverter();

        String[] voti = {"A+", "A", "C+", "D+", "F", "F-"};
        Arrays.stream(voti).forEach(voto -> {
            try {
                System.out.println("Conversione voto " + voto + ": " + converter.convertiVoto(voto));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
