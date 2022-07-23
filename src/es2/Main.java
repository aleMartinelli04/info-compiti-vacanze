package es2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Videogame> videogames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inserisci cosa vuoi fare:");
            System.out.println("\t1. Inserisci un videogame");
            System.out.println("\t2. Visualizza tutti i videogame");
            System.out.println("\t3. Visualizza videogame compresi in una fascia di prezzo");
            System.out.println("\t0. Esci");
            System.out.print("Inserisci scelta: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        return;

                    case 1:
                        System.out.println("Inserire nome, casa produttrice e prezzo");

                        String nome = scanner.nextLine();

                        String casaProduttrice = scanner.nextLine();

                        double prezzo = scanner.nextDouble();
                        scanner.nextLine();

                        Videogame videogame = new Videogame(nome, casaProduttrice, prezzo);

                        videogames.add(videogame);
                        System.out.println("Libro " + videogame.getNome() + " aggiunto con successo!");
                        break;

                    case 2:
                        if (videogames.isEmpty()) {
                            System.out.println("Nessun videogame presente!");
                            break;
                        }

                        videogames.forEach(v -> {
                            System.out.println(v);
                            System.out.println("----------------");
                        });
                        break;

                    case 3:
                        System.out.println("Inserire prezzo minimo:");
                        double min = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Inserire prezzo massimo:");
                        double max = scanner.nextDouble();
                        scanner.nextLine();

                        if (min > max) {
                            throw new Exception("Intervallo di prezzo non valido");
                        }

                        videogames.stream()
                                .filter(v -> v.getPrezzo() >= min)
                                .filter(v -> v.getPrezzo() <= max)
                                .forEach(v -> {
                                    System.out.println(v);
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
