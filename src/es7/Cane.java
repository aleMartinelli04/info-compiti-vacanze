package es7;

public class Cane {
    private final String nome;
    private final String razza;
    private final int eta;

    public Cane(String nome, String razza, int eta) throws Exception {
        if (nome.isEmpty() || nome.isBlank()) {
            throw new Exception("Nome invalido");
        }

        if (razza.isEmpty() || razza.isBlank()) {
            throw new Exception("Razza invalida");
        }

        if (eta <= 0) {
            throw new Exception("Età invalida");
        }

        this.nome = nome;
        this.razza = razza;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public String getRazza() {
        return razza;
    }

    public int getEta() {
        return eta;
    }

    @Override
    public String toString() {
        return "Cane " + nome + "\n" + "Razza: " + razza + "\n" + "Età: " + eta;
    }
}
