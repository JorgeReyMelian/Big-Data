package org.example.matrix;

import org.example.MatrixMul;
import org.example.MatrixTrans;
import org.example.matrix_builder.DenseBuilder;

import java.util.List;
import java.util.Random;

public class MatrixTryouts {
    public static void main(String[] args) {
        int n = 3;
        DenseBuilder matrixA = new DenseBuilder(n);
        DenseBuilder matrixB = new DenseBuilder(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA.set(i, j, random.nextInt(10));
                matrixB.set(i, j, random.nextInt(10));
            }
        }
        CompressedMatrix a = new MatrixTrans().toCRS((DenseMatrix) matrixA.get());
        CompressedMatrix b = new MatrixTrans().toCCS((DenseMatrix) matrixB.get());
        double startTime = System.nanoTime();
        SparseMatrix result = new MatrixMul().multiply(a, b);
        double endtime = System.nanoTime();
        double time = (endtime - startTime)/1000000000;
        System.out.println(time);

    }
}
