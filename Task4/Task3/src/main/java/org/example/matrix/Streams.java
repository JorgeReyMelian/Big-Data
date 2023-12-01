package org.example.matrix;
import java.util.Random;
import java.util.stream.IntStream;

public class Streams {
    public static void main(String[] args){
        int n = 6000;
        Random random = new Random();
        long[][] a = new long[n][n];
        long[][] b = new long[n][n];
        long[][] c = new long[n][n];

        for (int i=0; i < n; i++){
            for (int j=0; j < n; j++){
                a[i][j] = random.nextInt(10);
                b[i][j] = random.nextInt(10);
                c[i][j] = 0;
            }
        }

        long start = System.currentTimeMillis();
        IntStream.range(0, n).parallel().forEach(i ->{
            for (int k=0; k < n; k++){
                for (int j=0; j < n; j++){
                    c[i][j] = a[i][k] * b[k][j];
                }
            }
        });
        long stop = System.currentTimeMillis();
        System.out.println((stop-start) * 1e-3);
    }

}
