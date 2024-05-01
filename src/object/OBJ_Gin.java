package object;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Gin extends SuperObject{
    public OBJ_Gin(){
        name= "Gin";
        try{
            image = ImageIO.read(new File("res/objects/ginbottle.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
