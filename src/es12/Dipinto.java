package es12;

import java.time.Year;

public class Dipinto extends Opera {
    private final double altezza;
    private final double larghezza;

    public Dipinto(String codice, Year annoRealizzazione, String titolo, double costo, boolean restaurata, double altezza, double larghezza) throws Exception {
        super(codice, annoRealizzazione, titolo, costo, restaurata);

        if (altezza <= 0 || larghezza <= 0) {
            throw new Exception("Dimensioni non valide");
        }

        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    public double getAltezza() {
        return altezza;
    }

    public double getLarghezza() {
        return larghezza;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "dimensioni: " + altezza + "x" + larghezza;
    }
}
