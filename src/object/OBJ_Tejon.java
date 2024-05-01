package object;

import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Tejon extends SuperObject {
    public OBJ_Tejon(){
        name= "Tejon";
        try{
            image = ImageIO.read(new File("res/objects/Tejon.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
