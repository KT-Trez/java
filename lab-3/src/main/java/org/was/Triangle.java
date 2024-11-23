package org.was;

import java.util.Arrays;

public class Triangle extends Shape {
    private final int sideA;
    private final int sideB;
    private final int sideC;

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
