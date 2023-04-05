import javax.swing.*;
import java.util.ArrayList;

public class Pion extends Figura {
    private boolean wykonanoRuch = false;

    public Pion(Polozenie polozenie, boolean biale) {
        super(polozenie, biale);
        if (biale) {
            Icon icon = new ImageIcon("src/Icons/WhitePawn.png");
            this.setIcon(icon);
            this.setContentAreaFilled(false);
        } else {
            Icon icon = new ImageIcon("src/Icons/BlackPawn.png");
            this.setIcon(icon);
            this.setContentAreaFilled(false);
            this.setEnabled(false);
        }
    }

    @Override
    public void movePiece(Figura figura) {
        if (CanEnPassante != null && klikniete.getPolozenie().compare(CanEnPassante)) {
            if (isBiale()) {
                Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY() - 1].setVisible(false);
                Main.getCzarne().remove(Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY() - 1]);
                Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY() - 1] = new Pole(new Polozenie(klikniete.getPolozenie().getX(), klikniete.getPolozenie().getY() - 1));
                Main.getSzachownica().add(Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY() - 1]);
            } else {
                Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY() + 1].setVisible(false);
                Main.getCzarne().remove(Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY() + 1]);
                Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY() + 1] = new Pole(new Polozenie(klikniete.getPolozenie().getX(), klikniete.getPolozenie().getY() + 1));
                Main.getSzachownica().add(Main.getPola()[klikniete.getPolozenie().getX()][klikniete.getPolozenie().getY() + 1]);
            }
        }
        super.movePiece(figura);
        if (!wykonanoRuch) {
            if (isBiale()) {
                CanEnPassante = new Polozenie(this.getPolozenie().getX(), getPolozenie().getY() - 1);
                CanEnPassanteWhite = true;
            } else {
                CanEnPassante = new Polozenie(this.getPolozenie().getX(), getPolozenie().getY() + 1);
                CanEnPassanteWhite = false;
            }
        } else if (isBiale()) {
            CanEnPassante = new Polozenie(this.getPolozenie().getX(), getPolozenie().getY());
        } else {
            CanEnPassante = new Polozenie(this.getPolozenie().getX(), getPolozenie().getY());
        }
        this.wykonanoRuch = true;
    }

    @Override
    public ArrayList<Pole> DozwolonePola(Figura figura, boolean checkforChecks, boolean wciskane, Pole pole, boolean puste, Pole pole2) {
        ArrayList<Pole> dostepne = new ArrayList<>();
        Pole szukane;
        if (!this.isBiale()) {
            if (this.getPolozenie().getY() - 1 >= 0) {
                szukane = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() - 1];
                if (szukane.getClass() == Pole.class) {
                    dostepne.add(szukane);
                    if (this.getPolozenie().getY() - 2 >= 0) {
                        szukane = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() - 2];
                        if (!wykonanoRuch && szukane.getClass() == Pole.class)
                            dostepne.add(szukane);
                    }
                }
            }
            if (this.getPolozenie().getY() - 1 >= 0 && this.getPolozenie().getX() -1>=0) {
                szukane = Main.getPola()[this.getPolozenie().getX() -1][this.getPolozenie().getY() - 1];
                if (CanEnPassante != null && szukane.getPolozenie().compare(CanEnPassante) && CanEnPassanteWhite != isBiale())
                    dostepne.add(szukane);
                if (szukane.getClass() != Pole.class && ((Figura) szukane).isBiale() != isBiale())
                    dostepne.add(szukane);
            }
            if (this.getPolozenie().getY() - 1 >= 0 && this.getPolozenie().getX() + 1 < 8) {
                szukane = Main.getPola()[this.getPolozenie().getX() + 1][this.getPolozenie().getY() - 1];
                if (CanEnPassante != null && szukane.getPolozenie().compare(CanEnPassante) && CanEnPassanteWhite != isBiale())
                    dostepne.add(szukane);
                if (szukane.getClass() != Pole.class && ((Figura) szukane).isBiale() != isBiale())
                    dostepne.add(szukane);
            }
        } else {
            if (this.getPolozenie().getY() + 1 < 8) {
                szukane = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() + 1];
                if (szukane.getClass() == Pole.class) {
                    dostepne.add(szukane);
                    szukane = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() + 2];
                    if (!wykonanoRuch && szukane.getClass() == Pole.class)
                        dostepne.add(szukane);
                }
            }
            if (this.getPolozenie().getY() + 1 < 8 && this.getPolozenie().getX() - 1 >= 0) {
                szukane = Main.getPola()[this.getPolozenie().getX() - 1][this.getPolozenie().getY() + 1];
                if (CanEnPassante != null && szukane.getPolozenie().compare(CanEnPassante) && CanEnPassanteWhite != isBiale())
                    dostepne.add(szukane);
                if (szukane.getClass() != Pole.class && ((Figura) szukane).isBiale() != isBiale())
                    dostepne.add(szukane);
            }
            if (this.getPolozenie().getY() + 1 < 8 && this.getPolozenie().getX() + 1 < 8) {
                szukane = Main.getPola()[this.getPolozenie().getX() + 1][this.getPolozenie().getY() + 1];
                if (CanEnPassante != null && szukane.getPolozenie().compare(CanEnPassante) && CanEnPassanteWhite != isBiale())
                    dostepne.add(szukane);
                if (szukane.getClass() != Pole.class && ((Figura) szukane).isBiale() != isBiale())
                    dostepne.add(szukane);
            }
        }
        if (checkforChecks) {
            ArrayList<Pole> poprawne = new ArrayList<>();
            for (Pole pole1 : dostepne) {
                if (wouldPutInCheckOnMove(this, pole1))
                    poprawne.add(pole1);
            }
            dostepne = poprawne;
        }
        if (checkforChecks && getYourKing().isChecked())
            dostepne = blokuje(dostepne);
        return dostepne;
    }

    @Override
    public void setPolozenie(Polozenie polozenie) {
        super.setPolozenie(polozenie);
        if (getPolozenie().getY() == 7 || getPolozenie().getY() == 0)
            WybierzFigure(this);
    }

    public void WybierzFigure(Figura figura) {
        ArrayList<Figura> Figury = new ArrayList<>();
        Figury.add(new Queen(figura.getPolozenie(), figura.isBiale()));
        Figury.add(new Rook(figura.getPolozenie(), figura.isBiale()));
        Figury.add(new Bishop(figura.getPolozenie(), figura.isBiale()));
        Figury.add(new Knight(figura.getPolozenie(), figura.isBiale()));
        JDialog dialog = new JDialog();
        dialog.setTitle("Wybierz figure");
        dialog.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        dialog.setSize(220, 100);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        for (int i = 0; i < 4; i++) {
            JButton button = new JButton(Figury.get(i).getIcon());
            button.setBounds(50 * i, 0, 50, 50);
            button.addActionListener(e -> {
                if (figura.isBiale()) {
                    Main.getBiale().remove(figura);
                    Main.getBiale().add(Figury.get(button.getX() / 50));
                    Figury.get(button.getX() / 50).setEnemyPieces(Main.getCzarne());
                    Figury.get(button.getX() / 50).setYourKing(Main.getBialyKrol());
                } else {
                    Main.getCzarne().remove(figura);
                    Main.getCzarne().add(Figury.get(button.getX() / 50));
                    Figury.get(button.getX() / 50).setEnemyPieces(Main.getBiale());
                    Figury.get(button.getX() / 50).setYourKing(Main.getCzarnyKrol());
                }
                Main.getPola()[figura.getPolozenie().getX()][figura.getPolozenie().getY()].setVisible(false);
                Main.getPola()[figura.getPolozenie().getX()][figura.getPolozenie().getY()] = Figury.get(button.getY() / 50);
                Main.getPola()[figura.getPolozenie().getX()][figura.getPolozenie().getY()].setEnabled(false);
                Main.getSzachownica().add(Main.getPola()[figura.getPolozenie().getX()][figura.getPolozenie().getY()]);
                dialog.dispose();
            });
            panel.add(button);
        }
        dialog.add(panel);
        new Pion(new Polozenie(1, 1), false);
    }
}
