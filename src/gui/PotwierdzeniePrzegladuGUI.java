package gui;

import javax.swing.*;
import java.awt.*;

public class PotwierdzeniePrzegladuGUI {
    public JPanel panel1;
    private JButton powrótDoGłównegoMENUButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PotwierdzeniePrzegladuGUI");
        frame.setContentPane(new PotwierdzeniePrzegladuGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPotwierdzenie(String message) {

        return panel1;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel2.setEnabled(true);
        panel1.add(panel2, BorderLayout.CENTER);
        powrótDoGłównegoMENUButton = new JButton();
        powrótDoGłównegoMENUButton.setText("Powrót do głównego MENU");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel2.add(powrótDoGłównegoMENUButton, gbc);
        final JLabel label1 = new JLabel();
        label1.setHorizontalTextPosition(0);
        label1.setText("aaaaaaaaaaaaaaaaaaaaaaaassssssssssssssssssssssssssssssssssssssssssssssssssss  dddddddddddddddsssssssssssssssssssssddddddaaaaaaa");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel2.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Informacje o przeglądzie:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel2.add(label2, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}