package es11.animali.uccelli;

import es11.animali.Animale;

public abstract class Uccello extends Animale {
    @Override
    public String getClassificazione() {
        return "Uccello";
    }
}
