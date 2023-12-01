package org.example;
import org.example.matrix.*;
import org.example.matrix_builder.*;

import java.util.ArrayList;
import java.util.List;

public class MatrixTrans {

    public CoordinateMatrix transform(DenseMatrix matrix) {
        CoordinateBuilder builder = new CoordinateBuilder(matrix.size());
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                if (matrix.get(i,j) == 0) continue;
                builder.set(new Coordinate(i,j, matrix.get(i,j)));
            }
        }
        return (CoordinateMatrix) builder.get();
    }

    public DenseMatrix transform(CoordinateMatrix matrix) {
        DenseBuilder builder = new DenseBuilder(matrix.size());
        for (Coordinate coordinate : matrix.getCoordinates()) {
            builder.set(coordinate.i(),coordinate.j(),coordinate.value());
        }
        return (DenseMatrix) builder.get();
    }

    public static DenseMatrix transpose(DenseMatrix matrix) {
        DenseBuilder builder = new DenseBuilder(matrix.size());
        for (int j = 0; j < matrix.size(); j++){
            for (int i = 0; i < matrix.size(); i++){
                builder.set(j, i, matrix.get(i, j));
            }
        }
        return (DenseMatrix) builder.get();
    }

    public CompressedMatrix toCRS(DenseMatrix matrix){
        CoordinateMatrix coor = new MatrixTrans().transform(matrix);
        CompressedMatrix a = new CompressedMatrix(coor.size(), coor.getCoordinates());
        return a;
    }
    public CompressedMatrix toCCS(DenseMatrix matrix){
        DenseMatrix denseTR = transpose(matrix);
        CoordinateMatrix coor = new MatrixTrans().transform(denseTR);
        CompressedMatrix a = new CompressedMatrix(coor.size(), coor.getCoordinates());
        return a;
    }
}
