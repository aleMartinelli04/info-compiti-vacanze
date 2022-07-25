package es12;

import utilities.Utilities;

import java.time.Year;

public class Possessore {
    private final String cognome;
    private final Year annoIniziale;
    private final Year annoFinale;

    public Possessore(String cognome, Year annoIniziale, Year annoFinale) {
        this.cognome = Utilities.formatString(cognome);
        this.annoIniziale = annoIniziale;
        this.annoFinale = annoFinale;
    }

    public String getCognome() {
        return cognome;
    }

    public Year getAnnoIniziale() {
        return annoIniziale;
    }

    public Year getAnnoFinale() {
        return annoFinale;
    }

    public int getDurataPossesso() {
        return annoFinale.getValue() - annoIniziale.getValue();
    }

    @Override
    public String toString() {
        return "Possessore Opera " + cognome + " " + annoIniziale + "-" + annoFinale;
    }
}
