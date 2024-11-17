package org.was;

public abstract class Shape {
    private final Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public String getColorDescription() {
        return "Red: " + this.color.R() + " Green: " + this.color.G() + " Blue: " + this.color.B();
    }

    abstract public float getArea();

    abstract public float getPerimeter();

    public void print() {
        System.out.println("I'm a " + this.getClass().getName());
    }
}
