package gui;

import mainPackage.SZFM_Enum;
import ogolne.Placowka;
import pojazd.PojazdKosmiczny;
import pracownik.Inzynier;
import przeglad.Czesc;
import przeglad.Naprawa;
import przeglad.Przeglad;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrzegladGUI<T> {
    public JPanel panel1;
    private JPanel panel2;
    private JComboBox wybierzPojazdComboBox;
    private JCheckBox pojazdWymagaNaprawyCheckBox;
    private JCheckBox naprawaUdanaCheckBox;
    private JButton zatwierdźPrzeglądButton;
    private JButton anulujButton;
    private JComboBox staraCzescComboBox;
    private JComboBox nowaCzescComboBox;
    private JTextField opisNaprawyTextField;
    private JTextField opisPrzegladuTextField;
    private JLabel rozpocznijNaprawęPojazduLabel;
    private JLabel wybierzPojazdLabel;
    private JLabel opisNaprawyLabel;
    private JLabel wybierzNowąCzęśćLabel;
    private JLabel wybierzStarąCzęśćLabel;
    private JLabel opisPrzegladuLabel;
    private JCheckBox wymaganaWymianaCzęściCheckBox;
    private PojazdKosmiczny pojazd;
    //private ActionListener zatwierdzeniePrzegladuListener;
    private Czesc staraCzesc;
    private Czesc nowaCzesc;
    private Placowka placowka;
    private Inzynier inzynier;


    public PrzegladGUI(Iterable<T> listaPojazdow, Placowka placowka, Inzynier inzynier) {
        this.placowka = placowka;
        this.inzynier = inzynier;
        for (T pojazd : listaPojazdow) {

            wybierzPojazdComboBox.addItem(pojazd);
        }
        seWszystkotDomyslne();


        wybierzPojazdComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(wybierzPojazdComboBox.getSelectedItem(), "--Wybierz pojazd--") ||
                        wybierzPojazdComboBox.getSelectedItem() == null) {
                    return;
                }
                setDomyslnePoZmianiePojazdu();


                JComboBox comboBox = (JComboBox) e.getSource();
                pojazd = (PojazdKosmiczny) comboBox.getSelectedItem();
                System.out.println("\n* * * Wybrano pojazd: " + pojazd);

                try {
                    //pojazd = PojazdKosmiczny.dajPojazd(nrPojazdu);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                opisPrzegladuLabel.setEnabled(true);
                opisPrzegladuTextField.setEnabled(true);
                pojazdWymagaNaprawyCheckBox.setEnabled(true);
                zatwierdźPrzeglądButton.setEnabled(true);

            }


        });

        zatwierdźPrzeglądButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\n#####__Z-A-T-W-I-E-R-D-Z-O-N-O____P-R-Z-E-G-L-Ą-D__#####\n");
                int nrPrzegladu = 0;
                Przeglad przeglad = null;
                Boolean wymaganaNaprawa = false;
                Boolean przegladUdany = false;
                Boolean naprawaUdana = false;
                Boolean wymaganaWymianaCzesci = false;
                SZFM_Enum.statusPrzegladu statusPrzegladu;
                SZFM_Enum.statusNaprawy statusNaprawy;
                String naprawaInfo = "Brak zatwierdzonych napraw.";
                String przegladInfo;
                String opisPrzegladu = "-";
                String opisNaprawy;
                Naprawa naprawa = null;

                if (!pojazdWymagaNaprawyCheckBox.isSelected() ||
                        naprawaUdanaCheckBox.isSelected()) {
                    przegladUdany = true;
                    statusPrzegladu = SZFM_Enum.statusPrzegladu.ukonczonyPozytywnie;
                    pojazd.zmienStatus(SZFM_Enum.statusPojazdu.gotowy);
                } else {
                    przegladUdany = false;
                    statusPrzegladu = SZFM_Enum.statusPrzegladu.ukonczonyNegatywnie;
                    pojazd.zmienStatus(SZFM_Enum.statusPojazdu.wycofanyZeSluzby);
                }

                try {
                    przeglad = Przeglad.rozpoczecieNowegoPrzegladu(pojazd, statusPrzegladu);
                    opisPrzegladu = opisPrzegladuTextField.getText();
                    przeglad.setOpisPrzegladu(opisPrzegladu);
                    nrPrzegladu = przeglad.getNrPrzegladu();
                    placowka.powiazPlacowkeZPrzegladem(przeglad);
                    inzynier.powiazInzynieraZPrzegladem(przeglad);

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                przegladInfo = "\nZatwierdzono przegląd nr: " + String.valueOf(nrPrzegladu) +
                        " dla pojazdu " + pojazd.toString() + "" +
                        "\nPrzegląd odbył się w placówce: " + placowka +
                        "\nZa przeglad odpowiadał: " + inzynier +
                        "\nSzczegóły przeglądu: " + przeglad.toString() +
                        "\nWymóg naprawy: " + wymaganaNaprawa +
                        "\nOpis przeglądu: " + opisPrzegladu;


                if (pojazdWymagaNaprawyCheckBox.isSelected()) {
                    wymaganaNaprawa = true;

                    if (naprawaUdanaCheckBox.isSelected()) {
                        naprawaUdana = true;
                        statusNaprawy = SZFM_Enum.statusNaprawy.udana;
                    } else {
                        naprawaUdana = false;
                        statusNaprawy = SZFM_Enum.statusNaprawy.nieudana;
                    }

                    try {


                        naprawa = Naprawa.rozpocznijNowaNaprawe(przeglad, statusNaprawy);
                        opisNaprawy = opisNaprawyTextField.getText();
                        naprawa.setOpisNaprawy(opisNaprawy);


                        naprawaInfo = "Zatwierdzono naprawe nr: " + naprawa.getNrNaprawy() +
                                ", do przeglądu: " + przeglad.getNrPrzegladu() +
                                ", status naprawy: " + naprawa.getStatusNaprawy() +
                                "\nOpis naprawy: " + opisNaprawy;


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    if (wymaganaWymianaCzęściCheckBox.isSelected() == true) {
                        wymaganaWymianaCzesci = true;
                        try {
                            pojazd.odlaczCzescOdPojazdu(staraCzesc);
                            pojazd.dodajCzescDoPojazdu(nowaCzesc);
                            naprawa.wymienionoCzesci(staraCzesc, nowaCzesc);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }


                } else {
                    statusNaprawy = SZFM_Enum.statusNaprawy.udana;
                }


                System.out.println(przegladInfo);
                System.out.println("\n" + naprawaInfo);


                JOptionPane.showMessageDialog(new JFrame(), przegladInfo + "\n" + naprawaInfo);

                seWszystkotDomyslne();


            }
        });


        pojazdWymagaNaprawyCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!pojazdWymagaNaprawyCheckBox.isSelected()) {
                    wyzerujStareNoweCzesci();
                    wymaganaWymianaCzęściCheckBox.setEnabled(false);
                    wymaganaWymianaCzęściCheckBox.setSelected(false);
                    opisNaprawyLabel.setEnabled(false);
                    opisNaprawyTextField.setEnabled(false);
                    naprawaUdanaCheckBox.setEnabled(false);

                    return;
                }

                wymaganaWymianaCzęściCheckBox.setEnabled(true);
                opisNaprawyLabel.setEnabled(true);
                opisNaprawyTextField.setEnabled(true);
                naprawaUdanaCheckBox.setEnabled(true);
            }
        });


        wymaganaWymianaCzęściCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!validacjaDanych()) {
                    zatwierdźPrzeglądButton.setEnabled(false);
                }

                if (!wymaganaWymianaCzęściCheckBox.isSelected()) {
                    wyzerujStareNoweCzesci();
                    return;
                }

                wybierzNowąCzęśćLabel.setEnabled(true);
                nowaCzescComboBox.setEnabled(true);
                nowaCzescComboBox.setSelectedItem("--Wybierz nową część--");
                try {
                    ArrayList<Czesc> wolneCzesci = Czesc.dajWolneCzesci();
                    for (Czesc czesc : wolneCzesci) {
                        nowaCzescComboBox.addItem(czesc);
                    }
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }


                wybierzStarąCzęśćLabel.setEnabled(true);
                staraCzescComboBox.setEnabled(true);
                staraCzescComboBox.setSelectedItem("--Wybierz starą część--");
                Iterable<Czesc> czesciWPojezdzie = pojazd.dajCzesciPojazdu();
                for (Czesc czesc : czesciWPojezdzie) {
                    staraCzescComboBox.addItem(czesc);
                }


            }
        });
        staraCzescComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {


                if (Objects.equals(staraCzescComboBox.getSelectedItem(), "--Wybierz starą część--") ||
                        staraCzescComboBox.getSelectedItem() == null) {
                    //staraCzescComboBox.getSelectedItem().equals("--Wybierz starą część--")
                    return;
                }

                JComboBox comboBox = (JComboBox) e.getSource();
                staraCzesc = (Czesc) comboBox.getSelectedItem();

                System.out.println("\n* * * Wybrano starą część: " + staraCzesc);

                System.out.println(validacjaDanych());
                if (!validacjaDanych()) {
                    zatwierdźPrzeglądButton.setEnabled(false);
                } else {
                    zatwierdźPrzeglądButton.setEnabled(true);
                }

            }
        });
        nowaCzescComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {


                if (Objects.equals(nowaCzescComboBox.getSelectedItem(), "--Wybierz nową część--") ||
                        nowaCzescComboBox.getSelectedItem() == null) {
                    return;
                }
                JComboBox comboBox = (JComboBox) e.getSource();
                nowaCzesc = (Czesc) comboBox.getSelectedItem();

                System.out.println("\n* * * Wybrano nową część: " + nowaCzesc);

                System.out.println(validacjaDanych());
                if (!validacjaDanych()) {
                    zatwierdźPrzeglądButton.setEnabled(false);
                } else {
                    zatwierdźPrzeglądButton.setEnabled(true);
                }

            }
        });
    }

    public boolean validacjaDanych() {
        if (pojazd == null) {

            return false;
        }
        if (wymaganaWymianaCzęściCheckBox.isSelected() && (staraCzesc == null || nowaCzesc == null)) {
            return false;
        }
        return true;
    }

    public void wyzerujStareNoweCzesci() {
        wybierzNowąCzęśćLabel.setEnabled(false);
        wybierzStarąCzęśćLabel.setEnabled(false);
        nowaCzescComboBox.setEnabled(false);
        nowaCzescComboBox.removeAllItems();
        staraCzescComboBox.setEnabled(false);
        staraCzescComboBox.removeAllItems();
        staraCzesc = null;
        nowaCzesc = null;
    }

    public void setDomyslnePoZmianiePojazdu() {
        pojazd = null;
        zatwierdźPrzeglądButton.setEnabled(false);
        opisPrzegladuLabel.setEnabled(false);
        opisPrzegladuTextField.setEnabled(false);
        opisPrzegladuTextField.setText("");

        pojazdWymagaNaprawyCheckBox.setSelected(false);
        pojazdWymagaNaprawyCheckBox.setEnabled(false);

        opisNaprawyLabel.setEnabled(false);
        opisNaprawyTextField.setEnabled(false);
        opisNaprawyTextField.setText("");

        wymaganaWymianaCzęściCheckBox.setEnabled(false);
        wymaganaWymianaCzęściCheckBox.setSelected(false);


        nowaCzescComboBox.setSelectedItem("--Wybierz nową część--");
        nowaCzescComboBox.removeAllItems();
        wybierzNowąCzęśćLabel.setEnabled(false);
        nowaCzescComboBox.setEnabled(false);
        nowaCzesc = null;


        staraCzescComboBox.setSelectedItem("--Wybierz starą część--");
        staraCzescComboBox.removeAllItems();
        wybierzStarąCzęśćLabel.setEnabled(false);
        staraCzescComboBox.setEnabled(false);
        staraCzesc = null;

        naprawaUdanaCheckBox.setSelected(true);
        naprawaUdanaCheckBox.setEnabled(false);
    }

    public void seWszystkotDomyslne() {
        wybierzPojazdComboBox.setSelectedItem("--Wybierz pojazd--");
        setDomyslnePoZmianiePojazdu();

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
        panel1.setBackground(new Color(-12828863));
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        panel2.setEnabled(true);
        panel1.add(panel2, BorderLayout.CENTER);
        panel2.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panel2.add(panel3, BorderLayout.CENTER);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(panel4, gbc);
        opisPrzegladuLabel = new JLabel();
        opisPrzegladuLabel.setText("Opis przeglądu:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel4.add(opisPrzegladuLabel, gbc);
        opisPrzegladuTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(opisPrzegladuTextField, gbc);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(panel5, gbc);
        pojazdWymagaNaprawyCheckBox = new JCheckBox();
        pojazdWymagaNaprawyCheckBox.setText("Pojazd wymaga naprawy");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel5.add(pojazdWymagaNaprawyCheckBox, gbc);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(panel6, gbc);
        wybierzStarąCzęśćLabel = new JLabel();
        wybierzStarąCzęśćLabel.setText("Wybierz starą część:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel6.add(wybierzStarąCzęśćLabel, gbc);
        staraCzescComboBox = new JComboBox();
        staraCzescComboBox.setEditable(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(staraCzescComboBox, gbc);
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(panel7, gbc);
        wymaganaWymianaCzęściCheckBox = new JCheckBox();
        wymaganaWymianaCzęściCheckBox.setText("Wymagana wymiana części");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel7.add(wymaganaWymianaCzęściCheckBox, gbc);
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(panel8, gbc);
        wybierzNowąCzęśćLabel = new JLabel();
        wybierzNowąCzęśćLabel.setText("Wybierz nową część:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel8.add(wybierzNowąCzęśćLabel, gbc);
        nowaCzescComboBox = new JComboBox();
        nowaCzescComboBox.setEditable(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel8.add(nowaCzescComboBox, gbc);
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(panel9, gbc);
        opisNaprawyLabel = new JLabel();
        opisNaprawyLabel.setText("Opis naprawy:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel9.add(opisNaprawyLabel, gbc);
        opisNaprawyTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel9.add(opisNaprawyTextField, gbc);
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(panel10, gbc);
        naprawaUdanaCheckBox = new JCheckBox();
        naprawaUdanaCheckBox.setHideActionText(false);
        naprawaUdanaCheckBox.setSelected(true);
        naprawaUdanaCheckBox.setText("Naprawa udana");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel10.add(naprawaUdanaCheckBox, gbc);
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(panel11, gbc);
        anulujButton = new JButton();
        anulujButton.setText("Anuluj");
        panel11.add(anulujButton);
        zatwierdźPrzeglądButton = new JButton();
        zatwierdźPrzeglądButton.setText("Zatwierdź przegląd");
        panel11.add(zatwierdźPrzeglądButton);
        final JPanel panel12 = new JPanel();
        panel12.setLayout(new GridBagLayout());
        panel2.add(panel12, BorderLayout.NORTH);
        rozpocznijNaprawęPojazduLabel = new JLabel();
        Font rozpocznijNaprawęPojazduLabelFont = this.$$$getFont$$$(null, -1, 20, rozpocznijNaprawęPojazduLabel.getFont());
        if (rozpocznijNaprawęPojazduLabelFont != null)
            rozpocznijNaprawęPojazduLabel.setFont(rozpocznijNaprawęPojazduLabelFont);
        rozpocznijNaprawęPojazduLabel.setText("Zaraportuj przegląd pojazdu");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel12.add(rozpocznijNaprawęPojazduLabel, gbc);
        wybierzPojazdLabel = new JLabel();
        wybierzPojazdLabel.setText("Wybierz pojazd:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel12.add(wybierzPojazdLabel, gbc);
        wybierzPojazdComboBox = new JComboBox();
        wybierzPojazdComboBox.setEditable(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel12.add(wybierzPojazdComboBox, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}