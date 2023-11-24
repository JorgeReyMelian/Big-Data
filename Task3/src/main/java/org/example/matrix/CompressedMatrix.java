package org.example.matrix;

import java.util.List;

public class CompressedMatrix extends SparseMatrix {
    public final long[] values;
    public final int[] colIdx;
    public final int[] rowPtr;

    public CompressedMatrix(int size, List<Coordinate> coordinates) {
        super(size, coordinates);
        this.values = new long[coordinates.size()];
        this.colIdx = new int[coordinates.size()];
        this.rowPtr = new int[size + 1];

        int currentIndex = 0;
        int currentRow = -1;

        for (Coordinate coordinate : coordinates) {
            while (coordinate.getI() > currentRow) {
                rowPtr[currentRow + 1] = currentIndex;
                currentRow++;
            }
            if (coordinate.getValue() != 0) {
                values[currentIndex] = coordinate.getValue();
                colIdx[currentIndex] = coordinate.getJ();
                currentIndex++;
            }
        }
        while (currentRow < size) {
            rowPtr[currentRow + 1] = currentIndex;
            currentRow++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public long get(int i, int j) {
        for (int k = rowPtr[i]; k < rowPtr[i + 1]; k++) {
            if (colIdx[k] == j) {
                return (long) values[k];
            }
        }
        return 0;
    }
    public long[] getvalues(){
        return values;
    }
}
