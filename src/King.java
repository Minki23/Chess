import javax.swing.*;
import java.util.ArrayList;

public class King extends Figura {
    private boolean isChecked = false;
    private boolean wykonanoRuch;
    private boolean roszada;

    public King(Polozenie polozenie, boolean biale) {
        super(polozenie, biale);
        if (biale) {
            Icon icon = new ImageIcon("src/Icons/WhiteKing.png");
            this.setIcon(icon);
            this.setContentAreaFilled(false);
        } else {
            Icon icon = new ImageIcon("src/Icons/BlackKing.png");
            this.setIcon(icon);
            this.setContentAreaFilled(false);
            this.setEnabled(false);
        }
        wykonanoRuch=false;
    }


    @Override
    public ArrayList<Pole> DozwolonePola(Figura figura, boolean checkforchecks, boolean wciskane, Pole pole1, boolean puste, Pole pole2) {

        ArrayList<Pole> dostepne = new ArrayList<>();
        Pole pole;
        if (isBiale()) {
            if (this.getPolozenie().getY() + 1 < 8) {
                pole = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() + 1];
                if (pole.getAttacksbyBlack().size() == 0 &&(pole.getClass() == Pole.class||((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() + 1 < 8) {
                pole = Main.getPola()[this.getPolozenie().getX() + 1][this.getPolozenie().getY()];
                if (pole.getAttacksbyBlack().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() + 1 < 8 && this.getPolozenie().getY() + 1 < 8) {
                pole = Main.getPola()[this.getPolozenie().getX() + 1][this.getPolozenie().getY() + 1];
                if (pole.getAttacksbyBlack().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getY() - 1 >= 0) {
                pole = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() - 1];
                if (pole.getAttacksbyBlack().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() - 1 >= 0) {
                pole = Main.getPola()[this.getPolozenie().getX() - 1][this.getPolozenie().getY()];
                if (pole.getAttacksbyBlack().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() - 1 >= 0 && this.getPolozenie().getY() - 1 >= 0) {
                pole = Main.getPola()[this.getPolozenie().getX() - 1][this.getPolozenie().getY() - 1];
                if (pole.getAttacksbyBlack().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() + 1 < 8 && this.getPolozenie().getY() - 1 >= 0) {
                pole = Main.getPola()[this.getPolozenie().getX() + 1][this.getPolozenie().getY() - 1];
                if (pole.getAttacksbyBlack().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() - 1 >= 0 && this.getPolozenie().getY() + 1 < 8) {
                pole = Main.getPola()[this.getPolozenie().getX() - 1][this.getPolozenie().getY() + 1];
                if (pole.getAttacksbyBlack().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if(!wykonanoRuch&& Main.getPola()[7][0].getClass()==Rook.class&&(!((Rook) Main.getPola()[7][0]).isWykonanoRuch())&& Main.getPola()[5][0].getClass()== Pole.class&& Main.getPola()[6][0].getClass()== Pole.class){
                if(Main.getPola()[6][0].getAttacksbyBlack().size() == 0&& Main.getPola()[5][0].getAttacksbyBlack().size() == 0&&!isChecked) {
                    dostepne.add(Main.getPola()[6][0]);
                    roszada=true;
                }
            }
            if(!wykonanoRuch&& Main.getPola()[0][0].getClass()==Rook.class&&(!((Rook) Main.getPola()[0][0]).isWykonanoRuch())&& Main.getPola()[3][0].getClass()== Pole.class&& Main.getPola()[2][0].getClass()== Pole.class&& Main.getPola()[1][0].getClass()== Pole.class){
                if(Main.getPola()[2][0].getAttacksbyWhite().size() == 0&& Main.getPola()[3][0].getAttacksbyWhite().size() == 0&&!isChecked) {
                    dostepne.add(Main.getPola()[2][0]);
                    roszada=true;
                }
            }
        } else {
            if (this.getPolozenie().getY() + 1 < 8) {
                pole = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() + 1];
                if (pole.getAttacksbyWhite().size() == 0 &&(pole.getClass() == Pole.class||((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() + 1 < 8) {
                pole = Main.getPola()[this.getPolozenie().getX() + 1][this.getPolozenie().getY()];
                if (pole.getAttacksbyWhite().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() + 1 < 8 && this.getPolozenie().getY() + 1 < 8) {
                pole = Main.getPola()[this.getPolozenie().getX() + 1][this.getPolozenie().getY() + 1];
                if (pole.getAttacksbyWhite().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getY() - 1 >= 0) {
                pole = Main.getPola()[this.getPolozenie().getX()][this.getPolozenie().getY() - 1];
                if (pole.getAttacksbyWhite().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() - 1 >= 0) {
                pole = Main.getPola()[this.getPolozenie().getX() - 1][this.getPolozenie().getY()];
                if (pole.getAttacksbyWhite().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() - 1 >= 0 && this.getPolozenie().getY() - 1 >= 0) {
                pole = Main.getPola()[this.getPolozenie().getX() - 1][this.getPolozenie().getY() - 1];
                if (pole.getAttacksbyWhite().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() + 1 < 8 && this.getPolozenie().getY() - 1 >= 0) {
                pole = Main.getPola()[this.getPolozenie().getX() + 1][this.getPolozenie().getY() - 1];
                if (pole.getAttacksbyWhite().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if (this.getPolozenie().getX() - 1 >= 0 && this.getPolozenie().getY() + 1 < 8) {
                pole = Main.getPola()[this.getPolozenie().getX() - 1][this.getPolozenie().getY() + 1];
                if (pole.getAttacksbyWhite().size() == 0 && (pole.getClass() == Pole.class || ((Figura)pole).isBiale()!=isBiale()))
                    dostepne.add(pole);
            }
            if(!wykonanoRuch&& Main.getPola()[7][7].getClass()==Rook.class&&(!((Rook) Main.getPola()[7][7]).isWykonanoRuch())&& Main.getPola()[5][7].getClass()== Pole.class&& Main.getPola()[6][7].getClass()== Pole.class){
                if(Main.getPola()[6][7].getAttacksbyWhite().size() == 0&& Main.getPola()[5][7].getAttacksbyWhite().size() == 0&&!isChecked) {
                    dostepne.add(Main.getPola()[6][7]);
                    roszada=true;
                }
            }
            if(!wykonanoRuch&& Main.getPola()[0][7].getClass()==Rook.class&&(!((Rook) Main.getPola()[0][7]).isWykonanoRuch())&& Main.getPola()[3][7].getClass()== Pole.class&& Main.getPola()[2][7].getClass()== Pole.class&& Main.getPola()[1][7].getClass()== Pole.class){
                if(Main.getPola()[2][7].getAttacksbyWhite().size() == 0&& Main.getPola()[3][7].getAttacksbyWhite().size() == 0&&!isChecked) {
                    dostepne.add(Main.getPola()[2][7]);
                    roszada=true;
                }
            }
        }
        if (checkforchecks) {
            ArrayList<Pole> poprawne = new ArrayList<>();
            for (Pole pole3 : dostepne) {
                if (wouldputincheck(pole3))
                    poprawne.add(pole3);
            }
            dostepne = poprawne;
        }
        return dostepne;
}

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    @Override
    public boolean wouldputincheck(Pole pole) {
        for (Figura figura1 : getEnemyPieces()) {
            if (pole!=figura1) {
                if(isBiale()) {
                    if ((pole.getAttacksbyBlack().size() != 0 && figura1.getAttacksbyBlack().size() != 0) || (figura1.DozwolonePola(figura1, false, false, null, true, this).contains(pole)&&figura1.getClass()!=Pion.class))
                        return false;
                }
                else {
                    if ((pole.getAttacksbyWhite().size() != 0 && figura1.getAttacksbyWhite().size() != 0) || (figura1.DozwolonePola(figura1, false, false, null, true, this).contains(pole)&&figura1.getClass()!=Pion.class))
                        return false;
                }
            }
        }
        return true;
    }

    @Override
    public void movePiece(Figura figura) {
        super.movePiece(figura);
        this.wykonanoRuch=true;
        if(this== Main.getPola()[6][7]&&roszada){
            Main.getPola()[7][7].setVisible(false);
            Main.getCzarne().remove(Main.getPola()[7][7]);
            Main.getPola()[7][7] = new Pole(new Polozenie(7, 7));
            Main.getSzachownica().add(Main.getPola()[7][7]);
            Main.getPola()[5][7].setVisible(false);
            Main.getPola()[5][7] = new Rook(new Polozenie(5, 7),false);
            Main.getCzarne().add((Figura) Main.getPola()[5][7]);
            ((Figura) Main.getPola()[5][7]).setYourKing(Main.getCzarnyKrol());
            ((Figura) Main.getPola()[5][7]).setEnemyPieces(Main.getBiale());
            Main.getSzachownica().add(Main.getPola()[5][7]);
        }
        if(this== Main.getPola()[2][7]&&roszada){
            Main.getPola()[0][7].setVisible(false);
            Main.getCzarne().remove(Main.getPola()[0][7]);
            Main.getPola()[0][7] = new Pole(new Polozenie(0, 7));
            Main.getSzachownica().add(Main.getPola()[0][7]);
            Main.getPola()[3][7].setVisible(false);
            Main.getPola()[3][7] = new Rook(new Polozenie(3, 7),false);
            Main.getCzarne().add((Figura) Main.getPola()[3][7]);
            ((Figura) Main.getPola()[3][7]).setYourKing(Main.getCzarnyKrol());
            ((Figura) Main.getPola()[3][7]).setEnemyPieces(Main.getBiale());
            Main.getSzachownica().add(Main.getPola()[3][7]);
        }
        if(this== Main.getPola()[6][0]&&roszada){
            Main.getPola()[7][0].setVisible(false);
            Main.getCzarne().remove(Main.getPola()[7][0]);
            Main.getPola()[7][0] = new Pole(new Polozenie(7, 0));
            Main.getSzachownica().add(Main.getPola()[7][0]);
            Main.getPola()[5][0].setVisible(false);
            Main.getPola()[5][0] = new Rook(new Polozenie(5, 0),true);
            Main.getBiale().add((Figura) Main.getPola()[5][0]);
            Main.getPola()[5][0].setEnabled(false);
            ((Figura) Main.getPola()[5][0]).setYourKing(Main.getBialyKrol());
            ((Figura) Main.getPola()[5][0]).setEnemyPieces(Main.getCzarne());
            Main.getSzachownica().add(Main.getPola()[5][0]);
        }
        if(this== Main.getPola()[2][0]&&roszada){
            Main.getPola()[0][0].setVisible(false);
            Main.getBiale().remove(Main.getPola()[0][0]);
            Main.getPola()[0][0] = new Pole(new Polozenie(0, 0));
            Main.getSzachownica().add(Main.getPola()[0][0]);
            Main.getPola()[3][0].setVisible(false);
            Main.getPola()[3][0] = new Rook(new Polozenie(3, 0),true);
            Main.getBiale().add((Figura) Main.getPola()[3][0]);
            Main.getPola()[3][0].setEnabled(false);
            ((Figura) Main.getPola()[3][0]).setYourKing(Main.getBialyKrol());
            ((Figura) Main.getPola()[3][0]).setEnemyPieces(Main.getCzarne());
            Main.getSzachownica().add(Main.getPola()[3][0]);
        }
        roszada=false;
    }
}

