import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.was.Color;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class ColorTest {
    @Parameter()
    public int R;
    @Parameter(1)
    public int G;
    @Parameter(2)
    public int B;
    @Parameter(3)
    public double alpha;
    @Parameter(4)
    public String exceptionMessage;

    @Parameters(name = "it should throw \"{4}\" for R: {0}, G: {1}, B: {2}, alpha: {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {-1, 1, 1, 0.1, "R should be between 0 and 255"},
                {256, 1, 1, 0.1, "R should be between 0 and 255"},
                {1, -1, 1, 0.1, "G should be between 0 and 255"},
                {1, 256, 1, 0.1, "G should be between 0 and 255"},
                {1, 1, -1, 0.1, "B should be between 0 and 255"},
                {1, 1, 256, 0.1, "B should be between 0 and 255"},
                {1, 1, 1, -1, "alpha should be between 0 and 1"},
                {1, 1, 1, 1.1, "alpha should be between 0 and 1"},
        });
    }

    @Test
    public void itShouldThrowAnExceptionWhenArgumentsAreInvalid() {
        // given
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Color(this.R, this.G, this.B, this.alpha));

        // then
        assertEquals(this.exceptionMessage, exception.getMessage());
    }

    @Test
    public void itShouldCreateNewColor() {
        // given
        Color color = new Color(21, 37, 54, 0.02);

        // then
        assertEquals(color.R(), 21);
        assertEquals(color.G(), 37);
        assertEquals(color.B(), 54);
        assertEquals(color.alpha(), 0.02, 0);
    }

    @Test
    public void itShouldCreateNewColorWithoutAlpha() {
        // given
        Color color = new Color(21, 37, 54);

        // then
        assertEquals(color.R(), 21);
        assertEquals(color.G(), 37);
        assertEquals(color.B(), 54);
        assertEquals(color.alpha(), 0.02, 1);
    }
}