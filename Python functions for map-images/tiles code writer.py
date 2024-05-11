def generate_tile_code(num_tiles_per_row, num_rows):
    code = ""
    tile_index = 0
    for y in range(num_rows):
        for x in range(num_tiles_per_row):
            tile_x = x * 64
            tile_y = y * 64
            code += f"tile[{tile_index}] = new Tile();\n"
            code += f"tile[{tile_index}].image = ImageIO.read(new File(\"res/tiles/ElevMapTiles64/tile_{tile_y}_{tile_x}.jpg\"));\n\n"
            tile_index += 1
    return code

# Numero di tiles per riga e numero di righe
num_tiles_per_row = 74
num_rows = 33  # 2335 tiles / 64 tiles per riga

# Genera il codice per i tiles
tile_code = generate_tile_code(num_tiles_per_row, num_rows)

# Scrive il codice su un file di testo
output_file = "C:/Users/Donat/IdeaProjects/wizzardsgame/res/tiles/ElevatorTilescode.txt"
with open(output_file, "w") as file:
    file.write(tile_code)

print(f"Il codice è stato scritto su {output_file}")