package es11;

import es11.animali.Animale;
import es11.animali.CreaAnimale;
import es11.animali.mammiferi.Mammiferi;
import es11.animali.rettili.Rettili;
import es11.animali.uccelli.Uccelli;

import javax.swing.*;
import java.util.Arrays;

public class Gui extends JFrame {
    private JPanel mainPanel;

    private JRadioButton mammiferiRadioButton;
    private JRadioButton uccelliRadioButton;
    private JRadioButton rettiliRadioButton;
    private JComboBox<Mammiferi> mammiferiComboBox;
    private JComboBox<Uccelli> uccelliComboBox;
    private JComboBox<Rettili> rettiliComboBox;
    private JButton inserisciButton;

    private JList<Animale> visualizzazioneList;
    private JButton eliminaButton;

    private final DefaultListModel<Animale> animali;

    public Gui() {
        super("Zoo");

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(650, 500);
        setLocationRelativeTo(null);

        this.animali = new DefaultListModel<>();
        visualizzazioneList.setModel(animali);

        Arrays.stream(Mammiferi.values()).forEach(mammifero -> mammiferiComboBox.addItem(mammifero));
        Arrays.stream(Uccelli.values()).forEach(uccello -> uccelliComboBox.addItem(uccello));
        Arrays.stream(Rettili.values()).forEach(rettile -> rettiliComboBox.addItem(rettile));


        mammiferiRadioButton.addActionListener(e -> {
            mammiferiComboBox.setEnabled(true);
            uccelliComboBox.setEnabled(false);
            rettiliComboBox.setEnabled(false);
        });
        uccelliRadioButton.addActionListener(e -> {
            mammiferiComboBox.setEnabled(false);
            uccelliComboBox.setEnabled(true);
            rettiliComboBox.setEnabled(false);
        });
        rettiliRadioButton.addActionListener(e -> {
            mammiferiComboBox.setEnabled(false);
            uccelliComboBox.setEnabled(false);
            rettiliComboBox.setEnabled(true);
        });

        inserisciButton.addActionListener(e -> {
            CreaAnimale scelta;

            if (mammiferiRadioButton.isSelected()) {
                scelta = (Mammiferi) mammiferiComboBox.getSelectedItem();
            } else if (rettiliRadioButton.isSelected()) {
                scelta = (Rettili) rettiliComboBox.getSelectedItem();
            } else {
                scelta = (Uccelli) uccelliComboBox.getSelectedItem();
            }

            if (scelta == null) {
                JOptionPane.showMessageDialog(this, "Scegli un animale", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Animale nuovo = scelta.crea();
            animali.addElement(nuovo);
            JOptionPane.showMessageDialog(this, "Animale " + nuovo + " creato!", "Successo", JOptionPane.INFORMATION_MESSAGE);
        });

        eliminaButton.addActionListener(e -> {
            int index = visualizzazioneList.getSelectedIndex();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Scegli un animale", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            animali.remove(index);
            JOptionPane.showMessageDialog(this, "Animale eliminato", "Successo", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
