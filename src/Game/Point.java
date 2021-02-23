package Game;

public class Point {
    private int x,y;

    public Point(int x, int y){
        this.x = x;
        this.y =y;
    }

    public void setNewPoint(int x, int y)
    {
        this.x = x;
        this.y =y;
    }

    private int getXY(){
        return Integer.valueOf(String.valueOf(x) + String.valueOf(y));
    }

    public boolean equals( Point pos){
        return this.getXY() == pos.getXY();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
