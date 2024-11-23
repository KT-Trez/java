package org.was;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.mockito.Mockito.verify;

public class ShapeDescriberTest {
    @Test
    public void describeLogsCorrectInformation() {
        // given
        Logger mockLogger = Mockito.mock(Logger.class);
        Shape mockShape = Mockito.mock(Shape.class);

        Mockito.when(mockShape.getArea()).thenReturn(25f);
        Mockito.when(mockShape.getColorDescription()).thenReturn("Lorem ipsum dolor sit amet");
        Mockito.when(mockShape.getPerimeter()).thenReturn(20f);

        // when
        ShapeDescriber describer = new ShapeDescriber(mockLogger);
        describer.describe(mockShape);

        // then
        verify(mockShape).print();
        verify(mockLogger).info("Area: {} | Color: {} | Perimeter: {}", 25f, "Lorem ipsum dolor sit amet", 20f);
    }
}