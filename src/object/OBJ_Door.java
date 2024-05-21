package object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class OBJ_Door extends SuperObject {
    public String accessToRoom;
    public boolean unlocked =false;
    public int numAttraversamenti=0;
    public OBJ_Door(String accessToRoom){
        name= "Door";
        this.accessToRoom = accessToRoom;
        solidArea=new Rectangle(0,0,64,64);
        try{
            image = ImageIO.read(new File(""));

        } catch (Exception e) {
            e.printStackTrace();
        }
        collision=true;
    }

}

