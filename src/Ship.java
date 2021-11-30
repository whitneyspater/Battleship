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

}
