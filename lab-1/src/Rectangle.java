public class Rectangle extends Shape {
    private final int height;
    private final int width;

    public  Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public float getArea() {
        return this.height * this.width;
    }

    @Override
    public float getPerimeter() {
        return 2 * this.height + 2 * this.width;
    }
}
