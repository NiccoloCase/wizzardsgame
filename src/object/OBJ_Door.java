package object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class OBJ_Door extends SuperObject {
    public OBJ_Door(){
        name= "Door";
        solidArea=new Rectangle(0,0,64,64);
        try{
            image = ImageIO.read(new File("res/objects/door.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        collision=true;


    }

}

