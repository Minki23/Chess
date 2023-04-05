import javax.swing.*;
import java.util.ArrayList;

public class King extends Piece {
    private boolean isChecked = false;
    private boolean moved;
    private boolean castle;

    public King(Location location, boolean white) {
        super(location, white);
        if (white) {
            Icon icon = new ImageIcon("src/Icons/WhiteKing.png");
            this.setIcon(icon);
            this.setContentAreaFilled(false);
        } else {
            Icon icon = new ImageIcon("src/Icons/BlackKing.png");
            this.setIcon(icon);
            this.setContentAreaFilled(false);
            this.setEnabled(false);
        }
        moved = false;
    }


    @Override
    public ArrayList<Field> freeLocation(Piece piece, boolean checkforchecks, boolean insert, Field insertField, boolean treatAsEmpty, Field treatedAsEmpty) {

        ArrayList<Field> avaliable = new ArrayList<>();
        Field field;
        if (isWhite()) {
            if (this.getLocalization().getY() + 1 < 8) {
                field = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() + 1];
                if (field.getAttacksbyBlack().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() + 1 < 8) {
                field = Main.getFields()[this.getLocalization().getX() + 1][this.getLocalization().getY()];
                if (field.getAttacksbyBlack().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() + 1 < 8 && this.getLocalization().getY() + 1 < 8) {
                field = Main.getFields()[this.getLocalization().getX() + 1][this.getLocalization().getY() + 1];
                if (field.getAttacksbyBlack().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getY() - 1 >= 0) {
                field = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() - 1];
                if (field.getAttacksbyBlack().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() - 1 >= 0) {
                field = Main.getFields()[this.getLocalization().getX() - 1][this.getLocalization().getY()];
                if (field.getAttacksbyBlack().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() - 1 >= 0 && this.getLocalization().getY() - 1 >= 0) {
                field = Main.getFields()[this.getLocalization().getX() - 1][this.getLocalization().getY() - 1];
                if (field.getAttacksbyBlack().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() + 1 < 8 && this.getLocalization().getY() - 1 >= 0) {
                field = Main.getFields()[this.getLocalization().getX() + 1][this.getLocalization().getY() - 1];
                if (field.getAttacksbyBlack().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() - 1 >= 0 && this.getLocalization().getY() + 1 < 8) {
                field = Main.getFields()[this.getLocalization().getX() - 1][this.getLocalization().getY() + 1];
                if (field.getAttacksbyBlack().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (!moved && Main.getFields()[7][0].getClass() == Rook.class && (!((Rook) Main.getFields()[7][0]).hasMoved()) && Main.getFields()[5][0].getClass() == Field.class && Main.getFields()[6][0].getClass() == Field.class) {
                if (Main.getFields()[6][0].getAttacksbyBlack().size() == 0 && Main.getFields()[5][0].getAttacksbyBlack().size() == 0 && !isChecked) {
                    avaliable.add(Main.getFields()[6][0]);
                    castle = true;
                }
            }
            if (!moved && Main.getFields()[0][0].getClass() == Rook.class && (!((Rook) Main.getFields()[0][0]).hasMoved()) && Main.getFields()[3][0].getClass() == Field.class && Main.getFields()[2][0].getClass() == Field.class && Main.getFields()[1][0].getClass() == Field.class) {
                if (Main.getFields()[2][0].getAttacksbyWhite().size() == 0 && Main.getFields()[3][0].getAttacksbyWhite().size() == 0 && !isChecked) {
                    avaliable.add(Main.getFields()[2][0]);
                    castle = true;
                }
            }
        } else {
            if (this.getLocalization().getY() + 1 < 8) {
                field = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() + 1];
                if (field.getAttacksbyWhite().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() + 1 < 8) {
                field = Main.getFields()[this.getLocalization().getX() + 1][this.getLocalization().getY()];
                if (field.getAttacksbyWhite().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() + 1 < 8 && this.getLocalization().getY() + 1 < 8) {
                field = Main.getFields()[this.getLocalization().getX() + 1][this.getLocalization().getY() + 1];
                if (field.getAttacksbyWhite().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getY() - 1 >= 0) {
                field = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() - 1];
                if (field.getAttacksbyWhite().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() - 1 >= 0) {
                field = Main.getFields()[this.getLocalization().getX() - 1][this.getLocalization().getY()];
                if (field.getAttacksbyWhite().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() - 1 >= 0 && this.getLocalization().getY() - 1 >= 0) {
                field = Main.getFields()[this.getLocalization().getX() - 1][this.getLocalization().getY() - 1];
                if (field.getAttacksbyWhite().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() + 1 < 8 && this.getLocalization().getY() - 1 >= 0) {
                field = Main.getFields()[this.getLocalization().getX() + 1][this.getLocalization().getY() - 1];
                if (field.getAttacksbyWhite().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (this.getLocalization().getX() - 1 >= 0 && this.getLocalization().getY() + 1 < 8) {
                field = Main.getFields()[this.getLocalization().getX() - 1][this.getLocalization().getY() + 1];
                if (field.getAttacksbyWhite().size() == 0 && (field.getClass() == Field.class || ((Piece) field).isWhite() != isWhite()))
                    avaliable.add(field);
            }
            if (!moved && Main.getFields()[7][7].getClass() == Rook.class && (!((Rook) Main.getFields()[7][7]).hasMoved()) && Main.getFields()[5][7].getClass() == Field.class && Main.getFields()[6][7].getClass() == Field.class) {
                if (Main.getFields()[6][7].getAttacksbyWhite().size() == 0 && Main.getFields()[5][7].getAttacksbyWhite().size() == 0 && !isChecked) {
                    avaliable.add(Main.getFields()[6][7]);
                    castle = true;
                }
            }
            if (!moved && Main.getFields()[0][7].getClass() == Rook.class && (!((Rook) Main.getFields()[0][7]).hasMoved()) && Main.getFields()[3][7].getClass() == Field.class && Main.getFields()[2][7].getClass() == Field.class && Main.getFields()[1][7].getClass() == Field.class) {
                if (Main.getFields()[2][7].getAttacksbyWhite().size() == 0 && Main.getFields()[3][7].getAttacksbyWhite().size() == 0 && !isChecked) {
                    avaliable.add(Main.getFields()[2][7]);
                    castle = true;
                }
            }
        }
        if (checkforchecks) {
            ArrayList<Field> legal = new ArrayList<>();
            for (Field fieldAvaliable : avaliable) {
                if (wouldPutInCheck(fieldAvaliable))
                    legal.add(fieldAvaliable);
            }
            avaliable = legal;
        }
        return avaliable;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public boolean wouldPutInCheck(Field field) {
        for (Piece enemyPiece : getEnemyPieces()) {
            if (field != enemyPiece) {
                if (isWhite()) {
                    if ((field.getAttacksbyBlack().size() != 0 && enemyPiece.getAttacksbyBlack().size() != 0) || (enemyPiece.freeLocation(enemyPiece, false, false, null, true, this).contains(field) && enemyPiece.getClass() != Pawn.class))
                        return false;
                } else {
                    if ((field.getAttacksbyWhite().size() != 0 && enemyPiece.getAttacksbyWhite().size() != 0) || (enemyPiece.freeLocation(enemyPiece, false, false, null, true, this).contains(field) && enemyPiece.getClass() != Pawn.class))
                        return false;
                }
            }
        }
        return true;
    }

    @Override
    public void movePiece(Piece piece) {
        super.movePiece(piece);
        this.moved = true;
        if (this == Main.getFields()[6][7] && castle) {
            Main.getFields()[7][7].setVisible(false);
            Main.getBlackPieces().remove(Main.getFields()[7][7]);
            Main.getFields()[7][7] = new Field(new Location(7, 7));
            Main.getChessBoard().add(Main.getFields()[7][7]);
            Main.getFields()[5][7].setVisible(false);
            Main.getFields()[5][7] = new Rook(new Location(5, 7), false);
            Main.getBlackPieces().add((Piece) Main.getFields()[5][7]);
            ((Piece) Main.getFields()[5][7]).setYourKing(Main.getBlackKing());
            ((Piece) Main.getFields()[5][7]).setEnemyPieces(Main.getWhitePieces());
            Main.getChessBoard().add(Main.getFields()[5][7]);
        }
        if (this == Main.getFields()[2][7] && castle) {
            Main.getFields()[0][7].setVisible(false);
            Main.getBlackPieces().remove(Main.getFields()[0][7]);
            Main.getFields()[0][7] = new Field(new Location(0, 7));
            Main.getChessBoard().add(Main.getFields()[0][7]);
            Main.getFields()[3][7].setVisible(false);
            Main.getFields()[3][7] = new Rook(new Location(3, 7), false);
            Main.getBlackPieces().add((Piece) Main.getFields()[3][7]);
            ((Piece) Main.getFields()[3][7]).setYourKing(Main.getBlackKing());
            ((Piece) Main.getFields()[3][7]).setEnemyPieces(Main.getWhitePieces());
            Main.getChessBoard().add(Main.getFields()[3][7]);
        }
        if (this == Main.getFields()[6][0] && castle) {
            Main.getFields()[7][0].setVisible(false);
            Main.getBlackPieces().remove(Main.getFields()[7][0]);
            Main.getFields()[7][0] = new Field(new Location(7, 0));
            Main.getChessBoard().add(Main.getFields()[7][0]);
            Main.getFields()[5][0].setVisible(false);
            Main.getFields()[5][0] = new Rook(new Location(5, 0), true);
            Main.getWhitePieces().add((Piece) Main.getFields()[5][0]);
            Main.getFields()[5][0].setEnabled(false);
            ((Piece) Main.getFields()[5][0]).setYourKing(Main.getWhiteKing());
            ((Piece) Main.getFields()[5][0]).setEnemyPieces(Main.getBlackPieces());
            Main.getChessBoard().add(Main.getFields()[5][0]);
        }
        if (this == Main.getFields()[2][0] && castle) {
            Main.getFields()[0][0].setVisible(false);
            Main.getWhitePieces().remove(Main.getFields()[0][0]);
            Main.getFields()[0][0] = new Field(new Location(0, 0));
            Main.getChessBoard().add(Main.getFields()[0][0]);
            Main.getFields()[3][0].setVisible(false);
            Main.getFields()[3][0] = new Rook(new Location(3, 0), true);
            Main.getWhitePieces().add((Piece) Main.getFields()[3][0]);
            Main.getFields()[3][0].setEnabled(false);
            ((Piece) Main.getFields()[3][0]).setYourKing(Main.getWhiteKing());
            ((Piece) Main.getFields()[3][0]).setEnemyPieces(Main.getBlackPieces());
            Main.getChessBoard().add(Main.getFields()[3][0]);
        }
        castle = false;
    }
}

