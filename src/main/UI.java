package main;

import object.OBJ_Pen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;

//  ALL THE ON-SCREEN UI
public class UI {
    GamePanel gp;
    Font italic_40,arial_60B,romanic_90;
    BufferedImage penImage;
    public boolean messageOn = false;
    public String message="";
    public String RoomName="Piano 0";
    int messageCounter =0;
    public boolean gameFinished=false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00"); //this is to display only two decimals in the time counter



    public UI(GamePanel gp){
        this.gp=gp;
        italic_40=new Font("Italic", Font.ITALIC, 40);
        romanic_90=new Font("Italic", Font.CENTER_BASELINE, 90);

        arial_60B=new Font("Arial", Font.BOLD, 60);
        OBJ_Pen pen = new OBJ_Pen();
        penImage=pen.image;

    }

    public void showMessage(String text){
        message=text;
        messageOn=true;
    }
    public void setRoomName(Graphics2D g3,String text){
        g3.setFont(romanic_90);
        g3.setColor((Color.pink) );
        RoomName=text;
        int textLength;
        textLength= (int)g3.getFontMetrics().getStringBounds(text,g3).getWidth();
        int x;
        int y;
        x= gp.screenWidth/2-textLength/2;
        y=gp.screenHeight/2-(gp.tileSize*9/2);
        g3.drawString(text,x,y);

    }

    public void draw(Graphics2D g2,Graphics2D g3){
        if(gameFinished){

            g2.setFont(italic_40);
            g2.setColor((Color.white) );

            String text;
            int textLength;
            int x;
            int y;

            text="MIRA EL TEJON!!!";
            textLength= (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth(); //returns text's length

            x= gp.screenWidth/2-textLength/2;
            y=gp.screenHeight/2-(gp.tileSize*3);
            g2.drawString(text,x,y);

            text="Your Time is :"+ dFormat.format(playTime)+"!";
            textLength= (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth(); //returns text's length
            x= gp.screenWidth/2-textLength/2;
            y=gp.screenHeight/2+(gp.tileSize*4);
            g2.drawString(text,x,y);

            g2.setFont(arial_60B);
            g2.setColor((Color.YELLOW) );
            text="Congratulations!!!";
            textLength= (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth(); //returns text's length
            x= gp.screenWidth/2-textLength/2;
            y=gp.screenHeight/2+(gp.tileSize*2);
            g2.drawString(text,x,y);

            gp.gameThread=null;


        }
        else{
            g2.setFont(italic_40);
            g2.setColor((Color.white) );
            g2.drawImage(penImage,gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
            g2.drawString("x"+gp.player.hasPen,120,90);

            //NOME STANZA
            setRoomName(g3,RoomName);

            //TIME
            g2.setFont(italic_40);
            g2.setColor((Color.white) );
            playTime+=(double)1/60;
            g2.drawString("Time:"+dFormat.format(playTime),gp.tileSize*13,65);
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
}

