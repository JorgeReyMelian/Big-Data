package org.example.matrix;

import org.example.MatrixInterface;
import java.util.List;

public class SparseMatrix implements MatrixInterface {
    protected final int size;
    protected final List<Coordinate> coordinates;

    public SparseMatrix(int size, List<Coordinate> coordinates) {
        this.size = size;
        this.coordinates = coordinates;
    }


    @Override
    public int size() {

        return size;
    }

    public List<Coordinate> getCoordinates(){
        return coordinates;
    }

    @Override
    public long get(int i, int j) {
        for (Coordinate coordinate : coordinates) {
            if (coordinate.getI() == i && coordinate.getJ() == j) {
                return coordinate.getValue();
            }
        }
        return 0;
    }
}
