package es10;

import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

public class DiarioPrenotazioni {
    private final HashMap<Month, Integer> prenotazioni;
    private final int limitePrenotazioni;

    public DiarioPrenotazioni(int limitePrenotazioni) {
        this.prenotazioni = new HashMap<>();
        Arrays.stream(Month.values()).forEach(v -> prenotazioni.put(v, 0));

        this.limitePrenotazioni = limitePrenotazioni;
    }

    public int getLimitePrenotazioni() {
        return limitePrenotazioni;
    }

    public void prenotaLibro() throws Exception {
        Month corrente = Month.of(Calendar.getInstance().get(Calendar.MONTH));

        if (prenotazioni.get(corrente) >= limitePrenotazioni) {
            throw new Exception("Limite prenotazioni raggiunto");
        }

        prenotazioni.put(corrente, prenotazioni.get(corrente) + 1);
    }

    public int getPrenotazioni(Month mese) {
        return prenotazioni.get(mese);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        prenotazioni.forEach((k, v) -> ret.append(k).append(": ").append(v).append("\n"));

        return ret.toString();
    }
}
