import javax.swing.*;
import java.util.ArrayList;

public class Queen extends Figura {
    public Queen(Polozenie polozenie, boolean biale) {
        super(polozenie, biale);
        if (biale) {
            Icon icon = new ImageIcon("src/Icons/WhiteQueen.png");
            this.setIcon(icon);
            this.setContentAreaFilled(false);
        } else {
            Icon icon = new ImageIcon("src/Icons/BlackQueen.png");
            this.setIcon(icon);
            this.setContentAreaFilled(false);
            this.setEnabled(false);
        }
    }

    @Override
    public ArrayList<Pole> DozwolonePola(Figura figura, boolean checkforChecks, boolean wciskane, Pole pole, boolean puste, Pole pole2) {
        ArrayList<Pole> dostepne = new ArrayList<>();
        Pole szukane;
        if(isBiale()) {
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getPolozenie().getY() - i) {
                    szukane = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() - i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getPolozenie().getY() + i) {
                    szukane = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() + i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getPolozenie().getX() + i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() + i][this.getPolozenie().getY()];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0<= this.getPolozenie().getX() - i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() - i][this.getPolozenie().getY()];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getPolozenie().getX() - i && 0 <= this.getPolozenie().getY() - i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() - i][this.getPolozenie().getY() - i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getPolozenie().getX() - i && 8 > this.getPolozenie().getY() + i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() - i][this.getPolozenie().getY() + i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getPolozenie().getX() + i && 8 > this.getPolozenie().getY() + i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() + i][this.getPolozenie().getY() + i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getPolozenie().getX() + i && 0 <= this.getPolozenie().getY() - i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() + i][this.getPolozenie().getY() - i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
        }else{
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getPolozenie().getY() - i) {
                    szukane = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() - i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getPolozenie().getY() + i) {
                    szukane = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() + i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getPolozenie().getX() + i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() + i][this.getPolozenie().getY()];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getPolozenie().getX() - i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() - i][this.getPolozenie().getY()];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getPolozenie().getX() - i && 0 <= this.getPolozenie().getY() - i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() - i][this.getPolozenie().getY() - i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getPolozenie().getX() - i && 8 > this.getPolozenie().getY() + i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() - i][this.getPolozenie().getY() + i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getPolozenie().getX() + i && 8 > this.getPolozenie().getY() + i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() + i][this.getPolozenie().getY() + i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        } else
                            szukane.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getPolozenie().getX() + i && 0 <= this.getPolozenie().getY() - i) {
                    szukane = Main.getPola()[this.getPolozenie().getX() + i][this.getPolozenie().getY() - i];
                    if (szukane.getClass() == Pole.class || (puste && szukane == pole2)) {
                        if (!(wciskane && szukane == pole)) {
                            dostepne.add(szukane);
                        } else i = 8;
                    } else {
                        if (((Figura) szukane).isBiale() != figura.isBiale()) {
                            dostepne.add(szukane);
                        }
                        else
                            szukane.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
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
}

