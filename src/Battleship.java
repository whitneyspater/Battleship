
public class Battleship {
    public static void main(String[] args) {
        int player = 1;
        String[][] player1 = new String [10][10];
        String[][] player2 = new String [10][10];

        int[][] p1Guessed = new int [10][10];
        int[][] p2Guessed = new int [10][10];

        Ship shipA = new Ship(5);
        Ship shipB = new Ship(4);
        Ship shipC = new Ship(3);
        Ship shipD = new Ship(3);
        Ship shipE = new Ship();

        drawBoard();
        placeShips();
        guessShips();
        drawShips(player);

        //switches player
        if(player == 1){
            player = 2;
        }
        else{
            player = 1;
        }

    }

    //draws the 10 by 10 board onto the screen
    public static void drawBoard(){
        //DRAW METHOD HERE
    }

    public static void placeShips(){
        //METHOD TO ALLOW USERS TO PUT THEIR SHIPS IN THE SPOTS THEY CHOOSE
    }

    public static void guessShips(){
        //USER GUESSES WHERE OTHER PLAYER PLACED THEIR SHIPS
    }

    public static void drawShips(int player){

    }

}
