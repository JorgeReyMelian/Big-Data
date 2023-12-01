package org.example.matrix;

import org.example.MatrixTrans;
import org.example.matrix_builder.DenseBuilder;
import org.example.matrix.Threads;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MatrixTryouts {

    public static void main(String[] args) {
        Threads threads = new Threads();
        int n = 6;
        DenseBuilder matrixA = new DenseBuilder(n);
        DenseBuilder matrixB = new DenseBuilder(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA.set(i, j, random.nextInt(10));
                matrixB.set(i, j, random.nextInt(10));
            }
        }
        DenseMatrix matriz = (DenseMatrix) matrixA.get();
        DenseMatrix matrizB = (DenseMatrix) matrixB.get();
        List<long[][]> listaA = Tiles.createTiles(matriz, matriz.size());
        List<long[][]> listaB = Tiles.createTiles(matrizB, matrizB.size());
        List<long[][]> shiftRow = Tiles.switchTilesInRows(listaA, n);
        List<long[][]> shiftCol = Tiles.shiftTilesInColumns(listaB, n);

        for (long[] row : matriz.getValues()) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        for (long[][] row : shiftRow) {
            for (long[] rw : row){
                System.out.print(Arrays.toString(rw));
            }

        }
        System.out.println();
        System.out.println(shiftRow.size());
    }
}
