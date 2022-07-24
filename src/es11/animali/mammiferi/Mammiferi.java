package es11.animali.mammiferi;

import es11.animali.Animale;
import es11.animali.CreaAnimale;

public enum Mammiferi implements CreaAnimale {
    ORSO(Orso.class),
    TIGRE(Tigre.class),
    ZEBRA(Zebra.class);

    private final Class<? extends Animale> classe;

    Mammiferi(Class<? extends Animale> classe) {
        this.classe = classe;
    }

    @Override
    public Mammifero crea() {
        return switch (this) {
            case ORSO -> new Orso();
            case TIGRE -> new Tigre();
            case ZEBRA -> new Zebra();
        };
    }

    public boolean filtra(Animale animale) {
        return animale != null && animale.getClass().equals(classe);
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
