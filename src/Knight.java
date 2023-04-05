import javax.swing.*;
import java.util.ArrayList;

public class Knight extends Figura {
    public Knight(Polozenie polozenie, boolean biale) {
        super(polozenie, biale);
        if (biale) {
            Icon icon = new ImageIcon("src/Icons/WhiteKnight.png");
            this.setIcon(icon);
            this.setContentAreaFilled(false);
        } else {
            Icon icon = new ImageIcon("src/Icons/BlackKnight.png");
            this.setIcon(icon);
            this.setContentAreaFilled(false);
            this.setEnabled(false);
        }
    }


    @Override
    public ArrayList<Pole> DozwolonePola(Figura figura, boolean checkforChecks, boolean wciskane, Pole pole, boolean puste, Pole pole2) {
        ArrayList<Pole> dostepne = new ArrayList<>();
        Pole szukane;
        if (this.getPolozenie().getX() + 1 < 8 && this.getPolozenie().getY() + 2 < 8) {
            szukane= Main.getPola()[this.getPolozenie().getX() + 1][this.getPolozenie().getY() + 2];
            if (szukane.getClass() == Pole.class)
                dostepne.add(szukane);
            else if (((Figura) szukane).isBiale() != figura.isBiale()) {
                dostepne.add(szukane);
            }
        }
        if (this.getPolozenie().getX() - 1 >=0 && this.getPolozenie().getY() + 2 < 8) {
            szukane= Main.getPola()[this.getPolozenie().getX() - 1][this.getPolozenie().getY() + 2];
            if (szukane.getClass() == Pole.class)
                dostepne.add(szukane);
            else if (((Figura) szukane).isBiale() != figura.isBiale()) {
                dostepne.add(szukane);
            }
        }
        if (this.getPolozenie().getX() + 1 < 8 && this.getPolozenie().getY() - 2 >=0) {
            szukane= Main.getPola()[this.getPolozenie().getX() + 1][this.getPolozenie().getY() - 2];
            if (szukane.getClass() == Pole.class)
                dostepne.add(szukane);
            else if (((Figura) szukane).isBiale() != figura.isBiale()) {
                dostepne.add(szukane);
            }
        }
        if (this.getPolozenie().getX() - 1 >=0 && this.getPolozenie().getY() - 2 >=0) {
            szukane= Main.getPola()[this.getPolozenie().getX() - 1][this.getPolozenie().getY() - 2];
            if (szukane.getClass() == Pole.class)
                dostepne.add(szukane);
            else if (((Figura) szukane).isBiale() != figura.isBiale()) {
                dostepne.add(szukane);
            }
        }
        if (this.getPolozenie().getX() + 2 < 8 && this.getPolozenie().getY() + 1 < 8) {
            szukane= Main.getPola()[this.getPolozenie().getX() + 2][this.getPolozenie().getY() + 1];
            if (szukane.getClass() == Pole.class)
                dostepne.add(szukane);
            else if (((Figura) szukane).isBiale() != figura.isBiale()) {
                dostepne.add(szukane);
            }
        }
        if (this.getPolozenie().getX() - 2 >= 0 && this.getPolozenie().getY() + 1 < 8) {
            szukane= Main.getPola()[this.getPolozenie().getX() - 2][this.getPolozenie().getY() + 1];
            if (szukane.getClass() == Pole.class)
                dostepne.add(szukane);
            else if (((Figura) szukane).isBiale() != figura.isBiale()) {
                dostepne.add(szukane);
            }
        }
        if (this.getPolozenie().getX() + 2 < 8 && this.getPolozenie().getY() - 1 >= 0) {
            szukane= Main.getPola()[this.getPolozenie().getX() + 2][this.getPolozenie().getY() - 1];
            if (szukane.getClass() == Pole.class)
                dostepne.add(szukane);
            else if (((Figura) szukane).isBiale() != figura.isBiale()) {
                dostepne.add(szukane);
            }
        }
        if (this.getPolozenie().getX() - 2 >= 0 && this.getPolozenie().getY() - 1 >= 0) {
            szukane= Main.getPola()[this.getPolozenie().getX() - 2][this.getPolozenie().getY() - 1];
            if (szukane.getClass() == Pole.class)
                dostepne.add(szukane);
            else if (((Figura) szukane).isBiale() != figura.isBiale()) {
                dostepne.add(szukane);
            }
        }
        if(checkforChecks) {
            if (this.isBiale() && Main.getBialyKrol().getAttacksbyBlack().size() == 1) {
                dostepne.clear();
                for (Pole bierka : DozwolonePola(Main.getBialyKrol().getAttacksbyBlack().get(0),false,false,null,false,null))
                    for (Pole bierka1 : DozwolonePola(this,false,false,null,false,null))
                        if (bierka1.getPolozenie().compare(bierka.getPolozenie()))
                            dostepne.add(bierka1);
            } else if (!this.isBiale() && Main.getCzarnyKrol().getAttacksbyWhite().size() == 1) {
                dostepne.clear();
                for (Pole bierka : DozwolonePola(Main.getCzarnyKrol().getAttacksbyWhite().get(0),false,false,null,false,null))
                    for (Pole bierka1 : DozwolonePola(this,false,false,null,false,null))
                        if (bierka1.getPolozenie().compare(bierka.getPolozenie()))
                            dostepne.add(bierka1);
            }
        }if (checkforChecks) {
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

