package es2;

import utilities.Utilities;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Videogame {
    private final String nome;
    private final String casaProduttrice;
    private final double prezzo;

    public Videogame(String nome, String casaProduttrice, double prezzo) throws Exception {
        if (nome.isEmpty() || nome.isBlank()) {
            throw new Exception("Nome invalido");
        }

        if (casaProduttrice.isEmpty() || casaProduttrice.isBlank()) {
            throw new Exception("Casa produttrice invalida");
        }

        if (prezzo < 0) {
            throw new Exception("Prezzo invalido");
        }

        this.nome = Utilities.formatString(nome);
        this.casaProduttrice = Utilities.formatString(casaProduttrice);
        this.prezzo = prezzo;
    }


    public String getNome() {
        return nome;
    }

    public String getCasaProduttrice() {
        return casaProduttrice;
    }

    public double getPrezzo() {
        return prezzo;
    }

    /**
     * Calcola il prezzo scontato
     * @param percentuale Valore da scontare (ad es 20 = 20% di sconto)
     * @return prezzo scontato
     */
    public double getPrezzoScontato(int percentuale) {
        return prezzo * percentuale / 100;
    }

    @Override
    public String toString() {
        return "Videogame " + nome + "\n" +
                "Casa Produttrice: " + casaProduttrice + "\n" +
                "Prezzo: " + NumberFormat.getCurrencyInstance().format(prezzo);
    }
}
