package es11.animali;

public abstract class Animale {
    private final int codiceUnivoco;

    private static int codice = 0;

    public Animale() {
        this.codiceUnivoco = ++codice;
    }

    public abstract String getNome();

    public abstract String getClassificazione();

    public int getCodiceUnivoco() {
        return codiceUnivoco;
    }

    @Override
    public String toString() {
        return getNome() + "#" + String.format("%03d", codiceUnivoco);
    }
}
