package org.was;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Arrays;

@Entity
@Table(name = "triangles")
public class Triangle extends Shape {
    @Column(name = "a", nullable = false)
    private final int sideA;
    @Column(name = "b", nullable = false)
    private final int sideB;
    @Column(name = "c", nullable = false)
    private final int sideC;

    public Triangle() {
        super(new Color(0, 0, 0));
        this.sideA = 0;
        this.sideB = 0;
        this.sideC = 0;
    }

    public Triangle(Color color, int sideA, int sideB, int sideC) {
        super(color);

        int[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);

        if (sides[0] + sides[1] <= sides[2]) {
            throw new IllegalArgumentException("The given sides do not form a valid triangle.");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public float getArea() {
        float s = (sideA + sideB + sideC) / 2.0f;
        return (float) Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public float getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }
}
