public class Location {
    private final int X;
    private final int Y;

    public Location(int x, int y) {
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
    public boolean compare(Location location){
        return this.getX() == location.getX() && this.getY() == location.getY();
    }
}
