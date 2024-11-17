package org.was;

import org.slf4j.Logger;


public class ShapeDescriber {
    private final Logger logger;

    public ShapeDescriber(Logger logger) {
        this.logger = logger;
    }

    public void describe(Shape shape) {
        shape.print();
        this.logger.info("Area: {} | Color: {} | Perimeter: {}", shape.getArea(), shape.getColorDescription(), shape.getPerimeter());
    }
}
