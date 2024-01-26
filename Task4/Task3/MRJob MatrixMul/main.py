from MatrixGenerator import MatrixGenerator
filename_a = 'matrix_Adata.txt'
filename_b = "matrix_Bdata.txt"
matrix_a = MatrixGenerator(rows=5, cols=5)
matrix_b = MatrixGenerator(rows=5, cols=5)
fileA = matrix_a.save_to_txt(filename_a, start_letter="a")
fileB = matrix_b.save_to_txt(filename_b, start_letter="b")