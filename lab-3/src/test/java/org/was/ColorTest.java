package org.was;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColorTest {
    @ParameterizedTest
    @CsvSource({
            "-1, 1, 1, 0.1, R should be between 0 and 255",
            "256, 1, 1, 0.1, R should be between 0 and 255",
            "1, -1, 1, 0.1, G should be between 0 and 255",
            "1, 256, 1, 0.1, G should be between 0 and 255",
            "1, 1, -1, 0.1, B should be between 0 and 255",
            "1, 1, 256, 0.1, B should be between 0 and 255",
            "1, 1, 1, -1, alpha should be between 0 and 1",
            "1, 1, 1, 1.1, alpha should be between 0 and 1"
    })

    public void itShouldThrowExceptionForInvalidColorValues(int R, int G, int B, double alpha, String expectedMessage) {
        // when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Color(R, G, B, alpha));

        // then
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void itShouldCreateColorWithValidParameters() {
        // when
        Color color = new Color(21, 37, 2, 0.37);

        // then
        assertEquals(color.R(), 21);
        assertEquals(color.G(), 37);
        assertEquals(color.B(), 2);
        assertEquals(color.alpha(), 0.37, 0);
    }

    @Test
    public void itShouldCreateColorWithValidParametersAndWithoutAlpha() {
        // when
        Color color = new Color(21, 37, 2);

        // then
        assertEquals(color.R(), 21);
        assertEquals(color.G(), 37);
        assertEquals(color.B(), 2);
        assertEquals(color.alpha(), 0.37, 1);
    }
}