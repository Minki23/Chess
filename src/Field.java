import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Field extends JButton {
    private final ArrayList<Piece> AttacksWhite = new ArrayList<>();
    private final ArrayList<Piece> AttacksBlack = new ArrayList<>();
    private final Color color;
    private Location location;
    public static Field current;
    public static Field last;
    public static Location canEnPassante;
    public static boolean canEnPassanteWhite;
    private static Piece LastToMove;

    public Location getLocalization() {
        return location;
    }

    public void setLocalization(Location location) {
        this.location = location;
    }

    public Field(Location location) {
        this.location = location;
        if ((this.location.getX() + this.location.getY()) % 2 == 0) {
            this.setColor(Color.DARK_GRAY);
            this.color = Color.DARK_GRAY;
        } else {
            this.setColor(Color.LIGHT_GRAY);
            this.color = Color.LIGHT_GRAY;
        }
        this.addActionListener(e -> {
            last = current;
            current = this;
            if (last != null && last.getClass() != Field.class && last != current)
                if (((Piece) last).AvaliableLocation(((Piece) last), false, false, null, false, null).contains(current)) {
                    last.movePiece((Piece) last);
                }
        });
        this.setBounds(50 * this.location.getX(), 50 * this.location.getY(), 50, 50);
    }

    public Color getColor() {
        return color;
    }

    public void BackKolor() {
        this.setBackground(this.getColor());
    }

    public void setColor(Color color) {
        if (color == Color.DARK_GRAY) {
            this.setBackground(Color.DARK_GRAY);
            this.setForeground(Color.LIGHT_GRAY);
        }
        if (color == Color.LIGHT_GRAY) {
            this.setBackground(Color.LIGHT_GRAY);
            this.setForeground(Color.DARK_GRAY);
        }
    }

    @Override
    public String toString() {
        return getClass() +
                ", polozenie=" + location +
                '}';
    }

    public void movePiece(Piece piece) {
    }

    public static void setLastToMove(Piece lastToMove) {
        LastToMove = lastToMove;
    }

    public ArrayList<Piece> getAttacksbyWhite() {
        return AttacksWhite;
    }

    public ArrayList<Piece> getAttacksbyBlack() {
        return AttacksBlack;
    }
}