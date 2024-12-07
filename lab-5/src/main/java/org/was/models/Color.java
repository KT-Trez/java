package org.was.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "red", column = @Column(name = "red", nullable = false)),
        @AttributeOverride(name = "green", column = @Column(name = "green", nullable = false)),
        @AttributeOverride(name = "blue", column = @Column(name = "blue", nullable = false)),
        @AttributeOverride(name = "alpha", column = @Column(name = "alpha", nullable = false)),
})
public record Color(int red, int green, int blue, double alpha) {
    private static final int MAX_ALPHA = 1;
    private static final int MIN_ALPHA = 0;
    private static final int MAX_RANGE = 255;
    private static final int MIN_RANGE = 0;

    public Color {
        this.validateArgs(red, green, blue, alpha);
    }

    public Color(int R, int G, int B) {
        this(R, G, B, 1);
        this.validateArgs(R, G, B, 1);
    }

    private void validateArgs(int R, int G, int B, double alpha) {
        if (R < Color.MIN_RANGE || R > Color.MAX_RANGE) {
            throw new IllegalArgumentException("red should be between " + Color.MIN_RANGE + " and " + Color.MAX_RANGE);
        }

        if (G < Color.MIN_RANGE || G > Color.MAX_RANGE) {
            throw new IllegalArgumentException("green should be between " + Color.MIN_RANGE + " and " + Color.MAX_RANGE);
        }

        if (B < Color.MIN_RANGE || B > Color.MAX_RANGE) {
            throw new IllegalArgumentException("blue should be between " + Color.MIN_RANGE + " and " + Color.MAX_RANGE);
        }

        if (alpha < Color.MIN_ALPHA || alpha > Color.MAX_ALPHA) {
            throw new IllegalArgumentException("alpha should be between " + Color.MIN_ALPHA + " and " + Color.MAX_ALPHA);
        }
    }
}