import javax.swing.*;
import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(Location location, boolean white) {
        super(location, white);
        if (white) {
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
    public ArrayList<Field> AvaliableLocation(Piece piece, boolean checkforChecks, boolean insert, Field insertField, boolean treatAsEmpty, Field treatedAsEmpty) {
        ArrayList<Field> avaliable = new ArrayList<>();
        Field searched;
        if (isWhite()) {
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getLocalization().getY() - i) {
                    searched = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() - i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getLocalization().getY() + i) {
                    searched = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() + i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getLocalization().getX() + i) {
                    searched = Main.getFields()[this.getLocalization().getX() + i][this.getLocalization().getY()];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getLocalization().getX() - i) {
                    searched = Main.getFields()[this.getLocalization().getX() - i][this.getLocalization().getY()];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getLocalization().getX() - i && 0 <= this.getLocalization().getY() - i) {
                    searched = Main.getFields()[this.getLocalization().getX() - i][this.getLocalization().getY() - i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getLocalization().getX() - i && 8 > this.getLocalization().getY() + i) {
                    searched = Main.getFields()[this.getLocalization().getX() - i][this.getLocalization().getY() + i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getLocalization().getX() + i && 8 > this.getLocalization().getY() + i) {
                    searched = Main.getFields()[this.getLocalization().getX() + i][this.getLocalization().getY() + i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getLocalization().getX() + i && 0 <= this.getLocalization().getY() - i) {
                    searched = Main.getFields()[this.getLocalization().getX() + i][this.getLocalization().getY() - i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyWhite().add(this);
                        i = 8;
                    }
                }
            }
        } else {
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getLocalization().getY() - i) {
                    searched = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() - i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getLocalization().getY() + i) {
                    searched = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() + i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getLocalization().getX() + i) {
                    searched = Main.getFields()[this.getLocalization().getX() + i][this.getLocalization().getY()];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getLocalization().getX() - i) {
                    searched = Main.getFields()[this.getLocalization().getX() - i][this.getLocalization().getY()];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getLocalization().getX() - i && 0 <= this.getLocalization().getY() - i) {
                    searched = Main.getFields()[this.getLocalization().getX() - i][this.getLocalization().getY() - i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (0 <= this.getLocalization().getX() - i && 8 > this.getLocalization().getY() + i) {
                    searched = Main.getFields()[this.getLocalization().getX() - i][this.getLocalization().getY() + i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getLocalization().getX() + i && 8 > this.getLocalization().getY() + i) {
                    searched = Main.getFields()[this.getLocalization().getX() + i][this.getLocalization().getY() + i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (8 > this.getLocalization().getX() + i && 0 <= this.getLocalization().getY() - i) {
                    searched = Main.getFields()[this.getLocalization().getX() + i][this.getLocalization().getY() - i];
                    if (searched.getClass() == Field.class || (treatAsEmpty && searched == treatedAsEmpty)) {
                        if (!(insert && searched == insertField)) {
                            avaliable.add(searched);
                        } else i = 8;
                    } else {
                        if (((Piece) searched).isWhite() != piece.isWhite()) {
                            avaliable.add(searched);
                        } else
                            searched.getAttacksbyBlack().add(this);
                        i = 8;
                    }
                }
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

