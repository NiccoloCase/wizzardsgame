from PIL import Image

def calcola_e_salva_matrice_tiles(image_path, tile_size, output_file):
    # Apre l'immagine
    input_image = Image.open(image_path)
    width, height = input_image.size

    # Converte l'immagine in RGB se è RGBA
    if input_image.mode == 'RGBA':
        input_image = input_image.convert('RGB')

    # Calcolo del numero di tiles lungo l'asse x e y
    num_tiles_x = width // tile_size
    num_tiles_y = height // tile_size

    # Inizializzazione del numero di tile
    tile_number = 0

    # Creazione della matrice per associare ad ogni tile un numero
    tile_matrix = []
    for x in range(0, height, tile_size):
        row = []
        for y in range(0, width, tile_size):
            row.append(tile_number)
            tile_number += 1
        tile_matrix.append(row)

    # Salva la matrice dei tiles in un file di testo
    with open(output_file, 'w') as file:
        for row in tile_matrix:
            file.write(' '.join(map(str, row)) + '\n')

# Esempio di utilizzo
input_image_path = "C:/Users/Donat/IdeaProjects/wizzardsgame/res/tiles/2dClassroomMap.png"
tile_size = 32
output_file = "C:/Users/Donat/IdeaProjects/wizzardsgame/res/maps/MapClass.txt"
calcola_e_salva_matrice_tiles(input_image_path, tile_size, output_file)