package es13;

public abstract class Aggeggio {
    private final String nome;
    private final String utilizzo;
    private final double prezzo;

    public Aggeggio(String nome, String utilizzo, double prezzo) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Aggeggio [nome=" + nome + ", utilizzo=" + utilizzo + ", prezzo=" + prezzo + "]";
    }
}
