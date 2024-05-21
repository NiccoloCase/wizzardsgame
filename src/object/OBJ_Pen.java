package object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class OBJ_Pen extends SuperObject{
    public OBJ_Pen(){
        name= "Pen";
        solidArea=new Rectangle(0,0,64,64);
        try{
            image = ImageIO.read(new File("res/objects/pen.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
