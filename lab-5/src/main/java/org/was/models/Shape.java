package org.was.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Triangle.class, name = "triangle"),
})
public abstract class Shape {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Color color;

    public Shape() {
        this.color = new Color(0, 0, 0);
    }

    public Shape(Color color) {
        this.color = color;
    }

    @JsonIgnore
    abstract public double getArea();

    @JsonIgnore
    public String getColorDescription() {
        return "Red: " + this.color.red() + " Green: " + this.color.green() + " Blue: " + this.color.blue();
    }

    @JsonIgnore
    abstract public double getPerimeter();

    @JsonProperty("color")
    public Color getColor() {
        return this.color;
    }
}
