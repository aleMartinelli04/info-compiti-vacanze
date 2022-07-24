package es10;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

public class Cliente {
    private final String nome;
    private final String cognome;
    private final String codiceFiscale;
    private final Date dataNascita;

    private final DiarioPrenotazioni diario;

    public Cliente(String nome, String cognome, String codiceFiscale, Date dataNascita, int limitePrenotazioni) throws Exception {
        if (nome.isEmpty() || nome.isBlank()) {
            throw new Exception("Nome invalido");
        }

        if (cognome.isEmpty() || cognome.isBlank()) {
            throw new Exception("Cognome invalido");
        }

        if (codiceFiscale.isEmpty() || codiceFiscale.isBlank()) {
            throw new Exception("Codice fiscale invalido");
        }

        if (dataNascita.after(Calendar.getInstance().getTime())) {
            throw new Exception("Data di nascita invalida");
        }

        if (limitePrenotazioni <= 0) {
            throw new Exception("Limite prenotazioni invalido");
        }

        this.nome = Arrays.stream(nome.split(" "))
                .map(part -> part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        this.cognome = Arrays.stream(cognome.split(" "))
                .map(part -> part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        this.codiceFiscale = codiceFiscale.toUpperCase();
        this.dataNascita = dataNascita;

        this.diario = new DiarioPrenotazioni(limitePrenotazioni);
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void prenotaLibro() throws Exception {
        diario.prenotaLibro();
    }

    public DiarioPrenotazioni getDiario() {
        return diario;
    }

    @Override
    public String toString() {
        Month corrente = Month.of(Calendar.getInstance().get(Calendar.MONTH));
        return "Cliente " + nome + " " + cognome + "\n" +
                "Codice fiscale: " + codiceFiscale + "\n" +
                "Data di nascita: " + new SimpleDateFormat("dd-MM-yyyy").format(dataNascita) + "\n" +
                "Prenotazioni per questo mese (" + corrente + "): " + diario.getPrenotazioni(corrente) + "/" + diario.getLimitePrenotazioni();
    }
}
