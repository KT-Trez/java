package org.was;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
    @Test
    public void itShouldCreateRectangleWithValidDimensions() throws NoSuchFieldException, IllegalAccessException {
        // when
        Color color = new Color(0, 0, 0);
        Rectangle rectangle = new Rectangle(color, 4, 5);

        Field heightField = Rectangle.class.getDeclaredField("height");
        Field widthField = Rectangle.class.getDeclaredField("width");

        heightField.setAccessible(true);
        widthField.setAccessible(true);

        // then
        assertEquals(4, heightField.getInt(rectangle));
        assertEquals(5, widthField.getInt(rectangle));
    }

    @Test
    public void itShouldCalculateAreaCorrectly() {
        // given
        Color color = new Color(0, 0, 0);
        Rectangle rectangle = new Rectangle(color, 4, 5);

        // then
        assertEquals(20, rectangle.getArea(), 0);
    }

    @Test
    public void itShouldCalculatePerimeterCorrectly() {
        // given
        Color color = new Color(0, 0, 0);
        Rectangle rectangle = new Rectangle(color, 4, 5);

        // then
        assertEquals(18, rectangle.getPerimeter(), 0);
    }
}