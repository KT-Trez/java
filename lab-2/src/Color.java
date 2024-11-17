public record Color(int R, int G, int B, double alpha) {
    private static final int MAX_ALPHA = 1;
    private static final int MIN_ALPHA = 0;
    private static final int MAX_RANGE = 255;
    private static final int MIN_RANGE = 0;

    public Color {
        this.validateArgs(R, G, B, alpha);
    }

    public Color(int r, int g, int b) {
        int alpha = 1;
        this(r, g, b, alpha);
        this.validateArgs(r, g, b, alpha);
    }

    private void validateArgs(int r, int g, int b, double alpha) {
        if (r < Color.MIN_RANGE || r > Color.MAX_RANGE) {
            throw new IllegalArgumentException("R should be between " + Color.MIN_RANGE + " and " + Color.MIN_RANGE);
        }

        if (g < Color.MIN_RANGE || g > Color.MAX_RANGE) {
            throw new IllegalArgumentException("G should be between " + Color.MIN_RANGE + " and " + Color.MIN_RANGE);
        }

        if (b < Color.MIN_RANGE || b > Color.MAX_RANGE) {
            throw new IllegalArgumentException("B should be between " + Color.MIN_RANGE + " and " + Color.MIN_RANGE);
        }

        if (alpha < Color.MIN_ALPHA || alpha > Color.MAX_ALPHA) {
            throw new IllegalArgumentException("alpha should be between " + Color.MIN_RANGE + " and " + Color.MIN_RANGE);
        }
    }
}