package org.was;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    public void itShouldCreateTriangleWithValidSides() throws NoSuchFieldException, IllegalAccessException {
        // when
        Color color = new Color(0, 0, 0);
        Triangle triangle = new Triangle(color, 3, 4, 5);

        Field sideAField = Triangle.class.getDeclaredField("sideA");
        Field sideBField = Triangle.class.getDeclaredField("sideB");
        Field sideCField = Triangle.class.getDeclaredField("sideC");

        sideAField.setAccessible(true);
        sideBField.setAccessible(true);
        sideCField.setAccessible(true);

        // then
        assertEquals(3, sideAField.getInt(triangle));
        assertEquals(4, sideBField.getInt(triangle));
        assertEquals(5, sideCField.getInt(triangle));
    }

    @Test
    public void itShouldThrowExceptionForInvalidTriangle() {
        // given
        Color color = new Color(0, 0, 0);

        // then
        assertThrows(IllegalArgumentException.class, () -> new Triangle(color, 1, 2, 3));
    }

    @Test
    public void itShouldThrowExceptionForInvalidTriangleWhenSideAreInDescendingOrder() {
        // given
        Color color = new Color(0, 0, 0);

        // then
        assertThrows(IllegalArgumentException.class, () -> new Triangle(color, 3, 2, 1));
    }

    @Test
    public void itShouldCalculateAreaCorrectly() {
        // given
        Color color = new Color(0, 0, 0);
        Triangle triangle = new Triangle(color, 3, 4, 5);

        // then
        assertEquals(6, triangle.getArea(), 0);
    }

    @Test
    public void itShouldCalculatePerimeterCorrectly() {
        // given
        Color color = new Color(0, 0, 0);
        Triangle triangle = new Triangle(color, 3, 4, 5);

        // then
        assertEquals(12, triangle.getPerimeter(), 0);
    }
}