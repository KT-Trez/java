public class ShapeDescriber {
    public void describe(Shape shape) {
        shape.print();
        System.out.println("Area: " + shape.getArea() + " Perimeter: " + shape.getPerimeter());
    }
}
