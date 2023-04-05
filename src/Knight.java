import javax.swing.*;
import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(Location location, boolean white) {
        super(location, white);
        if (white) {
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
    public ArrayList<Field> freeLocation(Piece piece, boolean checkforChecks, boolean insert, Field insertField, boolean treatAsEmpty, Field treatedAsEmpty) {
        ArrayList<Field> avaliable = new ArrayList<>();
        Field searched;
        if (this.getLocalization().getX() + 1 < 8 && this.getLocalization().getY() + 2 < 8) {
            searched = Main.getFields()[this.getLocalization().getX() + 1][this.getLocalization().getY() + 2];
            if (searched.getClass() == Field.class)
                avaliable.add(searched);
            else if (((Piece) searched).isWhite() != piece.isWhite()) {
                avaliable.add(searched);
            }
        }
        if (this.getLocalization().getX() - 1 >= 0 && this.getLocalization().getY() + 2 < 8) {
            searched = Main.getFields()[this.getLocalization().getX() - 1][this.getLocalization().getY() + 2];
            if (searched.getClass() == Field.class)
                avaliable.add(searched);
            else if (((Piece) searched).isWhite() != piece.isWhite()) {
                avaliable.add(searched);
            }
        }
        if (this.getLocalization().getX() + 1 < 8 && this.getLocalization().getY() - 2 >= 0) {
            searched = Main.getFields()[this.getLocalization().getX() + 1][this.getLocalization().getY() - 2];
            if (searched.getClass() == Field.class)
                avaliable.add(searched);
            else if (((Piece) searched).isWhite() != piece.isWhite()) {
                avaliable.add(searched);
            }
        }
        if (this.getLocalization().getX() - 1 >= 0 && this.getLocalization().getY() - 2 >= 0) {
            searched = Main.getFields()[this.getLocalization().getX() - 1][this.getLocalization().getY() - 2];
            if (searched.getClass() == Field.class)
                avaliable.add(searched);
            else if (((Piece) searched).isWhite() != piece.isWhite()) {
                avaliable.add(searched);
            }
        }
        if (this.getLocalization().getX() + 2 < 8 && this.getLocalization().getY() + 1 < 8) {
            searched = Main.getFields()[this.getLocalization().getX() + 2][this.getLocalization().getY() + 1];
            if (searched.getClass() == Field.class)
                avaliable.add(searched);
            else if (((Piece) searched).isWhite() != piece.isWhite()) {
                avaliable.add(searched);
            }
        }
        if (this.getLocalization().getX() - 2 >= 0 && this.getLocalization().getY() + 1 < 8) {
            searched = Main.getFields()[this.getLocalization().getX() - 2][this.getLocalization().getY() + 1];
            if (searched.getClass() == Field.class)
                avaliable.add(searched);
            else if (((Piece) searched).isWhite() != piece.isWhite()) {
                avaliable.add(searched);
            }
        }
        if (this.getLocalization().getX() + 2 < 8 && this.getLocalization().getY() - 1 >= 0) {
            searched = Main.getFields()[this.getLocalization().getX() + 2][this.getLocalization().getY() - 1];
            if (searched.getClass() == Field.class)
                avaliable.add(searched);
            else if (((Piece) searched).isWhite() != piece.isWhite()) {
                avaliable.add(searched);
            }
        }
        if (this.getLocalization().getX() - 2 >= 0 && this.getLocalization().getY() - 1 >= 0) {
            searched = Main.getFields()[this.getLocalization().getX() - 2][this.getLocalization().getY() - 1];
            if (searched.getClass() == Field.class)
                avaliable.add(searched);
            else if (((Piece) searched).isWhite() != piece.isWhite()) {
                avaliable.add(searched);
            }
        }
        if (checkforChecks) {
            ArrayList<Field> legal = new ArrayList<>();
            for (Field avaliableField : avaliable) {
                if (wouldPutInCheckOnMove(this, avaliableField))
                    legal.add(avaliableField);
            }
            avaliable = legal;
        }
        if (checkforChecks && getYourKing().isChecked())
            avaliable = blocks(avaliable);
        return avaliable;
    }
}

