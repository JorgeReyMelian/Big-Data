package org.examples;
import java.util.Random;
import org.example.MatrixMul;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MatrixMultiplicationBenchmarking {

    @State(Scope.Thread)
    public static class Builder{
        private final int n = 1024;
        private final double[][] a = new double[n][n];
        private final double[][] b = new double[n][n];

        @Setup
        public void setup() {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = random.nextDouble();
                    b[i][j] = random.nextDouble();
                }
            }
        }

    }

    @Benchmark
    @Fork(value=3)
    @Measurement(iterations = 3)
    @Warmup(iterations = 2)
    public void multiplication(Builder builder){
        new MatrixMul().multiply(builder.a, builder.b);
    }
}

