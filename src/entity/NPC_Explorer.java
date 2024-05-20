package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

public class NPC_Explorer extends Entity{
    public NPC_Explorer(GamePanel gp){
        super(gp);

        direction ="down";
        speed=2;
        getPlayerImage();
    }

    private void getPlayerImage() {
        try {
            up1 = ImageIO.read(new File("res/NPC/Explorer/EXPNPC rightback.png"));
            up2 = ImageIO.read(new File("res/NPC/Explorer/EXPNPC leftback.png"));
            down1 = ImageIO.read(new File("res/NPC/Explorer/EXPNPC rightfront.png"));
            down2 = ImageIO.read(new File("res/NPC/Explorer/EXPNPC leftfront.png"));
            right1 = ImageIO.read(new File("res/NPC/Explorer/EXPNPC rightmove.png"));
            right2 = ImageIO.read(new File("res/NPC/Explorer/EXPNPC rightstand.png"));
            left1 = ImageIO.read(new File("res/NPC/Explorer/EXPNPC leftmove.png"));
            left2 = ImageIO.read(new File("res/NPC/Explorer/EXPNPC leftstand.png"));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or display a user-friendly message)
        }
    }
    public void setAction() {
        actionLockCounter++;

        if(actionLockCounter==600){
            Random random = new Random();
            int i= random.nextInt(100)+1; //pick up a number from 1 to 100

            if(i<=25){
                direction = "up";
            }
            if (i>25 && i<=50){
                direction= "down";
            }
            if (i>50 && i<=75){
                direction= "left";
            }
            if (i>75){
                direction= "right";
            }
            actionLockCounter=0;
        }
    }

}
