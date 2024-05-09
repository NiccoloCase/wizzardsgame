package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public TileManager(GamePanel gp){
        this.gp=gp;
        tile =new Tile[2500];
        mapTileNum= new int [gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("res/maps/ElevatorMap_transposed.txt");
    }
    public void getTileImage() {
        int tileIndex = 0;
        for (int y = 0; y < 33; y++) {
            for (int x = 0; x < 74; x++) { // 77 righe e 32 colonne
                try {
                    tile[tileIndex] = new Tile();
                    tile[tileIndex].image = ImageIO.read(new File(String.format("res/tiles/ElevMapTiles64/tile_%d_%d.jpg", y * 64, x * 64)));
                    if (y==32 || x== 73 || y==0 || x==0){
                        tile[tileIndex].collision=true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();// Handle the exception (e.g., log an error message or display a user-friendly message)
                }
                tileIndex++;
            }
        }
    }
    public void loadMap(String filepath){     //metodo che serve per caricare mappa da file testo
        try {
            File file = new File(filepath);   //avrei dovuto usare  InputStream is = getClass().getResourceAsStream("res/maps/world00.txt"); ma non funziona
            BufferedReader br = new BufferedReader(new FileReader(file));

            int col =0;
            int row =0;

            while(col<gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);//create number from string
                    mapTileNum[col][row] =num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    row++;
                    col=0;
                }
            }
            br.close();

        }catch (Exception e){

        }
    }
    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;


        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol*gp.tileSize; //position on the map...but we need to know also the position on the screen
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX-gp.player.worldX+gp.player.screenX;//position on the screen
            int screenY = worldY-gp.player.worldY+gp.player.screenY;

            if (worldX +gp.tileSize> gp.player.worldX-gp.player.screenX &&  //con questo if non disegno tutta la mappa ma solo quella visibile
                worldX -gp.tileSize < gp.player.worldX+gp.player.screenX &&
                worldY +gp.tileSize> gp.player.worldY-gp.player.screenY &&
                worldY -gp.tileSize < gp.player.worldY+gp.player.screenY){

                g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize, gp.tileSize,null);
            }

            worldCol++;
            if(worldCol == gp.maxWorldCol){
                worldRow++;
                worldCol=0;
            }
        }


    }



}
