package Bai01;

abstract class Shape {
    protected int x,y;
    public Shape (int x, int y) {
        this.x=x;
        this.y=y;
    }
    public abstract void draw();
    public abstract void erase();
    public void moveTo(int newX, int newY) {
        erase();
        x=newX;
        y=newY;
        draw();
    }
}

class Circle extends Shape {
    public Circle ( int x, int y ) {
        super(x, y);
    }
    public void draw() {
        System.out.println("Vẽ hình tròn tại:"+ "("+x+","+y+")");
    }
    public void erase() {
        System.out.println("Xoá hình tròn tại:"+ "("+x+","+y+")");
    }
}
class Square extends Shape {
    public Square ( int x, int y ) {
        super(x, y);
    }
    public void draw() {
        System.out.println("Vẽ hình vuông tại:"+ "("+x+","+y+")");
    }
    public void erase() {
        System.out.println("Xoá hình vuông tại:"+ "("+x+","+y+")");
    }
}


public class Main {
    public static void main (String[] args) {
        Shape circle= new Circle(10,10);
        circle.draw();
        circle.moveTo(20,20);
    }
}
