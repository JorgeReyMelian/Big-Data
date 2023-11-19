#include "Builder.h"
#include <iostream>
#include <sys/time.h>

int main() {
    MatrixMul multiply;
    MatrixMul::Builder matrices;
    Benchmarking benchmark;
    benchmark.benchmark(multiply,matrices,3,2);

    return 0;
}
