package es6;

import javax.swing.*;

public class Gui extends JFrame {
    private JPanel mainPanel;
    private JTextField inputEuroField;
    private JTextField inputDollariField;
    private JButton convertiInDollariButton;
    private JButton convertiInEuroButton;

    public Gui() {
        super("Convertitore euro - dollari");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        setSize(500, 350);
        setLocationRelativeTo(null);

        convertiInDollariButton.addActionListener(e -> {
            double euro = Double.parseDouble(inputEuroField.getText());
            double dollari = euro * 1.02;

            JOptionPane.showMessageDialog(this, dollari + " $", "Convertito in dollari", JOptionPane.INFORMATION_MESSAGE);
        });

        convertiInEuroButton.addActionListener(e -> {
            double dollari = Double.parseDouble(inputDollariField.getText());
            double euro = dollari * 0.98;

            JOptionPane.showMessageDialog(this, euro + " €", "Convertito in euro", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
