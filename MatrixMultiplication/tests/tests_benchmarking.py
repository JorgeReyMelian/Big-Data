from matrix_builder import Builder
from src.MatrixMul import MatrixMul
import pytest

def multiplier(builder_instances):
    return MatrixMul().multiply(builder_instances)

@pytest.mark.benchmark
def test_matrix_multiplication(benchmark):
    builder_instances=Builder()
    benchmark.pedantic(multiplier,
                        args = (builder_instances.builder(),)
                       ,rounds=2,warmup_rounds=1,iterations=2)