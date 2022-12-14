package site.oopDesign.chess.entity;

public class Board {
    Box[][] boxes;

    public Board() {
        this.resetBoard();
    }

    public Box getBox(int x, int y) {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            try {
                throw new Exception("Index out of bound");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return boxes[x][y];
    }

    public void resetBoard() {
        // initialize white pieces
        boxes[0][0] = new Box(0, 0, new Rook(true));
        boxes[0][1] = new Box(0, 1, new Knight(true));
        boxes[0][2] = new Box(0, 2, new Bishop(true));
        boxes[0][3] = new Box(0, 0, new Queen(true));
        boxes[0][4] = new Box(0, 1, new King(true));
        boxes[0][5] = new Box(0, 2, new Bishop(true));
        boxes[0][6] = new Box(0, 0, new Knight(true));
        boxes[0][7] = new Box(0, 1, new Rook(true));
        //...
        boxes[1][0] = new Box(1, 0, new Pawn(true));
        boxes[1][1] = new Box(1, 1, new Pawn(true));
        boxes[1][2] = new Box(1, 0, new Pawn(true));
        boxes[1][3] = new Box(1, 1, new Pawn(true));
        boxes[1][4] = new Box(1, 0, new Pawn(true));
        boxes[1][5] = new Box(1, 1, new Pawn(true));
        boxes[1][6] = new Box(1, 0, new Pawn(true));
        boxes[1][7] = new Box(1, 1, new Pawn(true));
        //...

        // initialize black pieces
        boxes[7][0] = new Box(7, 0, new Rook(false));
        boxes[7][1] = new Box(7, 1, new Knight(false));
        boxes[7][2] = new Box(7, 2, new Bishop(false));
        boxes[7][3] = new Box(7, 0, new Queen(false));
        boxes[7][4] = new Box(7, 1, new King(false));
        boxes[7][5] = new Box(7, 2, new Bishop(false));
        boxes[7][6] = new Box(7, 1, new Knight(false));
        boxes[7][7] = new Box(7, 2, new Rook(false));
        //...
        boxes[6][0] = new Box(6, 0, new Pawn(false));
        boxes[6][1] = new Box(6, 1, new Pawn(false));
        boxes[6][2] = new Box(6, 0, new Pawn(false));
        boxes[6][3] = new Box(6, 1, new Pawn(false));
        boxes[6][4] = new Box(6, 0, new Pawn(false));
        boxes[6][5] = new Box(6, 1, new Pawn(false));
        boxes[6][6] = new Box(6, 0, new Pawn(false));
        boxes[6][7] = new Box(6, 1, new Pawn(false));
        //...
        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Box(i, j, null);
            }
        }
    }
}