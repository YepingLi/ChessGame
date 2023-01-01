public class Rook extends Piece {
    public Rook(int x, int y, Side side, Board board) {
        super(x, y, side, board);
    }

    @Override
    public boolean canMove(int destX, int destY) {
        if((this.x == destX || this.y == destY))
        {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return this.getSide() == Side.BLACK ?  "♜" : "♖";
    }
}
