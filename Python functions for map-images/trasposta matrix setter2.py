from PIL import Image
def create_matrix(num_rows, num_cols, step):
    matrix = []
    for col in range(num_cols):
        column_values = [col + (row * num_cols) for row in range(num_rows)]
        matrix.append(column_values)
    return matrix

def write_matrix_to_file(matrix, filename):
    with open(filename, 'w') as file:
        for row in matrix:
            file.write(' '.join(map(str, row)) + '\n')

num_rows = 33
num_cols = 74
step = 33

matrix = create_matrix(num_rows, num_cols, step)
write_matrix_to_file(matrix, "C:/Users/Donat/IdeaProjects/wizzardsgame/res/maps/ElevatorMap_transposed.txt")

# Esempio di utilizzo

