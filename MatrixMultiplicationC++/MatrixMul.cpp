#include <vector>
#include "Builder.h"
#include <cstdlib>
#include <iostream>


MatrixMul::Builder::builder() {
    n = 2048;
    a = std::vector<std::vector<double>>(n,std::vector<double>(n));
    b = std::vector<std::vector<double>>(n,std::vector<double>(n));
    c = std::vector<std::vector<double>>(n,std::vector<double>(n));

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {

            a[i][j] = (double)rand();
            b[i][j] = (double)rand();
            c[i][j] = 0;
        }
    }
}

std::vector<std::vector<double>> MatrixMul::multiply(Builder builder) {
    int n = builder.a.size();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                builder.c[i][j] += builder.a[i][k] * builder.b[k][j];
            }
        }
    }
    return builder.c;
}
