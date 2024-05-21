package main;
//test
import entity.Entity;
import entity.NPC_BlondeWoman;
import entity.NPC_Explorer;
import object.OBJ_Door;
import object.OBJ_Gin;
import object.OBJ_Pen;
import object.OBJ_Tejon;

public class AssetSpawn {
    GamePanel gp;
    public AssetSpawn(GamePanel gp){
        this.gp=gp;

    }
    public void npcLeaveObject( Entity[] npcs){  //metodo con cui l'npc la prima volta che viene incontrato rilascia una chiave
        for(int i=0;i<npcs.length;i++){
            if(npcs[i]!=null){
                if(npcs[i].isAGiver == true){
                    if ((npcs[i].hits>0) && (npcs[i].hits==1 || npcs[i].hits%100== 0)){
                        switch (gp.npc[i].itemToGive){
                            case 0:
                                gp.obj[0] = new OBJ_Pen();
                                gp.obj[0].worldX =npcs[i].worldX ;
                                gp.obj[0].worldY = npcs[i].worldY + (1* gp.tileSize);
                                break;
                            case 1:
                                gp.obj[0] = new OBJ_Gin();
                                gp.obj[0].worldX =npcs[i].worldX ;
                                gp.obj[0].worldY = npcs[i].worldY + (1* gp.tileSize);
                                break;

                        }
                    }
                }

            }

        }
    }

    public void setNPC(){

    }
}
