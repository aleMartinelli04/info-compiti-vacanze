package es11.animali.rettili;

import es11.animali.CreaAnimale;

public enum Rettili implements CreaAnimale {
    TARTARUGA;

    @Override
    public Rettile crea() {
        return new Tartaruga();
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

