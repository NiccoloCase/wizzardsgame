from PIL import Image
import os

def suddividi_in_tiles(image_path, output_folder, tile_size):
    # Apre l'immagine
    input_image = Image.open(image_path)
    width, height = input_image.size

    # Converte l'immagine in RGB se è RGBA
    if input_image.mode == 'RGBA':
        input_image = input_image.convert('RGB')

    # Crea la cartella di output se non esiste
    if not os.path.exists(output_folder):
        os.makedirs(output_folder)

    # Suddivide l'immagine in tiles e le salva nella cartella di output
    for y in range(0, height, tile_size):
        for x in range(0, width, tile_size):
            box = (x, y, x + tile_size, y + tile_size)
            tile = input_image.crop(box)
            tile.save(os.path.join(output_folder, f"tile_{x}_{y}.jpg"))

# Esempio di utilizzo
input_image_path = "C:/Users/Donat/IdeaProjects/wizzardsgame/res/tiles/elevator_Map_1.png"
output_folder = "C:/Users/Donat/IdeaProjects/wizzardsgame/res/tiles/ElevMapTiles64"
tile_size = 64
suddividi_in_tiles(input_image_path, output_folder, tile_size)