package com.acabes.assignments.java.shapes;

abstract class Shapes {
    abstract void draw();
    abstract void area();
}

class Rectangle extends Shapes {
    int x;
    int y;
    Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void draw() {
        System.out.println("This is a rectangle");
    }
    void area(){
        System.out.println("Area of rectangle: " + (x*y));
    }
}

class Circle extends Shapes {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    void draw() {
        System.out.println("This is a circle");
    }
    void area(){
        System.out.println("Area of circle: " + (3.14*radius*radius));
    }
}

public class ShapesMain {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(5,10);
        Circle circle = new Circle(10);

        rec.draw();
        rec.area();
        circle.draw();
        circle.area();
    }
}
