public class Polozenie {
    private final int X;
    private final int Y;

    public Polozenie(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "X=" + X + " Y=" + Y;
    }
    public boolean compare(Polozenie polozenie){
        return this.getX() == polozenie.getX() && this.getY() == polozenie.getY();
    }
}
