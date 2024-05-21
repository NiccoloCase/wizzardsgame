package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX,worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX=0;
    public int solidAreaDefaultY=0;
    public int messageCode=0; //lo uso per mettere a display un certo messaggio

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX-gp.player.worldX+gp.player.screenX;//position on the screen
        int screenY = worldY-gp.player.worldY+gp.player.screenY;

        if (worldX +gp.tileSize> gp.player.worldX-gp.player.screenX &&  //con questo if non disegno tutta la mappa ma solo quella visibile
                worldX -gp.tileSize < gp.player.worldX+gp.player.screenX &&
                worldY +gp.tileSize> gp.player.worldY-gp.player.screenY &&
                worldY -gp.tileSize < gp.player.worldY+gp.player.screenY){

            g2.drawImage(image,screenX,screenY,gp.tileSize, gp.tileSize,null);
        }
    }

}