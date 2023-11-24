package org.example.matrix_builder;

import org.example.MatrixInterface;
import org.example.matrix.*;

public class CoordinateBuilder extends SparseBuilder{
    public CoordinateBuilder(int size) {
        super(size);
    }

    @Override
    public MatrixInterface get() {

        return new CoordinateMatrix(size, coordinates);
    }
}
