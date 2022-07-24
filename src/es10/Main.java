package es10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clienti = new ArrayList<>();

        try {
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            clienti.add(new Cliente("Alessandro", "Martinelli", "MRTLSN", format.parse("15-09-2004"), 3));
            clienti.add(new Cliente("Alessandro", "Fumagalli", "FMGLSN", format.parse("18-06-2004"), 3));
            clienti.add(new Cliente("Dennis", "Cremonesi", "CRMDNN", format.parse("21-11-2004"), 3));
            clienti.add(new Cliente("Niccolò", "Moriconi", "ULTIMO", format.parse("27-01-1996"), 3));
        } catch (Exception ignored) {
        }

        for (int i = 0; i < 10; i++) {
            Cliente cliente = clienti.get(ThreadLocalRandom.current().nextInt(0, clienti.size()));

            try {
                System.out.println(cliente.getNome() + " sta prenotando un libro...");
                cliente.prenotaLibro();
                System.out.println("Libro prenotato!");

                System.out.println("Situazione attuale:\n" + cliente);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("--------------------------------");
        }
    }
}
