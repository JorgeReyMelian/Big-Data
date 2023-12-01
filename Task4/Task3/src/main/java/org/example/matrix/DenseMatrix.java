package org.example.matrix;

import org.example.MatrixInterface;
import org.example.matrix_builder.DenseBuilder;
import java.util.Random;

public class DenseMatrix implements MatrixInterface {
    private final long[][] values;

    public DenseMatrix(long[][] values) {
        this.values = values;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public long get(int i, int j) {
        return values[i][j];
    }

    public long[][] getValues() {
        return values;
    }
}

