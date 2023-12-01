package org.example;
import org.example.matrix.*;
import org.example.matrix_builder.*;

import java.util.List;

public class MatrixMul {
    public SparseMatrix multiply(CompressedMatrix a, CompressedMatrix b){
        SparseBuilder builder = new SparseBuilder(a.size());
        for(int i = 0; i <a.size(); i++){
            for(int j = 0; j < b.size(); j++){
                int ii = a.rowPtr[i];
                int iEnd = a.rowPtr[i+1];
                int jj = b.rowPtr[j];
                int jEnd = b.rowPtr[j+1];
                long s = 0;
                while (ii < iEnd && jj < jEnd){
                    int aa = a.colIdx[ii];
                    int bb = b.colIdx[jj];
                    if (aa == bb){
                        s += a.values[ii] * b.values[jj];
                        ii++;
                        jj++;
                    }
                    else if (aa < bb) ii++;
                    else jj++;
                }
                if (s != 0) builder.set(i, j, s);
            }
        }
        return (SparseMatrix) builder.get();
    }
    public DenseMatrix denseMul(DenseMatrix a, DenseMatrix b) {
        int n = a.size();
        long[][] valuesc = new long[n][n];
        long[][] valuesa = a.getValues();
        long[][] valuesb = b.getValues();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    valuesc[i][j] += valuesa[i][k] * valuesb[k][j];
                }
            }
        }
        return new DenseMatrix(valuesc);
    }
}

