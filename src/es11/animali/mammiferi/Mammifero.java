package es11.animali.mammiferi;

import es11.animali.Animale;

public abstract class Mammifero extends Animale {
    @Override
    public String getClassificazione() {
        return "Mammifero";
    }
}
