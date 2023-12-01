package org.example.matrix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Threads {
    ExecutorService executorService;
    public DenseMatrix multiply(DenseMatrix a, DenseMatrix b){
        executorService = Executors.newFixedThreadPool(16);
        return new DenseMatrix(multiply(a.getValues(), b.getValues()));
    }

    private long[][] multiply(long[][] aVal, long[][] bVal){
        int size = aVal.length;
        long[][] c = new long[size][size];
        for (int i = 0; i < size; i++) submit(aVal, bVal, size, c, i);
        try{
            executorService.shutdown();
            executorService.awaitTermination(1000, TimeUnit.SECONDS);
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        return c;
    }

    public void submit(long[][] a, long[][] b, int size, long[][] c, int i){
        executorService.submit(() ->{
            for (int k = 0; k < size; k++)
                for (int j = 0; j < size; j++)
                    c[i][j] += a[i][k] * b[k][j];
        });
    }

}
