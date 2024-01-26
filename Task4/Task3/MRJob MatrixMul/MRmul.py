from mrjob.job import MRJob
from mrjob.step import MRStep

class MRMapper(MRJob):

    def mapper(self, _, line):
        values = line.strip().split(',')
        letter, row, col, value = values
        if letter == 'a':
            for k in range(self.options.matrix_b_cols):
                yield (int(row), k), ('a', int(col), int(value))
        elif letter == 'b':
            for i in range(self.options.matrix_a_rows):
                yield (i, int(col)), ('b', int(row), int(value))

    def reducer(self, key, values):
        result = 0
        a_values = {}
        b_values = {}
        for letter, index, value in values:
            if letter == 'a':
                a_values[index] = value
            elif letter == 'b':
                b_values[index] = value
        for index in a_values:
            if index in b_values:
                result += a_values[index] * b_values[index]
        yield key, result

    def mapper_format_output(self, key, value):
        yield key, value

    def reducer_sum_values(self, key, values):
        yield key, sum(values)

    def steps(self):
        return [
            MRStep(mapper=self.mapper, reducer=self.reducer),
            MRStep(mapper=self.mapper_format_output, reducer=self.reducer_sum_values)
        ]
