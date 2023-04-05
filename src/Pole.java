import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pole extends JButton {
    private final ArrayList<Figura> AttacksWhite= new ArrayList<>();
    private final ArrayList<Figura> AttacksBlack= new ArrayList<>();
    private final Color Kolor;
    private Polozenie polozenie;
    public static Pole klikniete;
    public static Pole poprzednie;
    public static Polozenie CanEnPassante;
    public static boolean CanEnPassanteWhite;
    private static Figura LastToMove;

    public Polozenie getPolozenie() {
        return polozenie;
    }

    public void setPolozenie(Polozenie polozenie) {
        this.polozenie = polozenie;
    }

    public Pole(Polozenie polozenie) {
        this.polozenie=polozenie;
        if ((this.polozenie.getX() + this.polozenie.getY()) % 2 == 0) {
            this.setKolor(Color.DARK_GRAY);
            this.Kolor=Color.DARK_GRAY;
        } else {
            this.setKolor(Color.LIGHT_GRAY);
            this.Kolor=Color.LIGHT_GRAY;
        }
        this.addActionListener(e->{
            poprzednie=klikniete;
            klikniete=this;
            if(poprzednie!=null&&poprzednie.getClass()!=Pole.class&&poprzednie!=klikniete)
                if(((Figura)poprzednie).DozwolonePola(((Figura)poprzednie),false,false,null,false,null).contains(klikniete)) {
                    poprzednie.movePiece((Figura) poprzednie);
                }
        });
        this.setBounds(50 * this.polozenie.getX(), 50 * this.polozenie.getY(), 50, 50);
    }

    public Color getKolor() {
        return Kolor;
    }

    public void BackKolor() {
        this.setBackground(this.getKolor());
    }

    public void setKolor(Color kolor) {
        if (kolor == Color.DARK_GRAY) {
            this.setBackground(Color.DARK_GRAY);
            this.setForeground(Color.LIGHT_GRAY);
        }
        if (kolor == Color.LIGHT_GRAY) {
            this.setBackground(Color.LIGHT_GRAY);
            this.setForeground(Color.DARK_GRAY);
        }
    }

    @Override
    public String toString() {
        return getClass() +
                ", polozenie=" + polozenie +
                '}';
    }

    public void movePiece(Figura figura) {
    }

    public static void setLastToMove(Figura lastToMove) {
        LastToMove = lastToMove;
    }

    public ArrayList<Figura> getAttacksbyWhite() {
        return AttacksWhite;
    }

    public ArrayList<Figura> getAttacksbyBlack() {
        return AttacksBlack;
    }
}