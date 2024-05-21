package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX,worldY;
    public int speed;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public String direction;

    public int spriteCounter =0;
    public int spriteNum =1;

    public Rectangle solidArea=new Rectangle(0,0,48,48);
    public int solidAreaDefaultX,solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter=0;
    public  int hits = 0; //la uso per controllare la prima collisione tra player e npc
    public boolean isAGiver=false; //stabilisce quali NPC droppano item
    public int itemToGive=0; //lo uso per stabilire quale item viene droppato


    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public void setAction(){}
    public void update(){
        setAction();

        collisionOn= false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this,false);
        gp.cChecker.checkPlayer(this);
        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(!collisionOn){
            switch(direction){
                case "up":
                    worldY-=speed; //in Java upper left corner is X:0 Y:0
                    break;
                case "down":
                    worldY+=speed;
                    break;
                case "left":
                    worldX-=speed;
                    break;
                case "right":
                    worldX+=speed;
                    break;
            }
        }

        spriteCounter++;
        if(spriteCounter > 10) { //quel 10 indica velocità animazione camminata
            if(spriteNum == 1){
                spriteNum=2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter =0;
        }

    }
    public void draw(Graphics2D g2){
        int screenX = worldX-gp.player.worldX+gp.player.screenX;//position on the screen
        int screenY = worldY-gp.player.worldY+gp.player.screenY;
        BufferedImage image=null;

        if (worldX +gp.tileSize> gp.player.worldX-gp.player.screenX &&  //con questo if non disegno tutta la mappa ma solo quella visibile
                worldX -gp.tileSize < gp.player.worldX+gp.player.screenX &&
                worldY +gp.tileSize> gp.player.worldY-gp.player.screenY &&
                worldY -gp.tileSize < gp.player.worldY+gp.player.screenY){
            switch(direction){
                case"up":
                    if(spriteNum == 1){
                        image=up1;
                    }
                    if(spriteNum == 2){
                        image= up2;
                    }
                    break;
                case "down":
                    if(spriteNum == 1){
                        image=down1;
                    }
                    if(spriteNum == 2){
                        image= down2;
                    }
                    break;
                case "right":
                    if(spriteNum == 1){
                        image=right1;
                    }
                    if(spriteNum == 2){
                        image= right2;
                    }
                    break;
                case "left":
                    if(spriteNum == 1){
                        image=left1;
                    }
                    if(spriteNum == 2){
                        image= left2;
                    }
                    break;
            }

            g2.drawImage(image,screenX,screenY,gp.tileSize, gp.tileSize,null);
        }

    }
}