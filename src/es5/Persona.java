package es5;

import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.Collectors;

public class Persona {
    private final String nome;
    private final String cognome;
    private final int annoNascita;

    public Persona(String nome, String cognome, int annoNascita) throws Exception {
        if (nome.isBlank() || nome.isEmpty()) {
            throw new Exception("Nome invalido");
        }

        if (cognome.isBlank() || cognome.isEmpty()) {
            throw new Exception("Cognome invalido");
        }

        if (annoNascita > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new Exception("Anno invalido");
        }


        this.nome = Arrays.stream(nome.split(" "))
                .map(part -> part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        this.cognome = Arrays.stream(cognome.split(" "))
                .map(part -> part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        this.annoNascita = annoNascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getAnnoNascita() {
        return annoNascita;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " " + cognome + "\n" +
                "Anno nascita: " + annoNascita;
    }
}
