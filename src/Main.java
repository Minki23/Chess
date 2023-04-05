import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static final JFrame frame = new JFrame();
    private static final Pole[][] Pola = new Pole[8][8];
    private static final JPanel szachownica = new JPanel();
    static boolean turaBialych = true;
    private static King BialyKrol;
    private static final ArrayList<Figura> Biale = new ArrayList<>();
    private static King CzarnyKrol;
    private static final ArrayList<Figura> Czarne = new ArrayList<>();


    public static void main(String[] args) {
        PrepareBoard();
    }

    public static void PrepareBoard() {
        frame.setResizable(false);
        frame.setSize(412, 436);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        szachownica.setSize(450, 450);
        szachownica.setLayout(null);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pole pole = new Pole(new Polozenie(i, j));
                pole.setEnabled(false);
                Pola[i][j] = pole;
            }
        }
        Pola[0][0] = new Rook(new Polozenie(0, 0), true);
        Biale.add((Figura) Pola[0][0]);
        Pola[7][0] = new Rook(new Polozenie(7, 0), true);
        Biale.add((Figura) Pola[7][0]);
        Pola[0][7] = new Rook(new Polozenie(0, 7), false);
        Czarne.add((Figura) Pola[0][7]);
        Pola[7][7] = new Rook(new Polozenie(7, 7), false);
        Czarne.add((Figura) Pola[7][7]);
        Pola[6][7] = new Knight(new Polozenie(6, 7), false);
        Czarne.add((Figura) Pola[6][7]);
        Pola[1][7] = new Knight(new Polozenie(1, 7), false);
        Czarne.add((Figura) Pola[1][7]);
        Pola[6][0] = new Knight(new Polozenie(6, 0), true);
        Biale.add((Figura) Pola[6][0]);
        Pola[1][0] = new Knight(new Polozenie(1, 0), true);
        Biale.add((Figura) Pola[1][0]);
        Pola[5][7] = new Bishop(new Polozenie(5, 7), false);
        Czarne.add((Figura) Pola[5][7]);
        Pola[2][7] = new Bishop(new Polozenie(2, 7), false);
        Czarne.add((Figura) Pola[2][7]);
        Pola[5][0] = new Bishop(new Polozenie(5, 0), true);
        Biale.add((Figura) Pola[5][0]);
        Pola[2][0] = new Bishop(new Polozenie(2, 0), true);
        Biale.add((Figura) Pola[2][0]);
        Pola[3][7] = new Queen(new Polozenie(3, 7), false);
        Czarne.add((Figura) Pola[3][7]);
        Pola[3][0] = new Queen(new Polozenie(3, 0), true);
        Biale.add((Figura) Pola[3][0]);
        Pola[4][7] = new King(new Polozenie(4, 7), false);
        CzarnyKrol = (King) Pola[4][7];
        Czarne.add((Figura) Pola[4][7]);
        Pola[4][0] = new King(new Polozenie(4, 0), true);
        BialyKrol = (King) Pola[4][0];
        Biale.add((Figura) Pola[4][0]);
        for (int i = 0; i < 8; i++) {
            Pola[i][6] = new Pion(new Polozenie(i, 6), false);
            ((Figura) Pola[i][6]).setYourKing(CzarnyKrol);
            Czarne.add((Figura) Pola[i][6]);
            Pola[i][1] = new Pion(new Polozenie(i, 1), true);
            ((Figura) Pola[i][1]).setYourKing(BialyKrol);
            Biale.add((Figura) Pola[i][1]);
        }
        for (Figura figura : Biale) {
            figura.setYourKing(BialyKrol);
            figura.setYourPieces(Biale);
            figura.setEnemyPieces(Czarne);
        }
        for (Figura figura : Czarne) {
            figura.setYourKing(CzarnyKrol);
            figura.setYourPieces(Czarne);
            figura.setEnemyPieces(Biale);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                szachownica.add(Pola[i][j]);
            }
        }
        frame.add(szachownica);
        frame.revalidate();
    }

    public static King getBialyKrol() {
        return BialyKrol;
    }

    public static King getCzarnyKrol() {
        return CzarnyKrol;
    }

    public static JPanel getSzachownica() {
        return szachownica;
    }

    public static ArrayList<Figura> getBiale() {
        return Biale;
    }

    public static ArrayList<Figura> getCzarne() {
        return Czarne;
    }

    public static Pole[][] getPola() {
        return Pola;
    }
}