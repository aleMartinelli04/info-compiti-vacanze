package es4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Inserisci scelta 1:");
                SassoCartaForbice scelta1 = SassoCartaForbice.valueOf(scanner.nextLine().toUpperCase());

                System.out.println("Inserisci scelta 2:");
                SassoCartaForbice scelta2 = SassoCartaForbice.valueOf(scanner.nextLine().toUpperCase());

                if (scelta1 == scelta2) {
                    System.out.println("Pareggio!");
                } else if (scelta1.vinceContro(scelta2)) {
                    System.out.println("Vince il giocatore 1!");
                } else {
                    System.out.println("Vince il giocatore 2!");
                }

                System.out.println("Uscire? [* = esci]");
                if (scanner.nextLine().equals("*")) {
                    return;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Scelta errata: inserire solo 'sasso', 'carta' o 'forbice'");
            }
        }
    }
}
