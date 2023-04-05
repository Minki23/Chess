import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static final JFrame frame = new JFrame();
    private static final Field[][] Fields = new Field[8][8];
    private static final JPanel chessBoard = new JPanel();
    static boolean whitesTurn = true;
    private static King whiteKing;
    private static final ArrayList<Piece> WhitePieces = new ArrayList<>();
    private static King blackKing;
    private static final ArrayList<Piece> BlackPieces = new ArrayList<>();


    public static void main(String[] args) {
        PrepareBoard();
    }

    public static void PrepareBoard() {
        frame.setResizable(false);
        frame.setSize(412, 436);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        chessBoard.setSize(450, 450);
        chessBoard.setLayout(null);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Field field = new Field(new Location(i, j));
                field.setEnabled(false);
                Fields[i][j] = field;
            }
        }
        Fields[0][0] = new Rook(new Location(0, 0), true);
        WhitePieces.add((Piece) Fields[0][0]);
        Fields[7][0] = new Rook(new Location(7, 0), true);
        WhitePieces.add((Piece) Fields[7][0]);
        Fields[0][7] = new Rook(new Location(0, 7), false);
        BlackPieces.add((Piece) Fields[0][7]);
        Fields[7][7] = new Rook(new Location(7, 7), false);
        BlackPieces.add((Piece) Fields[7][7]);
        Fields[6][7] = new Knight(new Location(6, 7), false);
        BlackPieces.add((Piece) Fields[6][7]);
        Fields[1][7] = new Knight(new Location(1, 7), false);
        BlackPieces.add((Piece) Fields[1][7]);
        Fields[6][0] = new Knight(new Location(6, 0), true);
        WhitePieces.add((Piece) Fields[6][0]);
        Fields[1][0] = new Knight(new Location(1, 0), true);
        WhitePieces.add((Piece) Fields[1][0]);
        Fields[5][7] = new Bishop(new Location(5, 7), false);
        BlackPieces.add((Piece) Fields[5][7]);
        Fields[2][7] = new Bishop(new Location(2, 7), false);
        BlackPieces.add((Piece) Fields[2][7]);
        Fields[5][0] = new Bishop(new Location(5, 0), true);
        WhitePieces.add((Piece) Fields[5][0]);
        Fields[2][0] = new Bishop(new Location(2, 0), true);
        WhitePieces.add((Piece) Fields[2][0]);
        Fields[3][7] = new Queen(new Location(3, 7), false);
        BlackPieces.add((Piece) Fields[3][7]);
        Fields[3][0] = new Queen(new Location(3, 0), true);
        WhitePieces.add((Piece) Fields[3][0]);
        Fields[4][7] = new King(new Location(4, 7), false);
        blackKing = (King) Fields[4][7];
        BlackPieces.add((Piece) Fields[4][7]);
        Fields[4][0] = new King(new Location(4, 0), true);
        whiteKing = (King) Fields[4][0];
        WhitePieces.add((Piece) Fields[4][0]);
        for (int i = 0; i < 8; i++) {
            Fields[i][6] = new Pawn(new Location(i, 6), false);
            ((Piece) Fields[i][6]).setYourKing(blackKing);
            BlackPieces.add((Piece) Fields[i][6]);
            Fields[i][1] = new Pawn(new Location(i, 1), true);
            ((Piece) Fields[i][1]).setYourKing(whiteKing);
            WhitePieces.add((Piece) Fields[i][1]);
        }
        for (Piece piece : WhitePieces) {
            piece.setYourKing(whiteKing);
            piece.setYourPieces(WhitePieces);
            piece.setEnemyPieces(BlackPieces);
        }
        for (Piece piece : BlackPieces) {
            piece.setYourKing(blackKing);
            piece.setYourPieces(BlackPieces);
            piece.setEnemyPieces(WhitePieces);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard.add(Fields[i][j]);
            }
        }
        frame.add(chessBoard);
        frame.revalidate();
    }

    public static King getWhiteKing() {
        return whiteKing;
    }

    public static King getBlackKing() {
        return blackKing;
    }

    public static JPanel getChessBoard() {
        return chessBoard;
    }

    public static ArrayList<Piece> getWhitePieces() {
        return WhitePieces;
    }

    public static ArrayList<Piece> getBlackPieces() {
        return BlackPieces;
    }

    public static Field[][] getFields() {
        return Fields;
    }
}