package es5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Persona> persone = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inserisci cosa vuoi fare:");
            System.out.println("\t1. Inserisci una persona");
            System.out.println("\t2. Visualizza tutte le persone");
            System.out.println("\t0. Esci");
            System.out.print("Inserisci scelta: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        return;

                    case 1:
                        System.out.println("Inserire nome, cognome e anno di nascita");

                        String nome = scanner.nextLine();

                        String cognome = scanner.nextLine();

                        int anno = scanner.nextInt();
                        scanner.nextLine();

                        Persona persona = new Persona(nome, cognome, anno);

                        persone.add(persona);
                        System.out.println(persona.getNome() + " aggiunto/a con successo!");
                        break;

                    case 2:
                        if (persone.isEmpty()) {
                            System.out.println("Nessuna persona presente!");
                            break;
                        }

                        persone.forEach(p -> {
                            System.out.println(p);
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
