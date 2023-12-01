package org.example.matrix_builder;
import org.example.matrix.*;
import org.example.MatrixInterface;
import org.example.matrix.CompressedMatrix;

import java.util.List;

public class CompressedBuilder extends SparseBuilder{
    public List<Coordinate> coordinates;
    public CompressedBuilder(int size) {
        super(size);
        this.coordinates = coordinates;
    }

    @Override
    public MatrixInterface get() {
        return new CompressedMatrix(size, coordinates);
    }
}
