import java.awt.*;

public class Ship {
    private int xLoc1;
    private int yLoc1;
    private int xLoc2;
    private int yLoc2;
    private int length;

    public Ship(){
        this.xLoc1 = -1;
        this.yLoc1 = -1;
        this.xLoc2 = -3;
        this.yLoc2 = -3;
        this.length = 2;
    }

    public Ship(int length){
        this.xLoc1 = -1;
        this.yLoc1 = -1;
        this.xLoc2 = -1 - length;
        this.yLoc2 = -1 - length;
        this.length = length;
    }

    public int getX1(){
        return xLoc1;
    }

    public int getY1(){
        return yLoc1;
    }

    public int getX2(){
        return xLoc2;
    }

    public int getY2(){
        return yLoc2;
    }

    public int getLength(){
        return length;
    }

    public void setX1(int x1){
        this.xLoc1 = x1;
    }

    public void setY1(int y1){
        this.yLoc1 = y1;
    }

    public void setX2(int x2){
        this.xLoc2 = x2;
    }

    public void setY2(int y2){
        this.yLoc2 = y2;
    }

    public void setLength(int length){
        this.length = length;
    }


    public void switchVals (int val1, int val2){
        int temp = val1;
        val1 = val2;
        val2 = temp;
    }

    // Once the player types in their coordinates, this method fills in the coordinates of the ship into the board with gray rectangles.
    public void draw(){
        StdDraw.setPenColor(Color.GRAY);
        for(int i=0; i<length; i++){
            if (xLoc1 > xLoc2) {
                StdDraw.filledRectangle(xLoc2-0.5+i, yLoc2-0.5, 0.5, 0.5);
            }
            if (yLoc1 > yLoc2) {
                StdDraw.filledRectangle(xLoc2-0.5, yLoc2-0.5+i, 0.5, 0.5);
            }
            if(xLoc1 < xLoc2){
                StdDraw.filledRectangle(xLoc1-0.5+i, yLoc1-0.5, 0.5, 0.5);
            }
            if(yLoc1 < yLoc2){
                StdDraw.filledRectangle(xLoc1-0.5, yLoc1-0.5+i, 0.5, 0.5);
            }


        }

    }

    @Override
    public String toString() {
        return "Ship{" +
                "xLoc1=" + xLoc1 +
                ", yLoc1=" + yLoc1 +
                ", xLoc2=" + xLoc2 +
                ", yLoc2=" + yLoc2 +
                ", length=" + length +
                '}';
    }
}
