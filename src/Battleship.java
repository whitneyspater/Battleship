
public class Battleship {
    public static void main(String[] args) {
        int player = 1;
        String[][] player1Ships = new String [10][10];
        String[][] player2Ships = new String [10][10];

        int[][] p1Guessed = new int [10][10];
        int[][] p2Guessed = new int [10][10];

        Ship shipA = new Ship(5);
        Ship shipB = new Ship(4);
        Ship shipC = new Ship(3);
        Ship shipD = new Ship(3);
        Ship shipE = new Ship();

        while(true){
            drawBoard();
            placeShips();
            guessShips();

            //switches players
            if(player == 1){
                player = 2;
            }
            else{
                player = 1;
            }
        }

    }

    //draws the 10 by 10 board onto the screen
    public static void drawBoard(){
        //DRAW METHOD HERE
        //DRAW THE LINES ALWAYS
        //2 IF STATEMENTS, IF PLAYER 1 DRAW PLAYER 1'S GUESSED SHIPS
        //IF PLAYER 2 DRAW PLAYER 2'S GUESSED SHIP
    }

    public static void placeShips(){
        //METHOD TO ALLOW USERS TO PUT THEIR SHIPS IN THE SPOTS THEY CHOOSE
        //USER INPUTS X1, X2, Y1, Y2
    }

    public static void guessShips(){
        //USER GUESSES WHERE OTHER PLAYER PLACED THEIR SHIPS
        //CLICK A LOCATION ON THE BOARD
        //CHECK THE OTHER USER'S SHIP ARRAY TO SEE IF THAT SPOT IS OCCUPIED
        //IF YES- PLACE A GRAY SQUARE ON SCREEN IN BOX, AND FILL GUESSED ARRAY W INT 2 BC OCCUPIED
        //IF NO- PLACE SMALL BLACK DOT ON SCREEN IN BOX, AND FILL GUESSED ARRAY W INT 1 BC EMPTY
        //CLEAR SCREEN AND SWITCH PLAYER
    }


}
