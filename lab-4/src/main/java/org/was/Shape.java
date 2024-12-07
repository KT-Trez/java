package org.was;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Shape {
    @Id
    @GeneratedValue
    public Long id;

    // more info: https://www.baeldung.com/jpa-embedded-embeddable
    @Embedded
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public String getColorDescription() {
        return "Red: " + this.color.R() + " Green: " + this.color.G() + " Blue: " + this.color.B();
    }

    abstract public float getArea();

    abstract public float getPerimeter();

    public void print() {
        System.out.println("I'm a " + this.getClass().getName());
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
