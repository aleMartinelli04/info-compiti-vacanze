package es1;

import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;
import java.util.stream.Collectors;

public class Libro {
    private final String codice;
    private final String titolo;
    private final int annoPubblicazione;
    private final String autore;

    public Libro(String titolo, int annoPubblicazione, String autore) throws Exception {
        if (titolo.isBlank() || titolo.isEmpty()) {
            throw new Exception("Titolo invalido");
        }

        if (annoPubblicazione > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new Exception("Anno invalido");
        }

        if (autore.isBlank() || autore.isEmpty()) {
            throw new Exception("Autore invalido");
        }

        this.codice = UUID.randomUUID().toString().split("-")[0].toUpperCase();
        this.titolo = Arrays.stream(titolo.split(" "))
                .map(part -> part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        this.annoPubblicazione = annoPubblicazione;
        this.autore = Arrays.stream(autore.split(" "))
                .map(part -> part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    public String getCodice() {
        return codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public String getAutore() {
        return autore;
    }

    @Override
    public String toString() {
        return "Libro " + titolo + "\n" +
                "codice: " + codice + "\n" +
                "anno pubblicazione: " + annoPubblicazione + "\n" +
                "autore: " + autore;
    }
}
