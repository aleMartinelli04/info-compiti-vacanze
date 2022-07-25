package es12;

import utilities.Utilities;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public abstract class Opera {
    private final String codice;
    private final Year annoRealizzazione;
    private final String titolo;
    private final double costo;
    private final boolean restaurata;
    private final List<Possessore> possessori;

    public Opera(String codice, Year annoRealizzazione, String titolo, double costo, boolean restaurata) throws Exception {
        if (codice.length() < 5 || codice.length() > 8) {
            throw new Exception("Codice non valido");
        }

        if (annoRealizzazione.isAfter(Year.now()) || annoRealizzazione.isBefore(Year.now().minusYears(5))) {
            throw new Exception("Anno non valido");
        }

        if (titolo == null || titolo.isEmpty()) {
            throw new Exception("Titolo non valido");
        }

        if (costo < 0) {
            throw new Exception("Costo non valido");
        }

        this.codice = codice.toUpperCase();
        this.annoRealizzazione = annoRealizzazione;
        this.titolo = Utilities.formatString(titolo);
        this.costo = costo;
        this.restaurata = restaurata;
        this.possessori = new ArrayList<>();
    }

    public String getCodice() {
        return codice;
    }

    public Year getAnnoRealizzazione() {
        return annoRealizzazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public double getCosto() {
        return costo;
    }

    public boolean isRestaurata() {
        return restaurata;
    }

    public void aggiungiPossessore(Possessore possessore) {
        possessori.add(possessore);
    }

    public double stimaVendita(double aumento) {
        return restaurata ? costo + aumento : costo * 1.1;
    }

    public double costoTrasporto() {
        return stimaVendita(0) * 0.2;
    }

    @Override
    public String toString() {
        return "Opera " + titolo + " (" + annoRealizzazione + ") #" + codice + "\n" +
                "costo: " + costo + "\n" +
                "restaurata:" + restaurata + "\n" +
                "possessori: " + possessori;
    }
}
