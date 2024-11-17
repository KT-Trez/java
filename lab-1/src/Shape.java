public abstract class Shape {
    abstract public float getArea();

    abstract public float getPerimeter();

    public void print() {
        System.out.println("I'm a " + this.getClass().getName());
    }
}
