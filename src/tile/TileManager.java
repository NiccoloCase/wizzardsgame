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
        tile =new Tile[10];
        mapTileNum= new int [gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("res/maps/world01.txt");
    }
    public void getTileImage() {
        try {
            tile[0]= new Tile();
            tile[0].image= ImageIO.read(new File("res/tiles/grass.png"));

            tile[1]= new Tile();
            tile[1].image= ImageIO.read(new File("res/tiles/wall.png"));
            tile[1].collision=true;

            tile[2]= new Tile();
            tile[2].image= ImageIO.read(new File("res/tiles/water.png"));
            tile[2].collision=true;

            tile[3]= new Tile();
            tile[3].image= ImageIO.read(new File("res/tiles/earth.png"));

            tile[4]= new Tile();
            tile[4].image= ImageIO.read(new File("res/tiles/tree.png"));
            tile[4].collision=true;

            tile[5]= new Tile();
            tile[5].image= ImageIO.read(new File("res/tiles/sand.png"));



        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or display a user-friendly message)
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


    //TODO: Implement class (video#6, video#7 min:12:00)
}
