package org.example.matrix;

public record Coordinate(int i, int j, long value) {
    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public long getValue() {
        return value;
    }
}
