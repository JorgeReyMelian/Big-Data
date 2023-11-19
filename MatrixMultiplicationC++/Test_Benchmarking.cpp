#include "Builder.h"
#include <vector>
#include <cstdlib>
#include <iostream>
#include <algorithm>
#include <numeric>
#include <sys/time.h>


void::Benchmarking::benchmark(MatrixMul multiplier,MatrixMul::Builder matrices,int iter,int rounds) {
    
    std::vector<double> times;
    double exec_time;

    for (int r = 0; r < rounds; r++) {
        for (int i = 0; i < iterations; i++) {
            
            struct timeval initial, end;
            gettimeofday(&initial,NULL);
            multiplier.multiply(matrices);
            gettimeofday(&end,NULL);
            exec_time = (stop.tv_sec - start.tv_sec) * 1000.0 + (stop.tv_usec - start.tv_usec) / 1000.0;
            times.insert(times.end(), exec_time);
        }
    }
    auto min = std::min_element(times.begin(), times.end());
    auto max = std::max_element(times.begin(), times.end());

    double avg = std::accumulate(times.begin(), times.end(), 0.0) / times.size();

    printf("min: %0.6f\n",*min);
    printf("max:%0.6f\n",*max);
    printf("average: %0.6f\n",avg);

};
