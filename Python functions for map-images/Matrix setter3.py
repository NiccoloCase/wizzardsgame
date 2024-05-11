from PIL import Image
def calcola_e_salva_matrice_tiles(image_path, tile_size, output_file, target_rows=74, target_cols=33):
    # Apre l'immagine
    input_image = Image.open(image_path)
    width, height = input_image.size

    # Converte l'immagine in RGB se è RGBA
    if input_image.mode == 'RGBA':
        input_image = input_image.convert('RGB')

    # Calcolo del numero di tiles lungo l'asse x e y
    num_tiles_x = width // tile_size
    num_tiles_y = height // tile_size

    # Calcolo del numero di righe e colonne da aggiungere per raggiungere le dimensioni target
    extra_rows = target_rows - num_tiles_y
    extra_cols = target_cols - num_tiles_x

    # Inizializzazione della matrice con zeri
    tile_matrix = [[0] * target_cols for _ in range(target_rows)]

    # Inizializzazione del numero di tile
    tile_number = 0

    # Riempimento della matrice con i numeri dei tile
    for y in range(0, height, tile_size):
        for x in range(0, width, tile_size):
            if y // tile_size < num_tiles_y and x // tile_size < num_tiles_x:
                tile_matrix[y // tile_size][x // tile_size] = tile_number
                tile_number += 1

    # Salva la matrice dei tiles in un file di testo
    with open(output_file, 'w') as file:
        for row in tile_matrix:
            file.write(' '.join(map(str, row)) + '\n')

# Esempio di utilizzo
input_image_path = "C:/Users/Donat/IdeaProjects/wizzardsgame/res/tiles/elevator_Map_1.png"
tile_size = 64
output_file = "C:/Users/Donat/IdeaProjects/wizzardsgame/res/maps/ElevatorMap.txt"
calcola_e_salva_matrice_tiles(input_image_path, tile_size, output_file)