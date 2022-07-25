package es13;

import utilities.Utilities;

public class Builder {
    private final String nome;
    private final String utilizzo;
    private final double prezzo;

    public Builder(String nome, String utilizzo, double prezzo) {
        this.nome = Utilities.formatString(nome);
        this.utilizzo = utilizzo;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public String getUtilizzo() {
        return utilizzo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Utensile buildUtensile() {
        return new Utensile(this);
    }

    public Elettrodomestico buildElettrodomestico() {
        return new Elettrodomestico(this);
    }
}
