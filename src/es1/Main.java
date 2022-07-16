package es1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Libro> libri = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inserisci cosa vuoi fare:");
            System.out.println("\t1. Inserisci un libro");
            System.out.println("\t2. Visualizza tutti i libri");
            System.out.println("\t0. Esci");
            System.out.print("Inserisci scelta: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        return;

                    case 1:
                        if (libri.size() >= 100) {
                            System.out.println("Capacità massima di libri raggiunta");
                            break;
                        }

                        System.out.println("Inserire titolo, anno pubblicazione e autore");

                        String titolo = scanner.nextLine();

                        int anno = scanner.nextInt();
                        scanner.nextLine();

                        String autore = scanner.nextLine();

                        Libro libro = new Libro(titolo, anno, autore);

                        libri.add(libro);
                        System.out.println("Libro " + libro.getTitolo() + " aggiunto con successo!");
                        break;

                    case 2:
                        if (libri.isEmpty()) {
                            System.out.println("Nessun libro presente!");
                            break;
                        }

                        libri.forEach(l -> {
                            System.out.println(l);
                            System.out.println("----------------");
                        });
                        break;

                    default:
                        System.out.println("Scelta non valida");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Inserisci un valore valido");
                scanner.nextLine();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
