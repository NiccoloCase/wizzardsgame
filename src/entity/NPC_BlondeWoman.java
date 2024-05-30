package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

public class NPC_BlondeWoman extends Entity{
    public NPC_BlondeWoman(GamePanel gp){
        super(gp);

        direction ="down";
        speed=2;
        getPlayerImage();
    }

    private void getPlayerImage() {
        try {
            up1 = ImageIO.read(new File("res/NPC/BlondeWoman/BWNPC rightback.png"));
            up2 = ImageIO.read(new File("res/NPC/BlondeWoman/BWNPC leftfback.png"));
            down1 = ImageIO.read(new File("res/NPC/BlondeWoman/BWNPC rightfront.png"));
            down2 = ImageIO.read(new File("res/NPC/BlondeWoman/BWNPC leftfront.png"));
            right1 = ImageIO.read(new File("res/NPC/BlondeWoman/BWNPC rightmove.png"));
            right2 = ImageIO.read(new File("res/NPC/BlondeWoman/BWNPC rightstand.png"));
            left1 = ImageIO.read(new File("res/NPC/BlondeWoman/BWNPC leftmove.png"));
            left2 = ImageIO.read(new File("res/NPC/BlondeWoman/BWNPC leftstand.png"));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or display a user-friendly message)
        }
    }
    public void setAction() {
        actionLockCounter++;

        if(actionLockCounter==60){
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
            if (i>75&& i<100){
                direction= "right";
            }
            actionLockCounter=0;
        }
    }

}
