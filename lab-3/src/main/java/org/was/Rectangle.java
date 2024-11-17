package org.was;

public class Rectangle extends Shape {
    private final int height;
    private final int width;

    public Rectangle(Color color, int height, int width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    @Override
    public float getArea() {
        return this.height * this.width;
    }

    @Override
    public float getPerimeter() {
        return 2 * this.height + 2 * this.width;
    }
}
