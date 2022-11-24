package site.oopDesign.chess.entity;

public abstract class Piece {

    private boolean killed = false;
    private boolean white = false;

    public Piece(boolean white) {
        this.setWhite(white);
    }

    public boolean isWhite() {
        return this.white == true;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isKilled() {
        return this.killed == true;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public abstract boolean canMove(Board board, Box start, Box end);

    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY){
        if(toX == fromX && toY == fromY)
            return false; //cannot move nothing
        if(toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7 || fromY <0 || fromY > 7)
            return false;
        return true;
    }
}