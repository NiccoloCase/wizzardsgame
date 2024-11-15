package entity;


import main.GamePanel;
import main.KeyHandler;
import main.AssetSpawn;
import object.OBJ_Door;

import java.io.File;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    KeyHandler keyH;

    public final int screenX; //where we draw player on the screen;
    public final int screenY;
    public int hasPen=0; //how many pens the player has
    public int RoomMessageCode=0;
    public long lastPickUpTime = 0;
    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);

        this.keyH=keyH;
        screenX=gp.screenWidth/2 -(gp.tileSize/2);
        screenY = gp.screenHeight/2-(gp.tileSize/2);

        solidArea =new Rectangle(); //this is for collision; the rectangle hasn't the same dimension as the player for better game mechanics
        solidArea.x=17;
        solidArea.y=22;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width=22;//dimensione rettangolo soido
        solidArea.height=22;//dimensione rettangolo soido

        setDefaultValues();
        getPlayerImage();

    }
    public  void setDefaultValues(){
        worldX=gp.tileSize*3; //player (starting) position on the world map; not in the display
        worldY=gp.tileSize*3;
        speed=7;
        direction = "down";
    }
    private void getPlayerImage() {  //è ridondante fare la stessa cosa per ogni personaggio quando potrei fare un metodo in Entity, ma la soluzione del tutorial è un pò diversa dalla mia e non voglio fixarla ora
        try {
            up1 = ImageIO.read(new File("res/player/wizard_up_1.png"));
            up2 = ImageIO.read(new File("res/player/wizard_up_2.png"));
            down1 = ImageIO.read(new File("res/player/wizard_down_1.png"));
            down2 = ImageIO.read(new File("res/player/wizard_down_2.png"));
            right1 = ImageIO.read(new File("res/player/wizard_right_1.png"));
            right2 = ImageIO.read(new File("res/player/wizard_right_2.png"));
            left1 = ImageIO.read(new File("res/player/wizard_left_1.png"));
            left2 = ImageIO.read(new File("res/player/wizard_left_2.png"));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or display a user-friendly message)
        }
    }



    public void update(){
        if(keyH.upPressed == true ||keyH.downPressed == true ||
                keyH.rightPressed == true ||keyH.leftPressed == true){
            if(keyH.upPressed){
                direction ="up";
            } else if (keyH.downPressed) {
                direction ="down";
            }else if(keyH.rightPressed){
                direction ="right";
            } else if (keyH.leftPressed) {
                direction ="left";
            }

            //CHECK TILE COLLISION
            collisionOn= false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this,true);

            pickUpObject(objIndex);

            //CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this,gp.npc);
            interactNPC(npcIndex);


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
        //CHECK ROOM TO DISPLAY
        if(worldY<9*gp.tileSize && worldX<23*gp.tileSize){
            gp.ui.RoomName="Piano 0";
        } else if (worldY<9*gp.tileSize) {
            gp.ui.RoomName="Aula Rossa";
        } else if (worldY<12*gp.tileSize) {
            gp.ui.RoomName="Corridoio 0";
        } else if (worldY<21*gp.tileSize && worldX<25*gp.tileSize){
            gp.ui.RoomName="Piano 1";
        } else if (worldY<21*gp.tileSize) {
            gp.ui.RoomName="Biblioteja Novoli";
        } else if (worldY<24*gp.tileSize) {
            gp.ui.RoomName="Corridoio 1";
        } else if (worldY<33*gp.tileSize && worldX<21*gp.tileSize) {
            gp.ui.RoomName="Piano 2";
        } else if (worldY<33*gp.tileSize) {
            gp.ui.RoomName="Aula 217";
        } else if (worldY<36*gp.tileSize) {
            gp.ui.RoomName="Corridoio 2";
        } else if (worldY<45*gp.tileSize && worldX<22*gp.tileSize) {
            gp.ui.RoomName="Piano 3";
        } else if (worldY<45*gp.tileSize) {
            gp.ui.RoomName="Casa Caps";
        } else if (worldY<48*gp.tileSize) {
            gp.ui.RoomName="Corridoio 3";
        } else if (worldY<58*gp.tileSize && worldX<15*gp.tileSize) {
            gp.ui.RoomName="Piano 4";
        } else if (worldY<58*gp.tileSize) {
            gp.ui.RoomName="Palestra CUS";
        } else if (worldY<61*gp.tileSize) {
            gp.ui.RoomName="Corridoio 4";
        } else if (worldY<70*gp.tileSize && worldX<23*gp.tileSize) {
            gp.ui.RoomName="Piano 5";
        } else if (worldY<70*gp.tileSize) {
            gp.ui.RoomName="SH";
        } else {
            gp.ui.RoomName="Corridoio 5";
        }
    }
    //PICKUP OBJECT METHOD
    public void pickUpObject (int i){
        if(i!=999){ //if index = 999 we didn't touch any object
            String objectName = gp.obj[i].name;
            switch(objectName){
                case "Pen":
                    hasPen++;
                    gp.obj[i]=null;
                    gp.ui.showMessage("key taken");
                    break;
                case "Door":
                    OBJ_Door door = (OBJ_Door) gp.obj[i];
                    if(door.collision){
                        if (hasPen > 0){
                            gp.obj[i].collision=false;
                            hasPen--;
                            gp.ui.showMessage("You put the key in the door...it's open");

                        }
                        else{
                            gp.ui.showMessage("You better go findng another key");
                        }
                    }
                    break;
                case "Tejon":
                    gp.ui.showMessage("Mira El TeJon");
                    gp.ui.gameFinished=true;
                    break;
                case "Gin":
                    speed+=2;
                    gp.obj[i]=null;
                    gp.ui.showMessage("GinBro_Mode.Activate");
                    break;

            }



        }

    }
    public void interactNPC(int i){
        if(i != 999){
            System.out.println(("you are hitting an npc!"));
            gp.npc[i].hits++;
        }
    }

    public void draw(Graphics2D g2){
        //   g2.setColor(Color.white);
        //   g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image=null;
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
