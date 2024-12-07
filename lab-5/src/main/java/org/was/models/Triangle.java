package org.was.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "triangles")
public class Triangle extends Shape {
    @Column(name = "a", nullable = false)
    private int sideA;

    @Column(name = "b", nullable = false)
    private int sideB;

    @Column(name = "c", nullable = false)
    private int sideC;

    public Triangle() {
        super(new Color(0, 0, 0));

        this.sideA = 0;
        this.sideB = 0;
        this.sideC = 0;
    }

    public Triangle(Color color, int sideA, int sideB, int sideC) {
        super(color);

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        float s = (sideA + sideB + sideC) / 2.0f;
        return (float) Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    @JsonProperty("a")
    public double getSideA() {
        return this.sideA;
    }

    @JsonProperty("b")
    public double getSideD() {
        return this.sideB;
    }

    @JsonProperty("c")
    public double getSideC() {
        return this.sideC;
    }
}
