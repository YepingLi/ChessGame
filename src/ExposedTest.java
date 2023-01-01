import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExposedTest {
    Game g;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        g = new Game();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        g.reset();
    }

    @Tag("score:2")
    @org.junit.jupiter.api.Test
    void GameInitTest() {
        assertNotNull(g.b);
        assertEquals(g.getCurrentTurn(), Side.WHITE);
    }

    @Tag("score:3")
    @org.junit.jupiter.api.Test
    void KingMoveTest1() {
        int startY = 0;
        int startX= 4;
        //check constructor
        assertNotNull(g.b.get(startX,startY).x);
        assertNotNull(g.b.get(startX,startY).y);
        assertNotNull(g.b.get(startX,startY).board);
        assertNotNull(g.b.get(startX,startY).getSide());
        
        //check symbol
        String symbol= "♚";
        assertEquals(g.b.get(startX,startY).getSymbol(), symbol);
        //check canMove
        Integer[] x_coord= new Integer[] {3, 3, 4, 5, 5};
        Integer[] y_coord= new Integer[] {0, 1, 1, 0, 1};
        for(int i=0; i<x_coord.length;i+=1){
            assertTrue(g.b.get(startX,startY).canMove(x_coord[i],y_coord[i]));
        }
    }


    @Tag("score:5")
    @org.junit.jupiter.api.Test
    void QueenMoveTest1() {
        int startY = 0;
        int startX=3;
        //check constructor
        assertNotNull(g.b.get(startX,startY).x);
        assertNotNull(g.b.get(startX,startY).y);
        assertNotNull(g.b.get(startX,startY).board);
        assertNotNull(g.b.get(startX,startY).getSide());
        
        //check symbol
        String symbol= "♛";
        assertEquals(g.b.get(startX,startY).getSymbol(), symbol);
        Integer[] x_coord= new Integer[] {2, 1, 0, 2, 1, 0, 3, 3, 3, 3, 3, 3, 3, 4, 5, 6, 7, 4, 5, 6, 7};
        Integer[] y_coord= new Integer[] {0, 0, 0, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 1, 2, 3, 4};
        //check canMove
        for(int i=0; i<x_coord.length;i+=1){
            assertTrue(g.b.get(startX,startY).canMove(x_coord[i],y_coord[i]));
        }
    }


    @Tag("score:5")
    @org.junit.jupiter.api.Test
    void RookMoveTest1() {
        int startY = 0;
        int startX=0;
        //check constructor
        assertNotNull(g.b.get(startX,startY).x);
        assertNotNull(g.b.get(startX,startY).y);
        assertNotNull(g.b.get(startX,startY).board);
        assertNotNull(g.b.get(startX,startY).getSide());
        
        //check symbol
        String symbol= "♜";
        assertEquals(g.b.get(startX,startY).getSymbol(), symbol);
        Integer[] x_coord_true= new Integer[]{0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7};
        Integer[] y_coord_true= new Integer[]{1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0};
        Integer[] x_coord_false= new Integer[]{1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7};
        Integer[] y_coord_false= new Integer[]{1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7};

        for(int i=0; i<x_coord_true.length;i+=1){
            assertTrue(g.b.get(startX,startY).canMove(x_coord_true[i],y_coord_true[i]));
        }
        for(int i=0; i<x_coord_false.length;i+=1){
            assertFalse(g.b.get(startX,startY).canMove(x_coord_false[i],y_coord_false[i]));
        }
    }


    @Tag("score:5")
    @org.junit.jupiter.api.Test
    void BishopMoveTest1() {
        int startY = 0;
        int startX=2; //5
        //check constructor
        assertNotNull(g.b.get(startX,startY).x);
        assertNotNull(g.b.get(startX,startY).y);
        assertNotNull(g.b.get(startX,startY).board);
        assertNotNull(g.b.get(startX,startY).getSide());
        
        //check symbol
        String symbol= "♝";
        assertEquals(g.b.get(startX,startY).getSymbol(), symbol);

        Integer[] x_coord_true= new Integer[]{0, 1, 3, 4, 5, 6, 7};
        Integer[] y_coord_true= new Integer[]{2, 1, 1, 2, 3, 4, 5};
        Integer[] x_coord_false= new Integer[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7};
        Integer[] y_coord_false= new Integer[]{0, 1, 3, 4, 5, 6, 7, 0, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 0, 2, 3, 4, 5, 6, 7, 0, 1, 3, 4, 5, 6, 7, 0, 1, 2, 4, 5, 6, 7, 0, 1, 2, 3, 5, 6, 7, 0, 1, 2, 3, 4, 6, 7};

        for(int i=0; i<x_coord_true.length;i+=1){
            assertTrue(g.b.get(startX,startY).canMove(x_coord_true[i],y_coord_true[i]));
        }
        for(int i=0; i<x_coord_false.length;i+=1){
            assertFalse(g.b.get(startX,startY).canMove(x_coord_false[i],y_coord_false[i]));
        }

    }


    @Tag("score:5")
    @org.junit.jupiter.api.Test
    void KnightMoveTest1() {
        int startY = 0;
        int startX=1; //6
        //check constructor
        assertNotNull(g.b.get(startX,startY).x);
        assertNotNull(g.b.get(startX,startY).y);
        assertNotNull(g.b.get(startX,startY).board);
        assertNotNull(g.b.get(startX,startY).getSide());
        
        //check symbol
        String symbol= "♞";
        assertEquals(g.b.get(startX,startY).getSymbol(), symbol);

        Integer[] x_coord_true= new Integer[]{0, 2, 3};
        Integer[] y_coord_true= new Integer[]{2, 2, 1};
        Integer[] x_coord_false= new Integer[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7};
        Integer[] y_coord_false= new Integer[]{0, 1, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 0, 1, 3, 4, 5, 6, 7, 0, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7};

        for(int i=0; i<x_coord_true.length;i+=1){
            assertTrue(g.b.get(startX,startY).canMove(x_coord_true[i],y_coord_true[i]));
        }
        for(int i=0; i<x_coord_false.length;i+=1){
            assertFalse(g.b.get(startX,startY).canMove(x_coord_false[i],y_coord_false[i]));
        }
    }


    @Tag("score:2")
    @org.junit.jupiter.api.Test
    void PawnMoveTest1() {
        int startX = 3;
        int startY = 1;
        //check constructor
        assertNotNull(g.b.get(startX,startY).x);
        assertNotNull(g.b.get(startX,startY).y);
        assertNotNull(g.b.get(startX,startY).board);
        assertNotNull(g.b.get(startX,startY).getSide());
        
        //check symbol
        String symbol= "♟";
        assertEquals(g.b.get(startX,startY).getSymbol(), symbol);

        Integer[] x_coord_true= new Integer[]{3, 3};
        Integer[] y_coord_true= new Integer[]{2, 3};
        Integer[] x_coord_false= new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7};
        Integer[] y_coord_false= new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7};

        for(int i=0; i<x_coord_true.length;i+=1){
            assertTrue(g.b.get(startX,startY).canMove(x_coord_true[i],y_coord_true[i]));
        }
        for(int i=0; i<x_coord_false.length;i+=1){
            assertFalse(g.b.get(startX,startY).canMove(x_coord_false[i],y_coord_false[i]));
        }
    }

    @Tag("score:3")
    @org.junit.jupiter.api.Test
    void PawnMoveTest2() {
        int startX = 7;
        int startY = 6;
        //check constructor
        assertNotNull(g.b.get(startX,startY).x);
        assertNotNull(g.b.get(startX,startY).y);
        assertNotNull(g.b.get(startX,startY).board);
        assertNotNull(g.b.get(startX,startY).getSide());
        
        //check symbol
        String symbol= "♙";
        assertEquals(g.b.get(startX,startY).getSymbol(), symbol);

        Integer[] x_coord_true= new Integer[]{7, 7};
        Integer[] y_coord_true= new Integer[]{4, 5};
        Integer[] x_coord_false= new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7};
        Integer[] y_coord_false= new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 7};

        for(int i=0; i<x_coord_true.length;i+=1){
            assertTrue(g.b.get(startX,startY).canMove(x_coord_true[i],y_coord_true[i]));
        }
        for(int i=0; i<x_coord_false.length;i+=1){
            assertFalse(g.b.get(startX,startY).canMove(x_coord_false[i],y_coord_false[i]));
        }
    }

    @Tag("score:3")
    @org.junit.jupiter.api.Test
    void canMoveTest1() {
        //check invalid move out of range or no pieces
        assertFalse(g.canMove(-1, 0, 9, 9, g.getCurrentTurn()));
        assertFalse(g.canMove(0, 6, 8, 8, g.getCurrentTurn()));
        assertFalse(g.canMove(-2, -2, 7, 0, g.getCurrentTurn()));
        assertFalse(g.canMove(2, 2, 7, 2, g.getCurrentTurn()));
        assertFalse(g.canMove(2, 4, 3, 4, g.getCurrentTurn()));
    }

    @Tag("score:3")
    @org.junit.jupiter.api.Test
    void canMoveTest2() {
        //check source and destination are same
        assertFalse(g.canMove(1, 6, 1, 6, g.getCurrentTurn()));
        assertFalse(g.canMove(1, 7, 1, 7, g.getCurrentTurn()));
        assertFalse(g.canMove(6, 7, 6, 7, g.getCurrentTurn()));
        assertFalse(g.canMove(7, 6, 7, 6, g.getCurrentTurn()));
    }

    @Tag("score:3")
    @org.junit.jupiter.api.Test
    void canMoveTest3() {

        assertFalse(g.canMove(1, 6, 7, 0, g.getCurrentTurn()));
        assertFalse(g.canMove(1, 6, 7, 1, g.getCurrentTurn()));
        assertFalse(g.canMove(6, 5, 6, 1, g.getCurrentTurn()));
        assertFalse(g.canMove(6, 5, 6, 0, g.getCurrentTurn()));

        assertTrue(g.canMove(1, 7, 0, 5, g.getCurrentTurn()));
        assertTrue(g.canMove(1, 7, 2, 5, g.getCurrentTurn()));
        assertTrue(g.canMove(6, 7, 5, 5, g.getCurrentTurn()));
        assertTrue(g.canMove(6, 7, 7, 5, g.getCurrentTurn()));

        // checking that black pieces cannot move since it's white's turn
        assertFalse(g.canMove(7, 1, 7, 3, g.getCurrentTurn()));
        assertFalse(g.canMove(7, 1, 7, 4, g.getCurrentTurn()));
        assertFalse(g.canMove(6, 0, 5, 2, g.getCurrentTurn()));
        assertFalse(g.canMove(6, 0, 7, 2, g.getCurrentTurn()));
        assertFalse(g.canMove(1, 0, 0, 2, g.getCurrentTurn()));
        assertFalse(g.canMove(1, 0, 2, 2, g.getCurrentTurn()));
    }

    @Tag("score:3")
    @org.junit.jupiter.api.Test
    void canMoveTest4() {
        g.move(6, 6, 6, 4);
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        g.move(7, 1, 7, 3);
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        g.move(5, 6, 5, 4);
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        //check invalid move out of range
        assertTrue(g.canMove(7, 3, 6, 4, g.getCurrentTurn()));
        assertFalse(g.canMove(7, 3, 6, 1, g.getCurrentTurn()));
    }


    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void sequentialMoveTest1() {
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertFalse(g.move(0,0,0,1));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertFalse(g.move(0,0,0,2));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertFalse(g.move(-1,0,0,3));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertFalse(g.move(1,1,1,3));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertTrue(g.move(0,6,0,4));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        assertTrue(g.move(1,1,1,3));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertTrue(g.move(0, 4, 1, 3));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        assertFalse(g.move(2, 0, 1, 2));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        assertTrue(g.move(2, 1, 2, 3));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertFalse(g.move(5, 7, 5, 6));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertTrue(g.move(0, 7, 0, 1));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        assertFalse(g.move(3, 0, 2, 2));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        assertTrue(g.move(1, 0, 2, 2));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
    }

    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void sequentialMoveTest2() {
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertTrue(g.move(4, 6, 4, 4));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        assertTrue(g.move(3, 1, 3, 3));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertFalse(g.move(2, 0, 4, 2));
        assertFalse(g.move(4, 4, 4, 4));
        assertTrue(g.move(4, 7, 4, 6));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        assertTrue(g.move(3, 3, 4, 4));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertTrue(g.move(3, 7, 4, 7));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        assertFalse(g.move(3, 0, 3, 7));
        assertTrue(g.move(3, 0, 3, 6));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertTrue(g.move(4, 6, 3, 6));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        assertTrue(g.move(4, 0, 3, 1));
        assertEquals(g.getCurrentTurn(), Side.WHITE);
        assertFalse(g.move(4, 7, 3, 6));
        assertTrue(g.move(4, 7, 4, 4));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
    }


    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void isInCheckTest1() {
        g.move(2, 6, 2, 4);
        g.move(4, 1, 4, 3);
        g.move(6, 6, 6, 4);
        g.move(6, 0, 5, 2);
        g.move(3, 6, 3, 4);
        g.move(1, 1, 1, 3);
        assertFalse(g.isInCheck(Side.BLACK));
        assertFalse(g.isInCheck(Side.WHITE));
        g.move(6, 7, 5, 5);
        g.move(5, 2, 6, 4);
        g.move(3, 4, 4, 3);
        g.move(6, 4, 5, 6);
        g.move(4, 7, 5, 6);
        g.move(4, 0, 4, 1);
        g.move(5, 5, 6, 3);
        g.move(4, 1, 4, 2);
        assertTrue(g.isInCheck(Side.BLACK));
        assertFalse(g.isInCheck(Side.WHITE));
        g.move(4, 6, 4, 4);
        assertTrue(g.isInCheck(Side.BLACK));
        assertFalse(g.isInCheck(Side.WHITE));
        g.move(4, 2, 4, 1);
        g.move(3, 7, 3, 3);
        g.move(5, 1, 5, 3);
        g.move(2, 4, 1, 3);
        g.move(3, 1, 3, 2);
        g.move(4, 3, 3, 2);
        assertTrue(g.isInCheck(Side.BLACK));
        assertFalse(g.isInCheck(Side.WHITE));
        g.move(7, 1, 7, 3);
        assertTrue(g.isInCheck(Side.BLACK));
        assertFalse(g.isInCheck(Side.WHITE));
        g.move(3, 2, 4, 1);
    }


    @Tag("score:2")
    @org.junit.jupiter.api.Test
    void moveHistoryTest2(){
        g.move(4, 6, 4, 4);
        g.move(5, 1, 5, 3);
        g.move(3, 6, 3, 4);
        g.move(4, 1, 4, 3);
        g.move(7, 6, 7, 4);
        g.move(1, 1, 1, 3);
        g.move(1, 6, 1, 4);
        g.move(6, 0, 5, 2);
        g.move(5, 7, 1, 3);
        g.move(6, 1, 6, 3);
        g.move(4, 4, 5, 3);
        g.move(5, 0, 1, 4);
        g.move(4, 7, 4, 6);
        g.move(1, 4, 0, 5);
        g.move(6, 7, 5, 5);
        g.move(5, 2, 3, 3);
        g.move(5, 5, 4, 3);
        g.move(7, 0, 5, 0);
        g.move(7, 4, 6, 3);
        g.move(5, 0, 5, 3);
        g.move(3, 7, 3, 5);
        String[] solutions = new String[]{
                "WHITE♙ at 4, 6 to 4, 4",
                "BLACK♟ at 5, 1 to 5, 3",
                "WHITE♙ at 3, 6 to 3, 4",
                "BLACK♟ at 4, 1 to 4, 3",
                "WHITE♙ at 7, 6 to 7, 4",
                "BLACK♟ at 1, 1 to 1, 3",
                "WHITE♙ at 1, 6 to 1, 4",
                "BLACK♞ at 6, 0 to 5, 2",
                "WHITE♗ at 5, 7 captures ♟ at 1, 3",
                "BLACK♟ at 6, 1 to 6, 3",
                "WHITE♙ at 4, 4 captures ♟ at 5, 3",
                "BLACK♝ at 5, 0 captures ♙ at 1, 4",
                "WHITE is in check",
                "WHITE♔ at 4, 7 to 4, 6",
                "BLACK♝ at 1, 4 to 0, 5",
                "WHITE♘ at 6, 7 to 5, 5",
                "BLACK♞ at 5, 2 to 3, 3",
                "WHITE♘ at 5, 5 captures ♟ at 4, 3",
                "BLACK♜ at 7, 0 to 5, 0",
                "WHITE♙ at 7, 4 captures ♟ at 6, 3",
                "BLACK♜ at 5, 0 captures ♙ at 5, 3",
                "WHITE♕ at 3, 7 to 3, 5",
        };
        assertEquals(g.moveHistory().length, solutions.length);
        for (int i = 0; i < g.moveHistory().length; i++) {
            if(!solutions[i].equals(g.moveHistory()[i])){
                fail("Move history is not correct! Expected: " + solutions[i] + " Actual: " + g.moveHistory()[i] + " at index " + i);
            }
        }
    }
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
@Tag("GamePerso2")
@org.junit.jupiter.api.Test
void gamePerso2() {
        /*
        The 1st getCurrentTurn checks if the current turn is white when the game starts
        And the other 2 checks if it gets correctly updated.
         */
    assertEquals(g.getCurrentTurn(), Side.WHITE);
    g.move(4, 6, 4, 4);
    assertEquals(g.getCurrentTurn(), Side.BLACK);
    g.move(4, 1, 4, 3);
    assertEquals(g.getCurrentTurn(), Side.WHITE);
    g.move(6, 7, 5, 5);
    g.move(1, 0, 2, 2);
        /*
        The 1st assertFalse(g.move(...)) checks whether you can move a null Piece
        The 2nd one checks whether you can move a Piece which is not your color
        The 3rd one checks whether you can move a Piece which is your color and in a correct location,
            but to an incorrect location
        The 4th one checks whether you can move a Piece which is your color and in a correct location,
            but there is a another Piece blocking the way
        The 5th one checks for out of bounds scenario
         */
    assertFalse(g.move(2, 4, 2, 3));
    assertFalse(g.move(4, 0, 4, 1));
    assertFalse(g.move(1, 7, 2, 4));
    assertFalse(g.move(3, 7, 3, 2));
    assertFalse(g.move(10, 0, 0, 10));
    g.move(5, 7, 2, 4);
    g.move(6, 0, 5, 2);
    g.move(3, 6, 3, 4);
    g.move(4, 3, 3, 4);
    g.move(4, 7, 5, 7);
    g.move(5, 0, 2, 3);
    g.move(4, 4, 4, 3);
    g.move(3, 1, 3, 3);
    g.move(4, 3, 5, 2);
    g.move(3, 3, 2, 4);
    g.move(3, 7, 4, 7);
    // There are a few checks for isInCheck along the test
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(4, 0, 5, 0);
    g.move(2, 7, 6, 3);
    g.move(6, 1, 5, 2);
    g.move(6, 3, 7, 2);
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(5, 0, 6, 0);
    g.move(1, 7, 2, 5);
    g.move(2, 0, 6, 4);
    g.move(2, 5, 4, 4);
    g.move(1, 1, 1, 2);
    g.move(2, 6, 2, 5);
    g.move(2, 2, 4, 3);
    g.move(4, 7, 3, 7);
    g.move(0, 1, 0, 3);
    g.move(5, 5, 4, 3);
    g.move(6, 4, 3, 7);
    g.move(4, 3, 3, 1);
    g.move(2, 3, 4, 1);
    g.move(4, 4, 5, 2);
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(4, 3, 3, 1);
    g.move(2, 3, 4, 1);
    g.move(4, 4, 5, 2);
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(4, 1, 5, 2);
    g.move(0, 7, 3, 7);
    g.move(1, 2, 1, 3);
    g.move(3, 7, 4, 7);
    g.move(1, 3, 1, 4);
    g.move(4, 7, 4, 0);
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(3, 0, 4, 0);
    g.move(3, 1, 5, 2);
    g.move(6, 0, 6, 1);
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(7, 2, 6, 1);
    // Here it checks whether the game still continues after there is a winner
    assertEquals(g.getCurrentTurn(), Side.WHITE);
    g.move(4, 0, 4, 1);
    assertEquals(g.getCurrentTurn(), Side.WHITE);
    g.move(4, 0, 3, 0);
    assertEquals(g.getCurrentTurn(), Side.WHITE);

    String[] solutions = new String[]{
            "WHITE♙ at 4, 6 to 4, 4",
            "BLACK♟ at 4, 1 to 4, 3",
            "WHITE♘ at 6, 7 to 5, 5",
            "BLACK♞ at 1, 0 to 2, 2",
            "WHITE♗ at 5, 7 to 2, 4",
            "BLACK♞ at 6, 0 to 5, 2",
            "WHITE♙ at 3, 6 to 3, 4",
            "BLACK♟ at 4, 3 captures ♙ at 3, 4",
            "WHITE♔ at 4, 7 to 5, 7",
            "BLACK♝ at 5, 0 to 2, 3",
            "WHITE♙ at 4, 4 to 4, 3",
            "BLACK♟ at 3, 1 to 3, 3",
            "WHITE♙ at 4, 3 captures ♞ at 5, 2",
            "BLACK♟ at 3, 3 captures ♗ at 2, 4",
            "WHITE♕ at 3, 7 to 4, 7",
            "BLACK is in check",
            "BLACK♚ at 4, 0 to 5, 0",
            "WHITE♗ at 2, 7 to 6, 3",
            "BLACK♟ at 6, 1 captures ♙ at 5, 2",
            "WHITE♗ at 6, 3 to 7, 2",
            "BLACK is in check",
            "BLACK♚ at 5, 0 to 6, 0",
            "WHITE♘ at 1, 7 to 2, 5",
            "BLACK♝ at 2, 0 to 6, 4",
            "WHITE♘ at 2, 5 to 4, 4",
            "BLACK♟ at 1, 1 to 1, 2",
            "WHITE♙ at 2, 6 to 2, 5",
            "BLACK♞ at 2, 2 to 4, 3",
            "WHITE♕ at 4, 7 to 3, 7",
            "BLACK♟ at 0, 1 to 0, 3",
            "WHITE♘ at 5, 5 captures ♞ at 4, 3",
            "BLACK♝ at 6, 4 captures ♕ at 3, 7",
            "WHITE♘ at 4, 3 to 3, 1",
            "BLACK♝ at 2, 3 to 4, 1",
            "WHITE♘ at 4, 4 captures ♟ at 5, 2",
            "BLACK is in check",
            "BLACK♝ at 4, 1 captures ♘ at 5, 2",
            "WHITE♖ at 0, 7 captures ♝ at 3, 7",
            "BLACK♟ at 1, 2 to 1, 3",
            "WHITE♖ at 3, 7 to 4, 7",
            "BLACK♟ at 1, 3 to 1, 4",
            "WHITE♖ at 4, 7 to 4, 0",
            "BLACK is in check",
            "BLACK♛ at 3, 0 captures ♖ at 4, 0",
            "WHITE♘ at 3, 1 captures ♝ at 5, 2",
            "BLACK is in check",
            "BLACK♚ at 6, 0 to 6, 1",
            "BLACK is in check",
            "WHITE♗ at 7, 2 captures ♚ at 6, 1",
            "WHITE has won"
    };
    // Here it checks whether you have the correct moveHistory list
    assertEquals(g.moveHistory().length, solutions.length);
    for (int i = 0; i < g.moveHistory().length; i++) {
        if(!solutions[i].equals(g.moveHistory()[i])){
            fail("Move history is not correct! Expected: " + solutions[i] + " Actual: " + g.moveHistory()[i] + " at index " + i);
        }
    }
}




























//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    @Tag("score:2")
    @org.junit.jupiter.api.Test
    void moveHistoryTest3(){
        g.move(6, 6, 6, 4);
        g.move(1, 1, 1, 3);
        g.move(1, 6, 1, 4);
        g.move(7, 1, 7, 3);
        g.move(6, 7, 5, 5);
        g.move(2, 1, 2, 3);
        g.move(3, 6, 3, 4);
        g.move(5, 1, 5, 3);
        g.move(5, 5, 4, 3);
        g.move(6, 1, 6, 3);
        g.move(4, 3, 2, 2);
        g.move(2, 3, 3, 4);
        g.move(6, 4, 5, 3);
        g.move(4, 1, 4, 3);
        g.move(5, 7, 7, 5);
        g.move(3, 0, 2, 1);
        g.move(7, 7, 6, 7);
        g.move(2, 1, 2, 2);
        g.move(2, 6, 2, 4);
        g.move(1, 3, 2, 4);
        g.move(6, 7, 6, 3);
        g.move(4, 3, 4, 4);
        g.move(7, 5, 6, 4);
        g.move(2, 2, 0, 4);
        g.move(5, 3, 5, 2);
        g.move(0, 4, 0, 6);
        g.move(0, 7, 0, 6);
        g.move(4, 0, 3, 0);
        g.move(4, 7, 3, 6);
        g.move(5, 0, 1, 4);
        g.move(3, 6, 3, 5);
        g.move(2, 4, 3, 5);
        String[] solutions = new String[]{
                "WHITE♙ at 6, 6 to 6, 4",
                "BLACK♟ at 1, 1 to 1, 3",
                "WHITE♙ at 1, 6 to 1, 4",
                "BLACK♟ at 7, 1 to 7, 3",
                "WHITE♘ at 6, 7 to 5, 5",
                "BLACK♟ at 2, 1 to 2, 3",
                "WHITE♙ at 3, 6 to 3, 4",
                "BLACK♟ at 5, 1 to 5, 3",
                "WHITE♘ at 5, 5 to 4, 3",
                "BLACK♟ at 6, 1 to 6, 3",
                "WHITE♘ at 4, 3 to 2, 2",
                "BLACK♟ at 2, 3 captures ♙ at 3, 4",
                "WHITE♙ at 6, 4 captures ♟ at 5, 3",
                "BLACK♟ at 4, 1 to 4, 3",
                "WHITE♗ at 5, 7 to 7, 5",
                "BLACK♛ at 3, 0 to 2, 1",
                "WHITE♖ at 7, 7 to 6, 7",
                "BLACK♛ at 2, 1 captures ♘ at 2, 2",
                "WHITE♙ at 2, 6 to 2, 4",
                "BLACK♟ at 1, 3 captures ♙ at 2, 4",
                "WHITE♖ at 6, 7 captures ♟ at 6, 3",
                "BLACK♟ at 4, 3 to 4, 4",
                "WHITE♗ at 7, 5 to 6, 4",
                "BLACK♛ at 2, 2 to 0, 4",
                "WHITE♙ at 5, 3 to 5, 2",
                "BLACK♛ at 0, 4 captures ♙ at 0, 6",
                "WHITE♖ at 0, 7 captures ♛ at 0, 6",
                "BLACK♚ at 4, 0 to 3, 0",
                "WHITE♔ at 4, 7 to 3, 6",
                "BLACK♝ at 5, 0 captures ♙ at 1, 4",
                "WHITE is in check",
                "WHITE♔ at 3, 6 to 3, 5",
                "WHITE is in check",
                "BLACK♟ at 2, 4 captures ♔ at 3, 5",
                "BLACK has won",
        };
        assertEquals(g.moveHistory().length, solutions.length);

        for (int i = 0; i < g.moveHistory().length; i++) {
            if(!solutions[i].equals(g.moveHistory()[i])){
                fail("Move history is not correct! Expected: " + solutions[i] + " Actual: " + g.moveHistory()[i] + " at index " + i);
            }
        }
    }

    @Tag("score:1")
    @org.junit.jupiter.api.Test
    void moveHistoryTest5(){
        g.move(5, 6, 5, 4);
        g.move(3, 1, 3, 3);
        g.move(5, 4, 5, 3);
        g.move(4, 1, 4, 3);
        g.move(6, 6, 6, 4);
        g.move(4, 0, 3, 1);
        g.move(5, 3, 5, 2);
        g.move(1, 1, 1, 3);
        g.move(6, 7, 5, 5);
        g.move(3, 1, 2, 2);
        g.move(2, 6, 2, 4);
        g.move(3, 0, 5, 2);
        g.move(5, 5, 3, 4);
        g.move(2, 2, 1, 2);
        g.move(5, 7, 7, 5);
        g.move(2, 1, 2, 3);
        g.move(2, 4, 3, 3);
        g.move(1, 2, 0, 3);
        g.move(3, 6, 3, 5);
        g.move(0, 3, 0, 4);
        g.move(3, 7, 0, 4);
        String[] solutions = new String[]{
                "WHITE♙ at 5, 6 to 5, 4",
                "BLACK♟ at 3, 1 to 3, 3",
                "WHITE♙ at 5, 4 to 5, 3",
                "BLACK♟ at 4, 1 to 4, 3",
                "WHITE♙ at 6, 6 to 6, 4",
                "BLACK♚ at 4, 0 to 3, 1",
                "WHITE♙ at 5, 3 to 5, 2",
                "BLACK♟ at 1, 1 to 1, 3",
                "WHITE♘ at 6, 7 to 5, 5",
                "BLACK♚ at 3, 1 to 2, 2",
                "WHITE♙ at 2, 6 to 2, 4",
                "BLACK♛ at 3, 0 captures ♙ at 5, 2",
                "WHITE♘ at 5, 5 to 3, 4",
                "BLACK is in check",
                "BLACK♚ at 2, 2 to 1, 2",
                "WHITE♗ at 5, 7 to 7, 5",
                "BLACK♟ at 2, 1 to 2, 3",
                "WHITE♙ at 2, 4 captures ♟ at 3, 3",
                "BLACK♚ at 1, 2 to 0, 3",
                "WHITE♙ at 3, 6 to 3, 5",
                "BLACK♚ at 0, 3 to 0, 4",
                "BLACK is in check",
                "WHITE♕ at 3, 7 captures ♚ at 0, 4",
                "WHITE has won",
        };
        assertEquals(g.moveHistory().length, solutions.length);
        for (int i = 0; i < g.moveHistory().length; i++) {
            if(!solutions[i].equals(g.moveHistory()[i])){
                fail("Move history is not correct! Expected: " + solutions[i] + " Actual: " + g.moveHistory()[i] + " at index " + i);
            }
        }
    }
}