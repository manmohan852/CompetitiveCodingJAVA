package site.oopDesign.chess.entity;

public class Bishop extends Piece {

    public Bishop(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        return true;
    }
}
