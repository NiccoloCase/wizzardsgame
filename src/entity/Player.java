package entity;


import main.GamePanel;
import main.KeyHandler;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX; //where we draw player on the screen;
    public final int screenY;
    public int hasPen=0; //how many pens the player has
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp=gp;
        this.keyH=keyH;
        screenX=gp.screenWidth/2 -(gp.tileSize/2);
        screenY = gp.screenHeight/2-(gp.tileSize/2);

        solidArea =new Rectangle(); //this is for collision; the rectangle hasn't the same dimension as the player for better game mechanics
        solidArea.x=6;
        solidArea.y=16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width=22;//dimensione rettangolo soido
        solidArea.height=22;//dimensione rettangolo soido

        setDefaultValues();
        getPlayerImage();

    }
    public  void setDefaultValues(){
        worldX=gp.tileSize*23; //player (starting) position on the world map; not in the display
        worldY=gp.tileSize*21;
        speed=4;
        direction = "down";
    }
    private void getPlayerImage() {
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

    }
    //PICKUP OBJECT METHOD
    public void pickUpObject (int i){
        if(i!=999){ //if index = 999 we didn't touch any object
            String objectName = gp.obj[i].name;
            switch(objectName){
                case "Pen":
                    hasPen++;
                    gp.obj[i]=null;
                    gp.ui.showMessage("Pipus???");
                    break;
                case "Door":
                    if (hasPen > 0){
                        gp.obj[i]=null;
                        hasPen--;
                        gp.ui.showMessage("You put the pipus in the door...it's open");
                    }
                    else{
                        gp.ui.showMessage("You better go findng another Pipus");
                    }
                    break;
                case "Tejon":
                    gp.ui.showMessage("GinBro_Mode.Activate");
                    break;
                case "Gin":
                    speed+=2;
                    gp.obj[i]=null;
                    gp.ui.showMessage("GinBro_Mode.Activate");
                    break;
            }

            //test

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
