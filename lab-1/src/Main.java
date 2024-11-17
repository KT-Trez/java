public class Main {
    public static void main(String[] args) {
        ShapeDescriber describer = new ShapeDescriber();

        Rectangle rectangle = new Rectangle(21, 37);
        Triangle triangle = new Triangle(4, 5, 6);

        describer.describe(rectangle);
        describer.describe(triangle);
    }
}