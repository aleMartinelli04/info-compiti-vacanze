package es8;

import java.util.HashMap;

public class VotoConverter {
    private final HashMap<String, Double> voti;

    public VotoConverter() {
        this.voti = new HashMap<>();

        voti.put("A+", 4.0);
        voti.put("A", 4.0);
        voti.put("A-", 3.7);
        voti.put("B+", 3.3);
        voti.put("B", 3.0);
        voti.put("B-", 2.7);
        voti.put("C+", 2.3);
        voti.put("C", 2.0);
        voti.put("C-", 1.7);
        voti.put("D+", 1.3);
        voti.put("D", 1.0);
        voti.put("D-", 0.7);
        voti.put("F", 0.0);
    }

    public double convertiVoto(String voto) throws Exception {
        if (!voti.containsKey(voto)) {
            throw new Exception("Voto '" + voto + "' invalido. Voti ammessi: " + voti.keySet());
        }

        return voti.get(voto);
    }
}
