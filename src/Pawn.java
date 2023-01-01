public class Pawn extends Piece {
    public Pawn(int x, int y, Side side, Board board) {
        super(x, y, side, board);
    }

    @Override
    public boolean canMove(int destX, int destY) {
        if ((this.getSide().toString()).equals("BLACK")){
            if((this.y - destY) == 1)
            {
                return false;
            }
        }
        if ((this.getSide().toString()).equals("WHITE")){
            if((this.y - destY) == -1)
            {
                return false;
            }
        }

        if((this.board.get(destX, destY) == null))
        {
            if ((this.y == 6) && ((this.getSide().toString()).equals("WHITE")))//this doesn't consider the diagonal movement for now
            {
                if ((((destY - this.y) == -1) && (destX == this.x)) || (((destY - this.y) == -2) && (destX == this.x)))
                {
                    return true;

                }
            }
            if ((this.y == 1) && ((this.getSide().toString()).equals("BLACK")))//this doesn't consider the diagonal movement for now
            {
                if ((((destY - this.y) == 1) && (destX == this.x)) || (((destY - this.y) == 2) && (destX == this.x)))
                {
                    return true;

                }
            }

            if ((Math.abs(destY - this.y) == 1) && (destX == this.x))
            {
                return true;
            }

        }
        if ((this.getSide().toString()).equals("BLACK"))
        {
            if((Math.abs(destX - x) == 1) && ((destY - y) == 1))
            {
                if (this.board.get(destX, destY) != null)
                {
                    if ((this.board.get(destX, destY).getSide().toString()).equals("WHITE"))
                    {
                        return true;
                    }
                }
            }

        }
        if ((this.getSide().toString()).equals("WHITE"))
        {
            if((Math.abs(destX - x) == 1) && ((destY - y) == -1))
            {
                if (this.board.get(destX, destY) != null)
                {
                    if ((this.board.get(destX, destY).getSide().toString()).equals("BLACK"))
                    {
                        return true;
                    }
                }
            }

        }




        return false;
    }

    @Override
    public String getSymbol() {
        return this.getSide() == Side.BLACK ?   "♟" : "♙";
    }
}
