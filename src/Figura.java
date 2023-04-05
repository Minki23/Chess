import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Figura extends Pole {
    private final boolean isBiale;
    private boolean isCLicked = false;
    private King yourKing;
    private ArrayList<Figura> yourPieces;
    private ArrayList<Figura> enemyPieces;

    public boolean isCLicked() {
        return isCLicked;
    }

    public void setCLicked(boolean CLicked) {
        isCLicked = CLicked;
    }

    public Figura(Polozenie polozenie, boolean biale) {
        super(polozenie);
        this.isBiale = biale;
        if ((polozenie.getX() + polozenie.getY()) % 2 == 0) {
            this.setKolor(Color.BLACK);
        } else
            this.setKolor(Color.white);
        this.setBackground(Color.RED);
        this.setBounds(50 * polozenie.getX(), 50 * polozenie.getY(), 50, 50);
        this.addActionListener(e -> {
            ArrayList<Pole> dozwolone = DozwolonePola(this, true, false, null, false, null);
            if (!this.isCLicked()) {
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++)
                        if (dozwolone.contains(Main.getPola()[i][j])) {
                            Main.getPola()[i][j].setBackground(new Color(140, 0, 255));
                            Main.getPola()[i][j].setEnabled(true);
                        }
                if (isBiale)
                    for (Figura figura : Main.getBiale())
                        figura.setEnabled(false);
                else
                    for (Figura figura : Main.getCzarne())
                        figura.setEnabled(false);
                this.setEnabled(true);
                this.setCLicked(true);
            } else {
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++)
                        if (dozwolone.contains(Main.getPola()[i][j])) {
                            Main.getPola()[i][j].BackKolor();
                            Main.getPola()[i][j].setEnabled(false);
                        }
                if (isBiale)
                    for (Figura figura : Main.getBiale())
                        figura.setEnabled(true);
                else
                    for (Figura figura : Main.getCzarne())
                        figura.setEnabled(true);
                this.setEnabled(true);
                this.setCLicked(false);
            }
        });
    }

    public void movePiece(Figura figura) {
        Main.turaBialych = !Main.turaBialych;
        if (Main.turaBialych) {
            for (Pole[] pole : Main.getPola())
                for (Pole pole1 : pole)
                    pole1.setEnabled(false);
            for (Figura bierka : Main.getBiale())
                bierka.setEnabled(true);
        } else {
            for (Pole[] pole : Main.getPola())
                for (Pole pole1 : pole)
                    pole1.setEnabled(false);
            for (Figura bierka : Main.getCzarne())
                bierka.setEnabled(true);
        }
        Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY()].setVisible(false);
        if (Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY()].getClass() != Pole.class) {
            if (((Figura) Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY()]).isBiale)
                Main.getBiale().remove(((Figura) Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY()]));
            else
                Main.getCzarne().remove(((Figura) Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY()]));
        }
        Main.getPola()[figura.getPolozenie().getX()][figura.getPolozenie().getY()].setVisible(false);
        Pole pole = new Pole(new Polozenie(figura.getPolozenie().getX(), figura.getPolozenie().getY()));
        pole.setEnabled(false);
        Main.getPola()[figura.getPolozenie().getX()][figura.getPolozenie().getY()] = pole;
        pole.setBounds(50 * pole.getPolozenie().getX(), 50 * pole.getPolozenie().getY(), 50, 50);
        figura.setBounds(50 * klikniete.getPolozenie().getX(), 50 * klikniete.getPolozenie().getY(), 50, 50);
        figura.setPolozenie(new Polozenie(klikniete.getPolozenie().getX(), klikniete.getPolozenie().getY()));
        Main.getSzachownica().add(Main.getPola()[figura.getPolozenie().getX()][figura.getPolozenie().getY()]);
        Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY()] = figura;
        Main.getSzachownica().add(Main.getPola()[pole.getPolozenie().getX()][pole.getPolozenie().getY()]);
        figura.setVisible(true);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Main.getPola()[i][j].BackKolor();
            }
        }
        poprzednie = klikniete;
        klikniete = null;
        figura.setCLicked(!isCLicked);
        setLastToMove(figura);
        atakuje();
        getYourKing().setChecked(false);
    }

    public boolean isBiale() {
        return isBiale;
    }

    public abstract ArrayList<Pole> DozwolonePola(Figura figura, boolean checkforChecks, boolean wciskane, Pole pole, boolean puste, Pole pole1);

    public King getYourKing() {
        return yourKing;
    }

    public void setYourKing(King yourKing) {
        this.yourKing = yourKing;
    }

    public void atakuje() {
        Main.getBialyKrol().setChecked(false);
        Main.getCzarnyKrol().setChecked(false);
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                Main.getPola()[i][j].getAttacksbyWhite().clear();
                Main.getPola()[i][j].getAttacksbyBlack().clear();
            }
        if (!Main.turaBialych) {
            for (Figura bierka : Main.getBiale()) {
                if (bierka.getClass() == Pion.class) {
                    if (bierka.getPolozenie().getX() - 1 >= 0 && bierka.getPolozenie().getY() + 1 < 8)
                        Main.getPola()[bierka.getPolozenie().getX() - 1][bierka.getPolozenie().getY() + 1].getAttacksbyWhite().add(bierka);
                    if (bierka.getPolozenie().getX() + 1 < 8 && bierka.getPolozenie().getY() + 1 < 8)
                        Main.getPola()[bierka.getPolozenie().getX() + 1][bierka.getPolozenie().getY() + 1].getAttacksbyWhite().add(bierka);
                } else {
                    for (Pole pole1 : bierka.DozwolonePola(bierka, false, false, null, false, null)) {
                        Main.getPola()[pole1.getPolozenie().getX()][pole1.getPolozenie().getY()].getAttacksbyWhite().add(bierka);
                        if (Main.getPola()[pole1.getPolozenie().getX()][pole1.getPolozenie().getY()] == Main.getCzarnyKrol()) {
                            Main.getCzarnyKrol().setChecked(true);
                        }
                    }
                }
            }
            int mozliweRuchy = 0;
            for (Figura figura1 : Main.getCzarne()) {
                mozliweRuchy += figura1.DozwolonePola(figura1, true, false, null, false, null).size();
            }
            if (mozliweRuchy == 0&& Main.getCzarnyKrol().isChecked())
                Popup("Wygrywa bialy");
            else if (mozliweRuchy == 0&&!Main.getCzarnyKrol().isChecked()) {
                Popup("Pat");
            }
        } else {
            for (Figura bierka : Main.getCzarne()) {
                if (bierka.getClass() == Pion.class) {
                    if (bierka.getPolozenie().getX() - 1 >= 0 && bierka.getPolozenie().getY() - 1 >= 0)
                        Main.getPola()[bierka.getPolozenie().getX() - 1][bierka.getPolozenie().getY() - 1].getAttacksbyWhite().add(bierka);
                    if (bierka.getPolozenie().getX() + 1 < 8 && bierka.getPolozenie().getY() - 1 >= 0)
                        Main.getPola()[bierka.getPolozenie().getX() + 1][bierka.getPolozenie().getY() - 1].getAttacksbyWhite().add(bierka);
                } else {
                    for (Pole pole1 : bierka.DozwolonePola(bierka, false, false, null, false, null)) {
                        Main.getPola()[pole1.getPolozenie().getX()][pole1.getPolozenie().getY()].getAttacksbyBlack().add(bierka);
                        if (Main.getPola()[pole1.getPolozenie().getX()][pole1.getPolozenie().getY()] == Main.getBialyKrol()) {
                            Main.getBialyKrol().setChecked(true);
                        }
                    }
                }
            }
            int mozliweRuchy = 0;
            for (Figura figura1 : Main.getBiale()) {
                mozliweRuchy += figura1.DozwolonePola(figura1, true, false, null, false, null).size();
            }
            if (mozliweRuchy == 0&& Main.getBialyKrol().isChecked())
                Popup("Wygrywa czarny");
            else if (mozliweRuchy == 0&&!Main.getBialyKrol().isChecked()) {
                Popup("Pat");
            }
        }
    }

    public ArrayList<Pole> blokuje(ArrayList<Pole> dostepne) {
        dostepne.clear();
        if (getYourKing().isChecked()) {
            for (Pole pole : this.DozwolonePola(this, false, false, null, false, null))
                if (wouldputincheck(pole)) {
                    dostepne.add(pole);
                }
        }
        return dostepne;
    }

    public boolean wouldputincheck(Pole pole) {
        for (Figura figura1 : getEnemyPieces()) {
            if (figura1.DozwolonePola(figura1, false, true, pole, false, null).contains(getYourKing())&&pole!=figura1) {
                return false;
            }
        }
        return true;
    }

    public void setYourPieces(ArrayList<Figura> yourPieces) {
        this.yourPieces = yourPieces;
    }

    public ArrayList<Figura> getEnemyPieces() {
        return enemyPieces;
    }

    public void setEnemyPieces(ArrayList<Figura> enemyPieces) {
        this.enemyPieces = enemyPieces;
    }

    public boolean wouldPutInCheckOnMove(Pole pole, Pole nowe) {
        for (Figura figura1 : getEnemyPieces()) {
            if (pole != figura1 && figura1.DozwolonePola(figura1, false, true, nowe,true, pole).contains(getYourKing())) {
                return false;
            }
        }
        return true;
    }
    public void Popup(String wygrany) {
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                Main.getPola()[i][j].setEnabled(false);
        JDialog dialog = new JDialog();
        dialog.setSize(400,200);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setTitle("Koniec gry");
        JPanel panel =new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel label= new JLabel();
        panel.add(label);
        dialog.add(panel);
        label.setText(wygrany);
    }
}