package org.example.matrix;

import org.example.MatrixInterface;
import org.example.matrix_builder.SparseBuilder;

import java.util.List;

public class CoordinateMatrix extends SparseMatrix{

    public CoordinateMatrix(int size, List<Coordinate> coordinates) {
        super(size, coordinates);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public long get(int i, int j) {
        return coordinates.stream()
                .filter(c->c.i() == i & c.j() == j)
                .findFirst()
                .map(Coordinate::value)
                .orElse(0L);
    }

}
