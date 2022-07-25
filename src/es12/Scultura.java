package es12;

import utilities.Utilities;

import java.time.Year;

public class Scultura extends Opera {
    private final String materiale;
    private final double altezza;
    private final double peso;

    public Scultura(String codice, Year annoRealizzazione, String titolo, double costo, boolean restaurata, String materiale, double altezza, double peso) throws Exception {
        super(codice, annoRealizzazione, titolo, costo, restaurata);

        if (materiale == null || materiale.isEmpty()) {
            throw new Exception("Materiale non valido");
        }

        if (altezza <= 0) {
            throw new Exception("Altezza non valida");
        }

        if (peso <= 0) {
            throw new Exception("Peso non valido");
        }

        this.materiale = Utilities.formatString(materiale);
        this.altezza = altezza;
        this.peso = peso;
    }

    public String getMateriale() {
        return materiale;
    }

    public double getAltezza() {
        return altezza;
    }

    public double getPeso() {
        return peso;
    }

    public double costoTrasporto(double aumento) {
        return altezza > 1.5 ? peso + aumento : peso;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "materiale: " + materiale + "\n" +
                "altezza: " + altezza + "\n" +
                "peso: " + peso;
    }
}
