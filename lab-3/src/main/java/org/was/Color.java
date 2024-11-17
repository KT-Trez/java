package org.was;

public record Color(int R, int G, int B, double alpha) {
    private static final int MAX_ALPHA = 1;
    private static final int MIN_ALPHA = 0;
    private static final int MAX_RANGE = 255;
    private static final int MIN_RANGE = 0;

    public Color {
        this.validateArgs(R, G, B, alpha);
    }

    public Color(int R, int G, int B) {
        int alpha = 1;
        this(R, G, B, alpha);
        this.validateArgs(R, G, B, alpha);
    }

    private void validateArgs(int R, int G, int B, double alpha) {
        if (R < Color.MIN_RANGE || R > Color.MAX_RANGE) {
            throw new IllegalArgumentException("R should be between " + Color.MIN_RANGE + " and " + Color.MIN_RANGE);
        }

        if (G < Color.MIN_RANGE || G > Color.MAX_RANGE) {
            throw new IllegalArgumentException("G should be between " + Color.MIN_RANGE + " and " + Color.MIN_RANGE);
        }

        if (B < Color.MIN_RANGE || B > Color.MAX_RANGE) {
            throw new IllegalArgumentException("B should be between " + Color.MIN_RANGE + " and " + Color.MIN_RANGE);
        }

        if (alpha < Color.MIN_ALPHA || alpha > Color.MAX_ALPHA) {
            throw new IllegalArgumentException("alpha should be between " + Color.MIN_RANGE + " and " + Color.MIN_RANGE);
        }
    }
}