import javax.swing.*;
import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean moved = false;

    public Pawn(Location location, boolean white) {
        super(location, white);
        if (white) {
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
    public void movePiece(Piece piece) {
        if (canEnPassante != null && current.getLocalization().compare(canEnPassante)) {
            if (isWhite()) {
                Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY() - 1].setVisible(false);
                Main.getBlackPieces().remove(Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY() - 1]);
                Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY() - 1] = new Field(new Location(current.getLocalization().getX(), current.getLocalization().getY() - 1));
                Main.getChessBoard().add(Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY() - 1]);
            } else {
                Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY() + 1].setVisible(false);
                Main.getBlackPieces().remove(Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY() + 1]);
                Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY() + 1] = new Field(new Location(current.getLocalization().getX(), current.getLocalization().getY() + 1));
                Main.getChessBoard().add(Main.getFields()[current.getLocalization().getX()][current.getLocalization().getY() + 1]);
            }
        }
        super.movePiece(piece);
        if (!moved) {
            if (isWhite()) {
                canEnPassante = new Location(this.getLocalization().getX(), getLocalization().getY() - 1);
                canEnPassanteWhite = true;
            } else {
                canEnPassante = new Location(this.getLocalization().getX(), getLocalization().getY() + 1);
                canEnPassanteWhite = false;
            }
        } else if (isWhite()) {
            canEnPassante = new Location(this.getLocalization().getX(), getLocalization().getY());
        } else {
            canEnPassante = new Location(this.getLocalization().getX(), getLocalization().getY());
        }
        this.moved = true;
    }

    @Override
    public ArrayList<Field> freeLocation(Piece piece, boolean checkforChecks, boolean insert, Field insertField, boolean treatAsEmpty, Field treatedAsEmpty) {
        ArrayList<Field> avaliable = new ArrayList<>();
        Field searched;
        if (!this.isWhite()) {
            if (this.getLocalization().getY() - 1 >= 0) {
                searched = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() - 1];
                if (searched.getClass() == Field.class) {
                    avaliable.add(searched);
                    if (this.getLocalization().getY() - 2 >= 0) {
                        searched = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() - 2];
                        if (!moved && searched.getClass() == Field.class)
                            avaliable.add(searched);
                    }
                }
            }
            if (this.getLocalization().getY() - 1 >= 0 && this.getLocalization().getX() -1>=0) {
                searched = Main.getFields()[this.getLocalization().getX() -1][this.getLocalization().getY() - 1];
                if (canEnPassante != null && searched.getLocalization().compare(canEnPassante) && canEnPassanteWhite != isWhite())
                    avaliable.add(searched);
                if (searched.getClass() != Field.class && ((Piece) searched).isWhite() != isWhite())
                    avaliable.add(searched);
            }
            if (this.getLocalization().getY() - 1 >= 0 && this.getLocalization().getX() + 1 < 8) {
                searched = Main.getFields()[this.getLocalization().getX() + 1][this.getLocalization().getY() - 1];
                if (canEnPassante != null && searched.getLocalization().compare(canEnPassante) && canEnPassanteWhite != isWhite())
                    avaliable.add(searched);
                if (searched.getClass() != Field.class && ((Piece) searched).isWhite() != isWhite())
                    avaliable.add(searched);
            }
        } else {
            if (this.getLocalization().getY() + 1 < 8) {
                searched = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() + 1];
                if (searched.getClass() == Field.class) {
                    avaliable.add(searched);
                    searched = Main.getFields()[this.getLocalization().getX()][this.getLocalization().getY() + 2];
                    if (!moved && searched.getClass() == Field.class)
                        avaliable.add(searched);
                }
            }
            if (this.getLocalization().getY() + 1 < 8 && this.getLocalization().getX() - 1 >= 0) {
                searched = Main.getFields()[this.getLocalization().getX() - 1][this.getLocalization().getY() + 1];
                if (canEnPassante != null && searched.getLocalization().compare(canEnPassante) && canEnPassanteWhite != isWhite())
                    avaliable.add(searched);
                if (searched.getClass() != Field.class && ((Piece) searched).isWhite() != isWhite())
                    avaliable.add(searched);
            }
            if (this.getLocalization().getY() + 1 < 8 && this.getLocalization().getX() + 1 < 8) {
                searched = Main.getFields()[this.getLocalization().getX() + 1][this.getLocalization().getY() + 1];
                if (canEnPassante != null && searched.getLocalization().compare(canEnPassante) && canEnPassanteWhite != isWhite())
                    avaliable.add(searched);
                if (searched.getClass() != Field.class && ((Piece) searched).isWhite() != isWhite())
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

    @Override
    public void setLocalization(Location location) {
        super.setLocalization(location);
        if (getLocalization().getY() == 7 || getLocalization().getY() == 0)
            ChooseAPiece(this);
    }

    public void ChooseAPiece(Piece piece) {
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Queen(piece.getLocalization(), piece.isWhite()));
        pieces.add(new Rook(piece.getLocalization(), piece.isWhite()));
        pieces.add(new Bishop(piece.getLocalization(), piece.isWhite()));
        pieces.add(new Knight(piece.getLocalization(), piece.isWhite()));
        JDialog dialog = new JDialog();
        dialog.setTitle("Choose a figure");
        dialog.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        dialog.setSize(220, 100);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        for (int i = 0; i < 4; i++) {
            JButton button = new JButton(pieces.get(i).getIcon());
            button.setBounds(50 * i, 0, 50, 50);
            button.addActionListener(e -> {
                if (piece.isWhite()) {
                    Main.getWhitePieces().remove(piece);
                    Main.getWhitePieces().add(pieces.get(button.getX() / 50));
                    pieces.get(button.getX() / 50).setEnemyPieces(Main.getBlackPieces());
                    pieces.get(button.getX() / 50).setYourKing(Main.getWhiteKing());
                } else {
                    Main.getBlackPieces().remove(piece);
                    Main.getBlackPieces().add(pieces.get(button.getX() / 50));
                    pieces.get(button.getX() / 50).setEnemyPieces(Main.getWhitePieces());
                    pieces.get(button.getX() / 50).setYourKing(Main.getBlackKing());
                }
                Main.getFields()[piece.getLocalization().getX()][piece.getLocalization().getY()].setVisible(false);
                Main.getFields()[piece.getLocalization().getX()][piece.getLocalization().getY()] = pieces.get(button.getY() / 50);
                Main.getFields()[piece.getLocalization().getX()][piece.getLocalization().getY()].setEnabled(false);
                Main.getChessBoard().add(Main.getFields()[piece.getLocalization().getX()][piece.getLocalization().getY()]);
                dialog.dispose();
            });
            panel.add(button);
        }
        dialog.add(panel);
        new Pawn(new Location(1, 1), false);
    }
}
