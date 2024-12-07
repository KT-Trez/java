package org.was;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rectangles")
public class Rectangle extends Shape {
    @Column(name = "a", nullable = false)
    private final int height;
    @Column(name = "b", nullable = false)
    private final int width;

    public Rectangle() {
        super(new Color(0, 0, 0));
        this.height = 0;
        this.width = 0;
    }

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
