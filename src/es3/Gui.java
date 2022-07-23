package es3;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Gui extends JFrame {
    private JPanel mainPanel;
    private JSpinner spinnerPuntata;
    private JButton puntaButton;
    private JTextField soldiField;

    private int soldi;

    public Gui() {
        super("Gioco leva");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        setSize(500, 350);
        setLocationRelativeTo(null);

        puntaButton.addActionListener(e -> {
            try {
                punta();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });

        soldi = 1_000;
        soldiField.setText("Adesso hai " + soldi + " soldi!");
    }

    private void punta() throws Exception {
        int puntata = (int) spinnerPuntata.getValue();

        if (puntata <= 0) {
            throw new Exception("La puntata deve essere più di 0");
        }

        if (puntata > soldi) {
            throw new Exception("Non puoi puntare soldi che non hai!");
        }

        soldi -= puntata;

        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            num.add(ThreadLocalRandom.current().nextInt(0, 5));
        }

        Set<Integer> nums = new HashSet<>(num);

        String message = "Numeri usciti: " + num + "\n" +
                switch (nums.size()) {
                    case 1 -> {
                        soldi += puntata * 3;
                        yield "Triplo numero! Valore della puntata triplicato!";
                    }
                    case 2 -> {
                        soldi += puntata * 2;
                        yield "Doppio numero! Valore della puntata duplicato!";
                    }
                    case 3 -> "Nessun numero si ripete! Hai perso quello che avevi puntato!";
                    default -> throw new Exception("Unexpected value: " + nums.size());
                };

        JOptionPane.showMessageDialog(this, message, "Esito Puntata", JOptionPane.INFORMATION_MESSAGE);
        spinnerPuntata.setValue(0);
        soldiField.setText("Adesso hai " + NumberFormat.getCurrencyInstance().format(soldi) + " soldi!");
    }
}