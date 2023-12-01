package org.example.matrix_builder;

import org.example.MatrixBuilder;
import org.example.MatrixInterface;
import org.example.matrix.Coordinate;
import org.example.matrix.SparseMatrix;

import java.util.ArrayList;
import java.util.List;

public class SparseBuilder implements MatrixBuilder {
    protected final int size;
    protected final List<Coordinate> coordinates;
    protected final int rows;
    protected final int columns;

    public SparseBuilder(int size) {
        this.size = size;
        this.coordinates = new ArrayList<>();
        this.rows = size;
        this.columns = size;
    }

    @Override
    public void set(int i, int j, long value) {
        set(new Coordinate(i,j,value));
    }

    @Override
    public MatrixInterface get() {
        return new SparseMatrix(size, coordinates);
    }

    public void set(Coordinate coordinate) {
        coordinates.add(coordinate);
    }

    /*public List<Coordinate> toMatrix() {
        int n = coordinates.size();
        long[][] result = new long[n][n];
        for (Coordinate coordinate : coordinates) {
            int i = coordinate.getI();
            int j = coordinate.getJ();
            result[i][j] = coordinate.getValue();
            }
        return coordinates;
    }*/
}
