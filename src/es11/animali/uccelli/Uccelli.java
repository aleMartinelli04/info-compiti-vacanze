package es11.animali.uccelli;

import es11.animali.Animale;
import es11.animali.CreaAnimale;

public enum Uccelli implements CreaAnimale {
    FALCO;

    @Override
    public Animale crea() {
        return new Falco();
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
