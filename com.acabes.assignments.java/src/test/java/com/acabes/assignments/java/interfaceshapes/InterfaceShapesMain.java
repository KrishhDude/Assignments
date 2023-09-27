package com.acabes.assignments.java.interfaceshapes;

interface IShapes {
    abstract void drawShape();
    abstract void areaCalc();
}

class IRectangle implements IShapes {
    int x;
    int y;
    IRectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void drawShape() {
        System.out.println("This is a rectangle");
    }

    @Override
    public void areaCalc() {
        System.out.println("Area of rectangle: " + (x*y));
    }
}

class ICircle implements IShapes {
    int radius;

    ICircle(int radius) {
        this.radius = radius;
    }

    @Override
    public void drawShape() {
        System.out.println("This is a circle");
    }

    @Override
    public void areaCalc() {
        System.out.println("Area of circle: " + (3.14*radius*radius));
    }
}

public class InterfaceShapesMain {
    public static void main(String[] args) {
        IRectangle rec = new IRectangle(5,10);
        ICircle circle = new ICircle(10);

        rec.drawShape();
        rec.areaCalc();
        circle.drawShape();
        circle.areaCalc();
    }
}
