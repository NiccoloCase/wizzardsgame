package object;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Pen extends SuperObject{
    public OBJ_Pen(){
        name= "Pen";
        try{
            image = ImageIO.read(new File("res/objects/pen.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
