package es13;

import javax.swing.*;

public class Gui extends JFrame {
    private JPanel mainPanel;
    private JTextField nomeField;
    private JTextField utilizzoField;
    private JTextField prezzoField;
    private JRadioButton elettrodomesticoRadioButton;
    private JRadioButton utensileRadioButton;
    private JButton inserisciButton;
    private JTextArea outputArea;

    public Gui() {
        super("Elettrodomestico e Utensile");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        setSize(350, 400);
        setLocationRelativeTo(null);

        inserisciButton.addActionListener(e -> {
            try {
                String nome = nomeField.getText();
                String utilizzo = utilizzoField.getText();
                double prezzo = Double.parseDouble(prezzoField.getText());

                Builder builder = new Builder(nome, utilizzo, prezzo);

                Aggeggio aggeggio;

                if (utensileRadioButton.isSelected()) {
                    aggeggio = builder.buildUtensile();
                } else if (elettrodomesticoRadioButton.isSelected()) {
                    aggeggio = builder.buildElettrodomestico();
                } else {
                    JOptionPane.showMessageDialog(this, "Selezionare un tipo di aggeggio", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                outputArea.append(aggeggio + "\n");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Il prezzo deve essere un numero", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });

    }
}
