import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Piece extends Field {
    private final boolean white;
    private boolean isCLicked = false;
    private King yourKing;
    private ArrayList<Piece> yourPieces;
    private ArrayList<Piece> enemyPieces;

    public boolean isCLicked() {
        return isCLicked;
    }

    public void setCLicked(boolean CLicked) {
        isCLicked = CLicked;
    }

    public Piece(Location location, boolean white) {
        super(location);
        this.white = white;
        if ((location.getX() + location.getY()) % 2 == 0) {
            this.setColor(Color.BLACK);
        } else
            this.setColor(Color.white);
        this.setBackground(Color.RED);
        this.setBounds(50 * location.getX(), 50 * location.getY(), 50, 50);
        this.addActionListener(e -> {
            ArrayList<Field> free = freeLocation(this, true, false, null, false, null);
            if (!this.isCLicked()) {
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++)
                        if (free.contains(Main.getFields()[i][j])) {
                            Main.getFields()[i][j].setBackground(new Color(140, 0, 255));
                            Main.getFields()[i][j].setEnabled(true);
                        }
                if (this.white)
                    for (Piece piece : Main.getWhitePieces())
                        piece.setEnabled(false);
                else
                    for (Piece piece : Main.getBlackPieces())
                        piece.setEnabled(false);
                this.setEnabled(true);
                this.setCLicked(true);
            } else {
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++)
                        if (free.contains(Main.getFields()[i][j])) {
                            Main.getFields()[i][j].BackKolor();
                            Main.getFields()[i][j].setEnabled(false);
                        }
                if (this.white)
                    for (Piece piece : Main.getWhitePieces())
                        piece.setEnabled(true);
                else
                    for (Piece piece : Main.getBlackPieces())
                        piece.setEnabled(true);
                this.setEnabled(true);
                this.setCLicked(false);
            }
        });
    }

    public void movePiece(Piece piece) {
        Main.whitesTurn = !Main.whitesTurn;
        if (Main.whitesTurn) {
            for (Field[] field : Main.getFields())
                for (Field field1 : field)
                    field1.setEnabled(false);
            for (Piece whitePiece : Main.getWhitePieces())
                whitePiece.setEnabled(true);
        } else {
            for (Field[] field : Main.getFields())
                for (Field field1 : field)
                    field1.setEnabled(false);
            for (Piece whitePiece : Main.getBlackPieces())
                whitePiece.setEnabled(true);
        }
        Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY()].setVisible(false);
        if (Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY()].getClass() != Field.class) {
            if (((Piece) Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY()]).white)
                Main.getWhitePieces().remove(((Piece) Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY()]));
            else
                Main.getBlackPieces().remove(((Piece) Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY()]));
        }
        Main.getFields()[piece.getLocalization().getX()][piece.getLocalization().getY()].setVisible(false);
        Field field = new Field(new Location(piece.getLocalization().getX(), piece.getLocalization().getY()));
        field.setEnabled(false);
        Main.getFields()[piece.getLocalization().getX()][piece.getLocalization().getY()] = field;
        field.setBounds(50 * field.getLocalization().getX(), 50 * field.getLocalization().getY(), 50, 50);
        piece.setBounds(50 * current.getLocalization().getX(), 50 * current.getLocalization().getY(), 50, 50);
        piece.setLocalization(new Location(current.getLocalization().getX(), current.getLocalization().getY()));
        Main.getChessBoard().add(Main.getFields()[piece.getLocalization().getX()][piece.getLocalization().getY()]);
        Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY()] = piece;
        Main.getChessBoard().add(Main.getFields()[field.getLocalization().getX()][field.getLocalization().getY()]);
        piece.setVisible(true);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Main.getFields()[i][j].BackKolor();
            }
        }
        last = current;
        current = null;
        piece.setCLicked(!isCLicked);
        setLastToMove(piece);
        attacks();
        getYourKing().setChecked(false);
    }

    public boolean isWhite() {
        return white;
    }

    public abstract ArrayList<Field> freeLocation(Piece piece, boolean checkforChecks, boolean insert, Field insertField, boolean treatAsEmpty, Field treatedAsEmpty);

    public King getYourKing() {
        return yourKing;
    }

    public void setYourKing(King yourKing) {
        this.yourKing = yourKing;
    }

    public void attacks() {
        Main.getWhiteKing().setChecked(false);
        Main.getBlackKing().setChecked(false);
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                Main.getFields()[i][j].getAttacksbyWhite().clear();
                Main.getFields()[i][j].getAttacksbyBlack().clear();
            }
        if (!Main.whitesTurn) {
            for (Piece whitePiece : Main.getWhitePieces()) {
                if (whitePiece.getClass() == Pawn.class) {
                    if (whitePiece.getLocalization().getX() - 1 >= 0 && whitePiece.getLocalization().getY() + 1 < 8)
                        Main.getFields()[whitePiece.getLocalization().getX() - 1][whitePiece.getLocalization().getY() + 1].getAttacksbyWhite().add(whitePiece);
                    if (whitePiece.getLocalization().getX() + 1 < 8 && whitePiece.getLocalization().getY() + 1 < 8)
                        Main.getFields()[whitePiece.getLocalization().getX() + 1][whitePiece.getLocalization().getY() + 1].getAttacksbyWhite().add(whitePiece);
                } else {
                    for (Field field1 : whitePiece.freeLocation(whitePiece, false, false, null, false, null)) {
                        Main.getFields()[field1.getLocalization().getX()][field1.getLocalization().getY()].getAttacksbyWhite().add(whitePiece);
                        if (Main.getFields()[field1.getLocalization().getX()][field1.getLocalization().getY()] == Main.getBlackKing()) {
                            Main.getBlackKing().setChecked(true);
                        }
                    }
                }
            }
            int legalMoves = 0;
            for (Piece blackPieces : Main.getBlackPieces()) {
                legalMoves += blackPieces.freeLocation(blackPieces, true, false, null, false, null).size();
            }
            if (legalMoves == 0 && Main.getBlackKing().isChecked())
                Popup("White win");
            else if (legalMoves == 0 && !Main.getBlackKing().isChecked()) {
                Popup("Stalemate");
            }
        } else {
            for (Piece blackPiece : Main.getBlackPieces()) {
                if (blackPiece.getClass() == Pawn.class) {
                    if (blackPiece.getLocalization().getX() - 1 >= 0 && blackPiece.getLocalization().getY() - 1 >= 0)
                        Main.getFields()[blackPiece.getLocalization().getX() - 1][blackPiece.getLocalization().getY() - 1].getAttacksbyWhite().add(blackPiece);
                    if (blackPiece.getLocalization().getX() + 1 < 8 && blackPiece.getLocalization().getY() - 1 >= 0)
                        Main.getFields()[blackPiece.getLocalization().getX() + 1][blackPiece.getLocalization().getY() - 1].getAttacksbyWhite().add(blackPiece);
                } else {
                    for (Field field1 : blackPiece.freeLocation(blackPiece, false, false, null, false, null)) {
                        Main.getFields()[field1.getLocalization().getX()][field1.getLocalization().getY()].getAttacksbyBlack().add(blackPiece);
                        if (Main.getFields()[field1.getLocalization().getX()][field1.getLocalization().getY()] == Main.getWhiteKing()) {
                            Main.getWhiteKing().setChecked(true);
                        }
                    }
                }
            }
            int legalMoves = 0;
            for (Piece whitePiece : Main.getWhitePieces()) {
                legalMoves += whitePiece.freeLocation(whitePiece, true, false, null, false, null).size();
            }
            if (legalMoves == 0 && Main.getWhiteKing().isChecked())
                Popup("Black wins");
            else if (legalMoves == 0 && !Main.getWhiteKing().isChecked()) {
                Popup("Stalemate");
            }
        }
    }

    public ArrayList<Field> blocks(ArrayList<Field> avaliable) {
        avaliable.clear();
        if (getYourKing().isChecked()) {
            for (Field field : this.freeLocation(this, false, false, null, false, null))
                if (wouldPutInCheck(field)) {
                    avaliable.add(field);
                }
        }
        return avaliable;
    }

    public boolean wouldPutInCheck(Field field) {
        for (Piece enemyPiece : getEnemyPieces()) {
            if (enemyPiece.freeLocation(enemyPiece, false, true, field, false, null).contains(getYourKing()) && field != enemyPiece) {
                return false;
            }
        }
        return true;
    }

    public void setYourPieces(ArrayList<Piece> yourPieces) {
        this.yourPieces = yourPieces;
    }

    public ArrayList<Piece> getEnemyPieces() {
        return enemyPieces;
    }

    public void setEnemyPieces(ArrayList<Piece> enemyPieces) {
        this.enemyPieces = enemyPieces;
    }

    public boolean wouldPutInCheckOnMove(Field field, Field newField) {
        for (Piece enemyPiece : getEnemyPieces()) {
            if (field != enemyPiece && enemyPiece.freeLocation(enemyPiece, false, true, newField, true, field).contains(getYourKing())) {
                return false;
            }
        }
        return true;
    }

    public void Popup(String winner) {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                Main.getFields()[i][j].setEnabled(false);
        JDialog dialog = new JDialog();
        dialog.setSize(400, 200);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setTitle("Game is over");
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel label = new JLabel();
        panel.add(label);
        dialog.add(panel);
        label.setText(winner);
    }
}