import numpy as np

class MatrixGenerator:
    def __init__(self, rows, cols):
        self.rows = rows
        self.cols = cols
        self.matrix = self.generate_matrix()

    def generate_matrix(self):
        return np.random.randint(1, 100, size=(self.rows, self.cols))

    def save_to_txt(self, filename, start_letter):
        with open(filename, 'w') as file:
            for i in range(self.rows):
                for j in range(self.cols):
                    file.write(f'{start_letter},{i},{j},{self.matrix[i, j]}\n')

        print(f"Matrix saved to {filename}")
