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

                    //BORDI MAPPA
                    if (y==32 || x== 73 || y==0 || x==0){
                        tile[tileIndex].collision=true;
                    }
                    //LINEE ORIZZONTALI PIANI
                    if (x==9 && (y!=28 )) {
                            tile[tileIndex].collision=true;
                    }
                    if (x==12 && (y!= 8 )) {
                        tile[tileIndex].collision=true;
                    }
                    if (x==21 && (y!= 29 )) {
                        tile[tileIndex].collision=true;
                    }
                    if (x==24 && (y!= 6 && y!= 7 )) {
                        tile[tileIndex].collision=true;
                    }
                    if (x==33 && (y!= 24 )) {
                        tile[tileIndex].collision=true;
                    }
                    if (x==36 && (y!= 5 && y!= 6)) {
                        tile[tileIndex].collision=true;
                    }
                    if (x==45 && (y!= 29 && y!= 30 )) {
                        tile[tileIndex].collision=true;
                    }
                    if (x==48 && (y!= 5 && y!= 6 )) {
                        tile[tileIndex].collision=true;
                    }
                    if (x==58 && (y!= 25 && y!= 26 )) {
                        tile[tileIndex].collision=true;
                    }
                    if (x==61 && (y!= 6  )) {
                        tile[tileIndex].collision=true;
                    }
                    if (x==70 && ( y!=28 )) {
                        tile[tileIndex].collision=true;
                    }

                    //MURA VERTICALI STANZE
                    if (y==23 && x<9 && x!=4) {
                        tile[tileIndex].collision=true;
                    }
                    if (y==25 && x >12 && x<21 && (x!=15)) {
                        tile[tileIndex].collision=true;
                    }
                    if (y==21 && x >24 && x<33 && (x!=27)) {
                        tile[tileIndex].collision=true;
                    }
                    if (y==22 && x >36 && x<46 && (x!=42)) {
                        tile[tileIndex].collision=true;
                    }
                    if (y==15 && x >48 && x<58 && (x!=54)) {
                        tile[tileIndex].collision=true;
                    }
                    if (y==23 && x >61 && x<70 && (x!=66)) {
                        tile[tileIndex].collision=true;
                    }

                    //STANZA 0
                    if( x==1 && y>23){
                        tile[tileIndex].collision=true;
                    }
                    if( (x==3 || x==2)&& (y==27 ||y==28)){ //tavolo marrone
                        tile[tileIndex].collision=true;
                    }
                    if( (x==3 ||x==4 ) && (y==25 || y==26 )){ //banco alto sx
                        tile[tileIndex].collision=true;
                    }
                    if( (x==6 ||x==7 ) && (y==25 || y==26 )){ //banco basso sx
                        tile[tileIndex].collision=true;
                    }
                    if( (x==3 ||x==4 ) && (y==30 || y==31 )){ //banco alto dx
                        tile[tileIndex].collision=true;
                    }
                    if( (x==6 ||x==7 ) && (y==30 || y==31 )){ //banco basso dx
                        tile[tileIndex].collision=true;
                    }

                    //STANZA 1
                    if( x==13 && y>25){
                        tile[tileIndex].collision=true;
                    }
                    if( x==14 && y>25 && y<28){    //scaffali  alto dsx
                        tile[tileIndex].collision=true;
                    }
                    if( x>13 && x<17 && y>29 ){  //reception + scaffale mid dx
                        tile[tileIndex].collision=true;
                    }
                    if( x==16 && y>25 && y<28){  //scaffale mid sx
                        tile[tileIndex].collision=true;
                    }
                    if( ((x==18 && y==26) || (x==19 && (y==26 ||y==27)))){  //scaffale basso sx
                        tile[tileIndex].collision=true;
                    }
                    if( ((x==18 && y==30) || (x==19 && y>29 ))){  //scaffale basso dx
                        tile[tileIndex].collision=true;
                    }

                    //STANZA 2
                    if( x>24 && x<27 && y>20){  //lavagne e muro alto
                        tile[tileIndex].collision=true;
                    }
                    if( (x>26 && x<29) && (y==23 || y==24)){  //tavolo marrone
                        tile[tileIndex].collision=true;
                    }
                    if( (x==31 ) && (y==21 || y==22)){  //bancone sx parte bassa
                        tile[tileIndex].collision=true;
                    }
                    if( (x==27) && (y>26 && y<31)){  //banchi alto
                        tile[tileIndex].collision=true;
                    }
                    if( (x==29) && (y>26 && y<31)){  //banchi mezzo
                        tile[tileIndex].collision=true;
                    }
                    if( (x==31) && (y>26 && y<31)){  //banchi basso
                        tile[tileIndex].collision=true;
                    }

                    //STANZA 3
                    if (x==37 && y>22) {
                        tile[tileIndex].collision=true; //parete alta
                    }
                    if (x==38 && y>30) {
                        tile[tileIndex].collision=true; //quadrato nero
                    }
                    if (x==40 && y>22 && (y!=24 && y!=28)) { //parete basssa stanze alte
                        tile[tileIndex].collision=true;
                    }
                    if (x==41 && (y==26 || y==27 || y==29 || y==30)) { //librerie corridoio
                        tile[tileIndex].collision=true;
                    }
                    if(x>37 && x<41 && y==26) { //parete verticale tra due stanze
                        tile[tileIndex].collision=true;
                    }

                    //STANZA 4
                    if ((x==49 || x==50)&& y>15) {
                        tile[tileIndex].collision=true; //parete alta
                    }
                    if ((x<56 && x>50)&& y==23) {
                        tile[tileIndex].collision=true; //parete u lato sx
                    }
                    if(x==55 && y==24){
                        tile[tileIndex].collision=true; //parete u lato basso
                    }
                    if ((x<56 && x>50)&& y==26) {
                        tile[tileIndex].collision=true; //parete u lato dx
                    }
                    if(x==52 && y==17){
                        tile[tileIndex].collision=true; //palo alto sx
                    }
                    if(x==52 && y==21){
                        tile[tileIndex].collision=true; //palo alto dx
                    }
                    if(x==55 && y==21){
                        tile[tileIndex].collision=true; //palo baso dx
                    }
                    if(x==55 && y==17){
                        tile[tileIndex].collision=true; //palo baso sx
                    }
                    if ((x<55 && x>51)&& (y<31 && y>27)) {
                        tile[tileIndex].collision=true; //quadrato tappeto
                    }
                    if (x==55 && y==30) {
                        tile[tileIndex].collision=true; //quadrato nero
                    }

                    //STANZA 5
                    if (x==62 && y>26) {
                        tile[tileIndex].collision=true; //parete alta
                    }
                    if (x==64 && y>23 && y<28) {
                        tile[tileIndex].collision=true; //parete scala alta
                    }
                    if (x==66 && y>25 && y<31) {
                        tile[tileIndex].collision=true; //parete alta scale doppie
                    }
                    if (x==68 && y>23 && y<27) {
                        tile[tileIndex].collision=true; //parete bassa sx scale doppie
                    }
                    if (x==68 && y>29) {
                        tile[tileIndex].collision=true; //parete bassa dx scale doppie
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
