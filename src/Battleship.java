/*
 * Description: We have created a two-player game of Battleship. In this game, the winner is the decided
 * based on which player has sunken all of his/her ships before the other player. First, the players
 * are each prompted to type in their coordinates for the purpose of placing their ships. There are
 * 5 ships for each player: one of length 6, length 5, 4, 3, and 2. After placing their ships, the
 * game begins and each player switches back and forth between guessing where the other's ships are.
 * As the game continues, if a player guesses a location and a black dot is printed, they have missed the
 * target of the other player's ship. If a grey box appears, they have hit a ship. After they have
 * gotten the entirety of the ship, the screen will print that they have sunken a ship.
 * Whichever player sinks all 5 ships first wins the game and is then prompted to play again.
 *
 * Assume a friendly user :)
 *
 * (To save time, the coordinates have been chosen by each player and placed on the board already)
 *
 * @author Ashley Dingle, Whitney Spater, Mackenzie Weir
 */

import java.util.Arrays;
import java.util.Scanner;
import java.awt.*;

public class Battleship {
    static Scanner scnr = new Scanner(System.in);

    private static boolean [] p1IsSunk = new boolean [5];
    private static boolean [] p2IsSunk = new boolean [5];

    public static void main(String[] args) {
        int player = 1;

        for(int i = 0; i<5; i++){
            p1IsSunk[i] = false;
            p2IsSunk[i] = false;
        }

        boolean shouldSwitchPlayers = true;

        Ship[] ships1 = new Ship [5];
        Ship[] ships2 = new Ship [5];

        // Creates an array for player 1 and player 2 ships
        int[][] p1Ships = new int [10][10];
        int[][] p2Ships = new int [10][10];

        // Creates an array for player 1 and player 2 guesses
        int[][] p1Guessed = new int [10][10];
        int[][] p2Guessed = new int [10][10];

        // Creates the ships of length 6, 5, 4, 3, 2, 1 to be placed on the board
        ships1[0] = new Ship(6);
        ships1[1] = new Ship(5);
        ships1[2] = new Ship(4);
        ships1[3] = new Ship(3);
        ships1[4] = new Ship(2);

        ships2[0] = new Ship(6);
        ships2[1] = new Ship(5);
        ships2[2] = new Ship(4);
        ships2[3] = new Ship(3);
        ships2[4] = new Ship(2);

        // The board is drawn
        StdDraw.setCanvasSize(500, 500);
        StdDraw.clear(new Color(150, 207, 241));
        StdDraw.setScale(-1.1, 11.1);
        drawBoard();

        // The game begins
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(5, 5, "Get Ready to Play the Game of Battleship! ");
        StdDraw.pause(2000);
        StdDraw.clear(new Color(150, 207, 241));
        drawBoard();

        // PLayer 1 places ships on the board
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(5, 5, "Player 1's turn to place ships");
        StdDraw.pause(2000);
        StdDraw.clear(new Color(150, 207, 241));
        drawBoard();

        for(int i = 0; i < ships1.length; i++){
            placeShips(player, i, ships1[i], p1Ships, p2Ships);
        }

        // Player 2 places ships on the board
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(5, 5, "Player 2's turn to place ships");
        StdDraw.pause(2000);
        StdDraw.clear(new Color(150, 207, 241));
        drawBoard();

        for(int i = 0; i < ships1.length; i++){
            placeShips(player + 1, i, ships2[i], p1Ships, p2Ships);
        }

        // The battle begins and Player 1 is prompted to guess
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(5, 5, "The battle has begun!");
        StdDraw.pause(2000);
        StdDraw.clear(new Color(150, 207, 241));
        drawBoard();
        StdDraw.text(1, 10.5, "Player 1");
        drawBoard();


        while(hasWon(player) < 5){
            if(StdDraw.isMousePressed()){
                guessShips(player, p1Ships, p2Ships, p1Guessed, p2Guessed);
                if(player == 1){
                    if (checkSuccess(p1Guessed, p1Ships, ships1, p1Ships)) {
                        StdDraw.setPenColor(Color.RED);
                        StdDraw.text(9, 10.5, "Sunk ship count: " + hasWon(1));
                        shouldSwitchPlayers = true;
                    }
                    else {
                        shouldSwitchPlayers = true;
                    }
                }
                else if (player == 2){
                    if (checkSuccess(p2Guessed, p2Ships, ships2, p1Ships)) {
                        StdDraw.setPenColor(Color.RED);
                        StdDraw.text(9, 10.5, "Sunk ship count: " + hasWon(2));
                        shouldSwitchPlayers = true;
                    }
                    else {
                        shouldSwitchPlayers = true;
                    }
                }

                // Switches players
                if (shouldSwitchPlayers) {
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.pause(2000);
                    StdDraw.clear(new Color(150, 207, 241));
                    drawBoard();

                    if (player == 1) {
                        player = 2;
                        StdDraw.text(1, 10.5, "Player 2");
                        drawGuessed(p2Guessed);
                    } else {
                        player = 1;
                        StdDraw.text(1, 10.5, "Player 1");
                        drawGuessed(p1Guessed);
                    }
                }
            }
            if(hasWon(player) == 5){
                StdDraw.text(5, 5, "You Win!");
            }
        }
    }

    // Draws the 10 by 10 board onto the screen
    public static void drawBoard() {
        // Draws the grid lines
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

        StdDraw.text(0.5, -0.5, "1");
        StdDraw.text(1.5, -0.5, "2");
        StdDraw.text(2.5, -0.5, "3");
        StdDraw.text(3.5, -0.5, "4");
        StdDraw.text(4.5, -0.5, "5");
        StdDraw.text(5.5, -0.5, "6");
        StdDraw.text(6.5, -0.5, "7");
        StdDraw.text(7.5, -0.5, "8");
        StdDraw.text(8.5, -0.5, "9");
        StdDraw.text(9.5, -0.5, "10");
        StdDraw.text(-0.5, 0.5, "1");
        StdDraw.text(-0.5, 1.5, "2");
        StdDraw.text(-0.5, 2.5, "3");
        StdDraw.text(-0.5, 3.5, "4");
        StdDraw.text(-0.5, 4.5, "5");
        StdDraw.text(-0.5, 5.5, "6");
        StdDraw.text(-0.5, 6.5, "7");
        StdDraw.text(-0.5, 7.5, "8");
        StdDraw.text(-0.5, 8.5, "9");
        StdDraw.text(-0.5, 9.5, "10");
        StdDraw.text(5, 10.5, "Battleship");
    }

    // Method that allows the users to put their ships in the spots they choose
    // User inputs X1, X2, Y1, Y2
    public static void placeShips(int player, int i, Ship ship, int[][]p1Ships, int[][]p2Ships) {

        // Players are prompted to enter their chosen coordinates
        System.out.println("Player " + player + ", Enter the first X coordinate for ship " + (i + 1) + " of length " + (6 - i)+ ": ");
        int x1 = scnr.nextInt();
        System.out.println("Player " + player + ", Enter the first Y coordinate for ship " + (i + 1) + " of length " + (6 - i)+ ": ");
        int y1 = scnr.nextInt();
        System.out.println("Player " + player + ", Enter the second X coordinate for ship " + (i + 1) + " of length " + (6 - i)+ ": ");
        int x2 = scnr.nextInt();
        System.out.println("Player " + player + ", Enter the second Y coordinate for ship " + (i + 1) + " of length " + (6 - i)+ ": ");
        int y2 = scnr.nextInt();

        // If x1 or y1 value is bigger, switches the two values
        int temp;
        if (x1 > x2){
            temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if(y1 > y2){
            temp = y1;
            y1 = y2;
            y2 = temp;
        }

        // Sets the ships onto the screen
        ship.setX1(x1);
        ship.setY1(y1);
        ship.setX2(x2);
        ship.setY2(y2);

        // Draws the ships
        if(player == 1){
            if(shipIsValid(ship, p1Ships)){
                addShip(ship, p1Ships);
                ship.draw();
            }
        }
        else if(player == 2){
            if(shipIsValid(ship, p2Ships)){
                addShip(ship, p2Ships);
                ship.draw();
            }
        }
    }

    public static boolean shipIsValid(Ship ship, int[][]playerShips){
        // Horizontal ships
        if(ship.getX1()!= ship.getX2()){
            for(int i = ship.getX1(); i < ship.getLength(); i++){
                if(playerShips[i][ship.getY1()] != 0){
                    return false;
                }
            }
        }
        // Vertical ships
        if(ship.getY1()!= ship.getY2()){
            for(int i = ship.getY1(); i < ship.getLength(); i++){
                if(playerShips[ship.getX1()][i] != 0){
                    return false;
                }
            }
        }
        return true;
    }


    public static void addShip(Ship ship, int[][]playerShips){
        // Horizontal ships
        if(ship.getX1() != ship.getX2()){
            for(int i = ship.getX1() - 1; i < ship.getX1() + ship.getLength() - 1; i++){
                // Stores the length of each ship in that spot on the board
                playerShips[i][ship.getY1() - 1] = ship.getLength();
            }
        }
        // Vertical ships
        if(ship.getY1()!= ship.getY2()){
            for(int i = ship.getY1() - 1; i < ship.getY1() + ship.getLength() - 1; i++){
                playerShips[ship.getX1() - 1][i] = ship.getLength();
            }
        }
    }

    // Method used for player 1 and player 2 to guess ships
    public static void guessShips(int player, int[][]player1Ships, int[][]player2Ships, int[][] p1Guessed, int[][] p2Guessed){

        double x = StdDraw.mouseX();
        double y = StdDraw.mouseY();

        int nx = (int) x;
        int ny = (int) y;

        if(player == 1) {
            if (player2Ships[nx][ny] != 0 && p1Guessed[nx][ny] == 0) {
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.text(5, 5, "You hit a ship!");
                p1Guessed[nx][ny] = 2;
            }
            else if (player2Ships[nx][ny] == 0 && p1Guessed[nx][ny] == 0) {
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.text(5, 5, "You missed!");
                p1Guessed[nx][ny] = 1;
            }
            drawGuessed(p1Guessed);

            System.out.println();
        }

        if(player == 2){
            if(player1Ships[nx][ny] != 0 && p2Guessed[nx][ny] == 0){
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.text(5, 5, "You hit a ship!");
                p2Guessed[nx][ny] = 2;
            }
            else if(player1Ships[nx][ny] == 0 && p2Guessed[nx][ny] == 0){
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.text(5, 5, "You missed!");
                p2Guessed[nx][ny] = 1;
            }
            drawGuessed(p2Guessed);
        }
    }

    // Draws the gray or black dot to screen based on the guess
    public static void drawGuessed(int[][] playerGuessed){
        for(int i = 0; i < playerGuessed.length; i++){
            for(int j = 0; j < playerGuessed[0].length; j++){
                if(playerGuessed[i][j] == 1){
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.filledCircle(i + 0.5, j + 0.5, 0.05);
                }
                else if (playerGuessed[i][j] == 2){
                    StdDraw.setPenColor(Color.GRAY);
                    StdDraw.filledRectangle(i + 0.5, j + 0.5, 0.5, 0.5);
                }
            }
        }
    }

    // Player makes a guess, if guess is correct, check to see if entire ship has been guessed
    public static boolean checkSuccess(int[][] playerGuessed, int[][]playerShips, Ship[] ships, int[][]p1Ships) {

        int player;
        if(playerShips == p1Ships){
            player = 1;
        }
        else{
            player = 2;
        }
        for (int i = 0; i < playerGuessed.length; i++) {
            for (int j = 0; j < playerGuessed[0].length; j++) {

                if (playerGuessed[i][j] == 2) {
                    int shipNum = playerShips[i][j];
                    Ship ship = ships[6 - shipNum];

                    // Horizontal ship
                    if (ship.getX1() != ship.getX2()) {
                        for (int k = ship.getX1() - 1; k < ship.getLength() + ship.getX1() - 1; k++) {
                            if (playerGuessed[k][ship.getY1() - 1] != 2) {
                                return false;
                            }
                        }
                        if(player == 1){
                            p1IsSunk[6 - shipNum] = true;
                        }
                        else{
                            p2IsSunk[6 - shipNum] = true;
                        }
                        return true;
                    }

                    // Vertical ship
                    if (ship.getY1() != ship.getY2()) {
                        for (int k = ship.getY1() - 1; k < ship.getLength() + ship.getY1() - 1; k++) {
                            if (playerGuessed[ship.getX1() - 1][k] != 2) {
                                return false;
                            }
                        }
                        if(player == 1){
                            p1IsSunk[6 - shipNum] = true;
                        }
                        else{
                            p2IsSunk[6 - shipNum] = true;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int hasWon(int player){
        int num = 0;
        if(player == 1){
            for (int i = 0; i < 5; i++){
                if(p1IsSunk[i] == true){
                    num++;
                }
            }
        }
        else if(player == 2){
            for (int i = 0; i < 5; i++){
                if(p2IsSunk[i] == true){
                    num++;
                }
            }
        }
        return num;
    }
}






