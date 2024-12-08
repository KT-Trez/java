package org.was;

public class Main {
    public static double calculateOrderValue(Product product) {
        return product.quantity * product.price;
    }

    public static void main(String[] args) {
        Product bread = new Product("Chleb", 21, 37);
        Product butter = new Product("Masło", 4, 20);
        Product milk = new Product("Mleko", 9, 11);

        System.out.println("Product: " + bread.name + " Order Value: " + Main.calculateOrderValue(bread));
        System.out.println("Product: " + butter.name + " Order Value: " + Main.calculateOrderValue(butter));
        System.out.println("Product: " + milk.name + " Order Value: " + Main.calculateOrderValue(milk));
    }
}