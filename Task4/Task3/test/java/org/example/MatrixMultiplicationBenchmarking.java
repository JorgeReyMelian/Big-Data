package org.example;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.example.matrix_builder.DenseBuilder;
import org.openjdk.jmh.annotations.*;
import org.example.matrix.*;


@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)

public class MatrixMultiplicationBenchmarking {
    @State(Scope.Thread)
    public static class Builder {
        private final int n = 3;
        private final DenseBuilder matrixA = new DenseBuilder(n);
        private final DenseBuilder matrixB = new DenseBuilder(n);

        @Setup
        public void setup() {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrixA.set(i, j, random.nextLong());
                    matrixB.set(i, j, random.nextLong());
                }
            }

        }
        public CompressedMatrix a = new MatrixTrans().toCRS((DenseMatrix) matrixA.get());
        public CompressedMatrix b = new MatrixTrans().toCCS((DenseMatrix) matrixB.get());

    }

    @Benchmark
    @Fork(value=3)
    @Measurement(iterations = 3)
    @Warmup(iterations = 2)
    public void multiplication(Builder builder){
        new MatrixMul().multiply(builder.a, builder.b);
    }
}
