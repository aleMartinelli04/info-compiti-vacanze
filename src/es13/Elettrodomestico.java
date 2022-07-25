package es13;

public class Elettrodomestico extends Aggeggio {
    public Elettrodomestico(Builder builder) {
        super(builder.getNome(), builder.getUtilizzo(), builder.getPrezzo());
    }

    @Override
    public String toString() {
        return super.toString().replaceAll("Aggeggio", "Elettrodomestico");
    }
}
