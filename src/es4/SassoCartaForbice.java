package es4;

public enum SassoCartaForbice {
    SASSO,
    CARTA,
    FORBICE;

    private SassoCartaForbice getQuelloCheLoBatte() {
        return switch (this) {
            case SASSO -> CARTA;
            case CARTA -> FORBICE;
            case FORBICE -> SASSO;
        };
    }

    boolean vinceContro(SassoCartaForbice valore) {
        return this == valore.getQuelloCheLoBatte();
    }

    String getNome() {
        return this.name().toLowerCase();
    }
}
