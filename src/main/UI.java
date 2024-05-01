package main;

import object.OBJ_Pen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

//  ALL THE ON-SCREEN UI
public class UI {
    GamePanel gp;
    Font italic_40;
    BufferedImage penImage;
    public boolean messageOn = false;
    public String message="";
    int messageCounter =0;
    public UI(GamePanel gp){
        this.gp=gp;
        italic_40=new Font("Italic", Font.ITALIC, 40);
        OBJ_Pen pen = new OBJ_Pen();
        penImage=pen.image;

    }

    public void showMessage(String text){
        message=text;
        messageOn=true;
    }
    public void draw(Graphics2D g2){
        g2.setFont(italic_40);
        g2.setColor((Color.white) );
        g2.drawImage(penImage,gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
        g2.drawString("x"+gp.player.hasPen,74,65);

        //MESSAGE
        if(messageOn){
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message,gp.tileSize/2,gp.tileSize*5);

            messageCounter++;
            if(messageCounter > 120){
                messageCounter=0;
                messageOn=false;
            }
        }



    }
}

