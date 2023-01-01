import java.util.Stack;

public class Game {
    Board b;
    Stack<String> moveHistory = new Stack<String>();
    Side currentTurn;

    public Game(){
        this.b = new Board();
        this.currentTurn = Side.WHITE;
        // todo: write a constructor that initializes the game with a new board
        // hint: you are also responsible for tracking whose turn it is
    }

    public static String getName() {
        return "Queen's Game-bit";
    }
    public boolean canMove(int x, int y, int destX, int destY, Side s){

       /* TODO write a method that checks if a piece at coordinates x,y can move to coordinates destX,destY
       Conditions for false:
       - Origin or destination coordinates are outside the board
       - Piece at origin is null
       - If source and destination coordinates are the same
       - Piece at origin is not of the same side as s
            - You can check this using piece.getSide()
       - Piece cannot move to the destination by piece movement rules
            - You should check this using Piece.canMove(destX, destY)
       - Destination has a piece of the same Side as the player
       - piece must move "through" a piece to get from (x,y) to (destX,destY) (use isVisible())
            - The knight is the exception to this rule. The knight can hop "over" pieces, so be sure to check for this.
          */
        if(0 > x || x >7 || 0 > y || y >7 || 0 > destX || destX >7 || 0 > destY || destY > 7){
            return false;  //- Origin or destination coordinates are outside the board

        }
        if (this.b.get(x, y) == null){ //- Piece at origin is null
            return false;
        }
        if (x == destX && y ==destY){ //- If source and destination coordinates are the same
            return false;
        }
        if (!((s.toString()).equals(this.b.get(x, y).getSide().toString()))){
            return false;
            //       - Piece at origin is not of the same side as s
            //            - You can check this using piece.getSide()
        }
        if (!(this.b.get(x, y).canMove(destX, destY))){
            return false;
            //       - Piece cannot move to the destination by piece movement rules
            //            - You should check this using Piece.canMove(destX, destY)
        }
        if ((this.b.get(destX, destY) != null ) && (this.b.get(x, y) != null))
        {
            if ((this.b.get(destX, destY).getSide().toString()).equals(this.b.get(x, y).getSide().toString())) {
                return false;
                //             - Destination has a piece of the same Side as the player
            }
        }
        if(!((this.b.get(x, y).getSymbol().equals("♞")) || (this.b.get(x, y).getSymbol().equals("♘")) || isVisible(x, y, destX, destY))){
            return false;
        //           - piece must move "through" a piece to get from (x,y) to (destX,destY) (use isVisible())
            //            - The knight is the exception to this rule. The knight can hop "over" pieces, so be sure to check for this.
        }

        return true;
    }

    /**
     * This method is provided to you in order to help with canMove().
     *
     * In chess, no piece except the knight can "move through" or "hop over" a piece that's in its way
     *
     * This method checks that there are no pieces along the path from (x,y) to (destX,destY).
     * Note that a "path" is only defined if (x,y) and (destX,destY) are on the same row, column, or diagonal.
     * If the requested path is undefined, the method throws an exception.
     *
     * If the path is defined and no piece is found along the path, the method returns true.
     *
     * Don't worry about how this method works or tests and edge cases for it, we will
     * grade you assuming you keep it exactly as provided and use it as a part of your
     * canMove() method.
     */
    private boolean isVisible(int x, int y, int destX, int destY) {
        int diffX = destX - x;
        int diffY = destY - y;

        boolean validCheck = (diffX == 0 || diffY == 0) || (Math.abs(diffX) == Math.abs(diffY));
        if (!validCheck) {
            try {
                throw new Exception("The 'path' between the squares (" + x + ", " + y + ") and (" + destX + ", " + destY +") is undefined");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Diagonal
        if (Math.abs(diffX) == Math.abs(diffY) && Math.abs(diffX) > 1) {
            //Determine direction of move
            int dirX = diffX > 0 ? 1 : -1;
            int dirY = diffY > 0 ? 1 : -1;
            for (int i = x + dirX, j = y + dirY; i != destX && j != destY; i += dirX, j += dirY) {
                if (b.get(i, j) != null) {
                    return false;
                }
            }
        }

        //Linear
        if ((diffX == 0 && Math.abs(diffY) > 1) || (diffY == 0 && Math.abs(diffX) > 1)) {
            if (diffX == 0) {
                int dirY = diffY > 0 ? 1 : -1;
                for (int j = y + dirY; j != destY; j += dirY) {
                    if (b.get(x, j) != null) {
                        return false;
                    }
                }
            } else {
                int dirX = diffX > 0 ? 1 : -1;
                for (int i = x + dirX; i != destX; i += dirX) {
                    if (b.get(i, y) != null) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void appendCheckToHistory(Side side){
        moveHistory.push(side.toString()+ " is in check");
    }

    private void appendWinToHistory(Side side){
        moveHistory.push(side.toString()+ " has won");
    }

    private void appendMoveToHistory(int x, int y, int destX, int destY, Side side){
        Piece toMove = b.get(x,y);
        Piece toCapture = b.get(destX, destY);
        if(toCapture == null){
            moveHistory.push(side.toString() + toMove.getSymbol() + " at "+ x + ", " + y + " to " + destX + ", " + destY);
        }else{
            moveHistory.push(side.toString() + toMove.getSymbol() + " at " + x + ", " + y + " captures " + toCapture.getSymbol() + " at " + destX + ", " + destY);
        }
    }


    /**
     * This method takes as input the coordinates of the piece to move and of the destination to move to.
     *
     * It returns true if the move is valid and false otherwise.
     *
     * Conditions for a valid move are determined in canMove()
     *
     * Upon a successful move, this method also:
     * - updates the board to reflect the move
     * - tracks the move in game history
     *   - also tracks in history if the move was:
     *     - a capture
     *     - result in check EDIT: for either side
     *     - EDIT: also if it results in a win / king capture
     * - updates the current player's turn
     *
     *  x The x coordinate of the piece to move
     *  y The y coordinate of the piece to move
     *  destX The x coordinate of the destination to move to
     *  destY The y coordinate of the destination to move to
     */
    public boolean move(int x, int y, int destX, int destY){
        if ((canMove(x, y, destX, destY, this.currentTurn))) {
            appendMoveToHistory(x, y, destX, destY, this.currentTurn); //call appendMoveToHistory
            Side theHistory = this.currentTurn;
            Piece theObject = this.b.get(x, y);
            Piece theDisobj = this.b.get(destX, destY);
            boolean ab = theObject.move(destX, destY);
            this.currentTurn = Side.negate(getCurrentTurn()); //updates the current player's turn


            if (theDisobj != null) {
                if ((theDisobj.getSymbol()).equals("♚") || (theDisobj.getSymbol()).equals("♔")) {
                    if (((theDisobj.getSide()).toString()).equals(theHistory.toString())) {
                        appendWinToHistory(Side.negate(theHistory));
                        this.currentTurn = Side.negate(getCurrentTurn());
                    } else {
                        appendWinToHistory(theHistory);
                        this.currentTurn = Side.negate(getCurrentTurn());
                    }
                }
            }


            if (isInCheck(this.currentTurn))
            {
                int xKing = b.getKing(this.currentTurn).x;
                int yKing = b.getKing(this.currentTurn).y;
                Side side = this.currentTurn;
                int a = 0;
                for (int i = 0; i < 8; i++)
                {
                    for (int j = 0; j < 8; j++)
                    {
                        if (canMove(i, j, xKing, yKing, Side.negate(side)))
                        {
                            appendCheckToHistory(side);//result in check EDIT: for either side
                            a = 3;
                            break;
                        }
                        if (a == 3){
                            break;
                        }
                    }
                }
            }
            if (isInCheck(Side.negate(this.currentTurn)))
            {
                Side side = this.currentTurn;
                int xxKing = b.getKing(Side.negate(this.currentTurn)).x;
                int yyKing = b.getKing(Side.negate(this.currentTurn)).y;
                int b = 0;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (canMove(i, j, xxKing, yyKing, side)) {
                            appendCheckToHistory(Side.negate(side));//result in check EDIT: for either side
                            b = 5;
                            break;
                        }
                    }
                    if (b == 5){
                        break;
                    }
                }
            }
            //this.currentTurn = Side.negate(theObject.getSide());
            return true;
        }

        return false;
    }


    /**
     * Return true if the King of Side side can be captured by any of
     * the opponent's pieces.
     *
     */
    public boolean isInCheck(Side side) { //in balck turn, see if check white
        if (b.getKing(side) == null){
            return false;
        }
        if (b.getKing(side) == null){
            return false;
        }
        int xKing = b.getKing(side).x;
        int yKing = b.getKing(side).y;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (canMove(i, j, xKing, yKing, Side.negate(side))){
                    return true;
                }
            }
        }
        return false;

        // TODO write this method

    }

    /**
     * Ensures that the game is in the exact same state as a new game
     */
    public void reset(){
        while(!moveHistory.empty()){
            System.out.println(moveHistory.pop());
        }
        b.fillBoard();
        currentTurn = Side.WHITE;
    }


    public static void main(String[] args){
        Board b = new Board();
        System.out.println(b);
    }

    /**
     * Return an array of Strings containing every successful move made during the game,
     * and every time a move resulted in check.
     */
    public String[] moveHistory(){
        String[] out = new String[moveHistory.size()];
        for(int i = 0; i < moveHistory.size(); i++){
            out[i] = moveHistory.get(i);
        }
        return out;
    }

    public Side getCurrentTurn(){
        return currentTurn;
    }
}
