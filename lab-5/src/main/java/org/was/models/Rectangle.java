package org.was.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rectangles")
public class Rectangle extends Shape {
    @Column(name = "a", nullable = false)
    private double sideA;

    @Column(name = "b", nullable = false)
    private double sideB;

    public Rectangle() {
        super(new Color(0, 0, 0));

        this.sideA = 0;
        this.sideB = 0;
    }

    public Rectangle(Color color, double height, double width) {
        super(color);

        this.sideA = height;
        this.sideB = width;
    }

    @Override
    public double getArea() {
        return this.sideA * this.sideB;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.sideA + this.sideB);
    }

    @JsonProperty("a")
    public double getSideA() {
        return this.sideA;
    }

    @JsonProperty("b")
    public double getSideD() {
        return this.sideB;
    }
}
