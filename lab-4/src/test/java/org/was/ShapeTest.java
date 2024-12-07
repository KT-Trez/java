package org.was;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapeTest {
    @Test
    public void itShouldReturnCorrectColorDescription() {
        // given
        Color color = new Color(100, 150, 200);
        Shape shape = new Shape(color) {
            @Override
            public float getArea() {
                return 0;
            }

            @Override
            public float getPerimeter() {
                return 0;
            }
        };

        // then
        assertEquals("Red: 100 Green: 150 Blue: 200", shape.getColorDescription());
    }

    @Test
    public void itShouldPrintShapeDescription() {
        // given
        Color color = new Color(100, 150, 200);
        Shape shape = new Shape(color) {
            @Override
            public float getArea() {
                return 0;
            }

            @Override
            public float getPerimeter() {
                return 0;
            }
        };

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // when
        shape.print();

        // then
        assertTrue(outContent.toString().contains("I'm a org.was.Shape"));
    }
}