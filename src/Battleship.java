
public class Battleship {
    public static void main(String[] args) {
        int[][] board = new int[10][10];
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

        StdDraw.setCanvasSize(500, 500);
        StdDraw.setScale(-0.1, 10.1);

        drawBoard(board);
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


    // draws board on the screen
    public static void drawBoard(int[][] board) {
        // prints the array to console
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // draws the gray/black game pieces on the board
                if (board[i][j] == 1) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                } else if (board[i][j] == 2) {
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                }
            }
        }

        // draws the grid lines
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0, 0, 10, 0);
        StdDraw.line(0, 1, 10, 1);
        StdDraw.line(0, 2, 10, 2);
        StdDraw.line(0, 3, 10, 3);
        StdDraw.line(0, 4, 10, 4);
        StdDraw.line(0, 5, 10, 5);
        StdDraw.line(0, 6, 10, 6);
        StdDraw.line(0, 7, 10, 7);
        StdDraw.line(0, 8, 10, 8);
        StdDraw.line(0, 9, 10, 9);
        StdDraw.line(0, 10, 10, 10);
        StdDraw.line(0, 0, 0, 10);
        StdDraw.line(1, 0, 1, 10);
        StdDraw.line(2, 0, 2, 10);
        StdDraw.line(3, 0, 3, 10);
        StdDraw.line(4, 0, 4, 10);
        StdDraw.line(5, 0, 5, 10);
        StdDraw.line(6, 0, 6, 10);
        StdDraw.line(7, 0, 7, 10);
        StdDraw.line(8, 0, 8, 10);
        StdDraw.line(9, 0, 9, 10);
        StdDraw.line(10, 0, 10, 10);
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
