package org.was;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main() {
        Logger logger = LoggerFactory.getLogger(Main.class);
        ShapeDescriber describer = new ShapeDescriber(logger);

        Rectangle rectangle = new Rectangle(new Color(255, 239, 0), 21, 37);
        Triangle triangle = new Triangle(new Color(21, 37, 21, 0.37), 4, 5, 6);

        describer.describe(rectangle);
        describer.describe(triangle);
    }
}