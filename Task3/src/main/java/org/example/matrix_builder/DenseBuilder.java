package org.example.matrix_builder;
import org.example.MatrixBuilder;
import org.example.MatrixInterface;
import org.example.matrix.DenseMatrix;

public class DenseBuilder implements MatrixBuilder{
    public int size;
    public long[][] values;

    public DenseBuilder(int size) {
        this.size = size;
        this.values = new long[size][size];
    }

    @Override
    public void set(int i, int j, long value) {
        values[i][j] = value;
    }

    @Override
    public MatrixInterface get() {
        return new DenseMatrix(values);
    }
}

