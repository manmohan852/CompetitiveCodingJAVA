package site.oopDesign.chess.entity;

public class Queen extends Piece {

    public Queen(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(super.isValid(board, start.getX(), start.getY(), end.getX(), end.getY()) == false)
            return false;
        //diagonal
        if(end.getX() - start.getX() == end.getY() - start.getY())
            return true;
        if(end.getX() == start.getX())
            return true;
        if(end.getY() == start.getY())
            return true;
        return false;
    }
}
