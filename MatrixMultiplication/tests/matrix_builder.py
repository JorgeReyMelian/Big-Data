from src.MatrixMul import MatrixMul
import random

class Builder:

    def builder(self):
        n=1024
        A = [[random.random() for _ in range(n)] for _ in range(n)]
        B = [[random.random() for _ in range(n)] for _ in range(n)]
        return A, B
