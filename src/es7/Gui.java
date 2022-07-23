package es7;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame {
    private JPanel mainPanel;
    private JTextField inputNomeField;
    private JTextField inputRazzaField;
    private JSpinner inputEtaSpinner;
    private JButton inserisciButton;
    private JTextArea outputArea;
    private JButton mostraButton;

    private final List<Cane> cani;

    public Gui() {
        super("Canile");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        setSize(700, 550);
        setLocationRelativeTo(null);

        this.cani = new ArrayList<>();

        inserisciButton.addActionListener(e -> {
            try {
                Cane cane = new Cane(inputNomeField.getText(), inputRazzaField.getText(), (Integer) inputEtaSpinner.getValue());
                inputNomeField.setText("");
                inputRazzaField.setText("");
                inputEtaSpinner.setValue(0);

                cani.add(cane);
                JOptionPane.showMessageDialog(this, "Cane " + cane.getNome() + " inserito con successo!", "Inserimento", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });

        mostraButton.addActionListener(e -> {
            outputArea.setText("");
            cani.forEach(c -> {
                outputArea.append(c.toString());
                outputArea.append("\n-------------------\n");
            });
        });
    }
}
