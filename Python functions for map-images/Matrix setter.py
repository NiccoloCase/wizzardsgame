# Definizione delle dimensioni originali dell'immagine
original_width = 1280
original_height = 1184

# Definizione delle dimensioni dei tiles
tile_size = 32

# Calcolo del numero di tiles lungo l'asse x e y
num_tiles_x = original_width // tile_size
num_tiles_y = original_height // tile_size

# Creazione della matrice per ridisegnare l'immagine originale
image_matrix = []
for y in range(original_height):
    row = []
    for x in range(original_width):
        tile_x = (x * num_tiles_x) // original_width
        tile_y = (y * num_tiles_y) // original_height
        tile_number = tile_y * num_tiles_x + tile_x
        row.append(tile_number)
    image_matrix.append(row)

# Stampa della matrice per ridisegnare l'immagine originale
for row in image_matrix:
    print(row)