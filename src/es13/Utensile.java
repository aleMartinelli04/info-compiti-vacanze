package es13;

public class Utensile extends Aggeggio{
    public Utensile(Builder builder) {
        super(builder.getNome(), builder.getUtilizzo(), builder.getPrezzo());
    }

    @Override
    public String toString() {
        return super.toString().replaceAll("Aggeggio", "Utensile");
    }
}
