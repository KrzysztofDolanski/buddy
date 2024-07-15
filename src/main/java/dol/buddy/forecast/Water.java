package dol.buddy.forecast;

public enum Water {

    NO_RAIN(0), RAIN(1), HEAVY_RAIN(2), FLOOD(3);

    final int range;

    Water(int range) {
        this.range = range;
    }
}
