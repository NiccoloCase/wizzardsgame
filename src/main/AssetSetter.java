package main;
//test
import entity.NPC_BlondeWoman;
import entity.NPC_Explorer;
import object.OBJ_Door;
import object.OBJ_Gin;
import object.OBJ_Pen;
import object.OBJ_Tejon;

import java.awt.*;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(){
        // lasciare libero l'oggetto indice 0, perché è quello che compare da collisione con npc



        //BLOCCO PORTE 0
        gp.obj[3] = new OBJ_Door("Aula Comunista"); //ingresso stanza 0
        gp.obj[3].worldX = 24 * gp.tileSize;
        gp.obj[3].worldY = 4 * gp.tileSize;


        gp.obj[4] = new OBJ_Door("Corridoio 0"); //uscita stanza 0
        gp.obj[4].worldX = 28 * gp.tileSize;
        gp.obj[4].worldY = 9 * gp.tileSize;

        gp.obj[5] = new OBJ_Door("Piano 1"); //uscita corridoio 0
        gp.obj[5].worldX = 8 * gp.tileSize;
        gp.obj[5].worldY = 12 * gp.tileSize;

        //BLOCCO PORTE 1
        gp.obj[6] = new OBJ_Door("Biblioteja Novoli"); //ingresso stanza 1
        gp.obj[6].worldX = 25 * gp.tileSize;
        gp.obj[6].worldY = 15 * gp.tileSize;

        gp.obj[7] = new OBJ_Door("Corridoio 1"); //uscita stanza 1
        gp.obj[7].worldX = 29 * gp.tileSize;
        gp.obj[7].worldY = 21 * gp.tileSize;

        gp.obj[8] = new OBJ_Door("Piano 2"); //uscita corridoio 1
        gp.obj[8].worldX = 6 * gp.tileSize;
        gp.obj[8].worldY = 24 * gp.tileSize;
        gp.obj[9] = new OBJ_Door("Piano 2"); //uscita corridoio 1.1
        gp.obj[9].worldX = 7 * gp.tileSize;
        gp.obj[9].worldY = 24 * gp.tileSize;

        //BLOCCO PORTE 2
        gp.obj[10] = new OBJ_Door("Aula 217"); //ingresso stanza 2
        gp.obj[10].worldX = 21 * gp.tileSize;
        gp.obj[10].worldY = 27 * gp.tileSize;

        gp.obj[11] = new OBJ_Door("Corridoio 2"); //uscita stanza 2
        gp.obj[11].worldX = 24 * gp.tileSize;
        gp.obj[11].worldY = 33 * gp.tileSize;

        gp.obj[12] = new OBJ_Door("Piano 3"); //uscita corridoio 2
        gp.obj[12].worldX = 5 * gp.tileSize;
        gp.obj[12].worldY = 36 * gp.tileSize;
        gp.obj[13] = new OBJ_Door("Piano 3"); //uscita corridoio 2.1
        gp.obj[13].worldX = 6 * gp.tileSize;
        gp.obj[13].worldY = 36 * gp.tileSize;

        //BLOCCO PORTE 3
        gp.obj[14] = new OBJ_Door("Casa Caps"); //ingresso stanza 3
        gp.obj[14].worldX = 22 * gp.tileSize;
        gp.obj[14].worldY = 42 * gp.tileSize;

        gp.obj[15] = new OBJ_Door("Corridoio 3"); //uscita stanza 3
        gp.obj[15].worldX = 29 * gp.tileSize;
        gp.obj[15].worldY = 45 * gp.tileSize;
        gp.obj[16] = new OBJ_Door("Corridoio 3"); //uscita stanza 3.1
        gp.obj[16].worldX = 30 * gp.tileSize;
        gp.obj[16].worldY = 45 * gp.tileSize;

        gp.obj[17] = new OBJ_Door("Piano 4"); //uscita corridoio 3
        gp.obj[17].worldX = 5 * gp.tileSize;
        gp.obj[17].worldY = 48 * gp.tileSize;
        gp.obj[18] = new OBJ_Door("Piano 4"); //uscita corridoio 3.1
        gp.obj[18].worldX = 6 * gp.tileSize;
        gp.obj[18].worldY = 48 * gp.tileSize;

        //BLOCCO PORTE 4
        gp.obj[19] = new OBJ_Door("Palestra CUS"); //ingresso stanza 4
        gp.obj[19].worldX = 15 * gp.tileSize;
        gp.obj[19].worldY = 54 * gp.tileSize;

        gp.obj[20] = new OBJ_Door("Corridoio 4"); //uscita stanza 4
        gp.obj[20].worldX = 26 * gp.tileSize;
        gp.obj[20].worldY = 58 * gp.tileSize;
        gp.obj[21] = new OBJ_Door("Corridoio 4"); //uscita stanza 4.1
        gp.obj[21].worldX = 25 * gp.tileSize;
        gp.obj[21].worldY = 58 * gp.tileSize;

        gp.obj[22] = new OBJ_Door("Piano 5"); //uscita corridoio 4
        gp.obj[22].worldX = 6 * gp.tileSize;
        gp.obj[22].worldY = 61 * gp.tileSize;

        //BLOCCO PORTE 5
        gp.obj[23] = new OBJ_Door("SH"); //ingresso stanza 5
        gp.obj[23].worldX = 23 * gp.tileSize;
        gp.obj[23].worldY = 66 * gp.tileSize;

        gp.obj[24] = new OBJ_Door("Corridoio 5"); //uscita stanza 5
        gp.obj[24].worldX = 28 * gp.tileSize;
        gp.obj[24].worldY = 70 * gp.tileSize;

        gp.obj[25]= new OBJ_Tejon();
        gp.obj[25].worldX = 3 * gp.tileSize;
        gp.obj[25].worldY = 72 * gp.tileSize;










    }

    public void setNPC(){
        //NPC Pen GIVER
        gp.npc[0] = new NPC_Explorer(gp); //pre stanza 0
        gp.npc[0].worldX=gp.tileSize*8;
        gp.npc[0].worldY=gp.tileSize*6;
        gp.npc[0].isAGiver=true;


        gp.npc[1] = new NPC_BlondeWoman(gp);
        gp.npc[1].worldX=gp.tileSize*24; //stanza 0
        gp.npc[1].worldY=gp.tileSize*8;
        gp.npc[1].isAGiver=true;

        gp.npc[2] = new NPC_Explorer(gp); //corridoio stanza 0
        gp.npc[2].worldX=gp.tileSize*10;
        gp.npc[2].worldY=gp.tileSize*10;
        gp.npc[2].isAGiver=true;

        gp.npc[3] = new NPC_BlondeWoman(gp); //pre stanza 1
        gp.npc[3].worldX=gp.tileSize*3;
        gp.npc[3].worldY=gp.tileSize*19;
        gp.npc[3].isAGiver=true;

        gp.npc[4] = new NPC_Explorer(gp); //stanza 1
        gp.npc[4].worldX=gp.tileSize*29;
        gp.npc[4].worldY=gp.tileSize*16;
        gp.npc[4].isAGiver=true;

        gp.npc[5] = new NPC_BlondeWoman(gp);//corridoio 1
        gp.npc[5].worldX=gp.tileSize*10;
        gp.npc[5].worldY=gp.tileSize*23;
        gp.npc[5].isAGiver=true;

        gp.npc[6] = new NPC_Explorer(gp); //pre stanza 2
        gp.npc[6].worldX=gp.tileSize*6;
        gp.npc[6].worldY=gp.tileSize*30;
        gp.npc[6].isAGiver=true;

        gp.npc[7] = new NPC_BlondeWoman(gp); //stanza 2
        gp.npc[7].worldX=gp.tileSize*28;
        gp.npc[7].worldY=gp.tileSize*30;
        gp.npc[7].isAGiver=true;

        gp.npc[8] = new NPC_BlondeWoman(gp);//corridoio 2
        gp.npc[8].worldX=gp.tileSize*30;
        gp.npc[8].worldY=gp.tileSize*34;
        gp.npc[8].isAGiver=true;

        gp.npc[9] = new NPC_Explorer(gp); //pre stanza 3
        gp.npc[9].worldX=gp.tileSize*4;
        gp.npc[9].worldY=gp.tileSize*43;
        gp.npc[9].isAGiver=true;

        gp.npc[10] = new NPC_BlondeWoman(gp); //stanza 3
        gp.npc[10].worldX=gp.tileSize*28;
        gp.npc[10].worldY=gp.tileSize*43;
        gp.npc[10].isAGiver=true;

        gp.npc[11] = new NPC_BlondeWoman(gp);//corridoio 3
        gp.npc[11].worldX=gp.tileSize*6;
        gp.npc[11].worldY=gp.tileSize*47;
        gp.npc[11].isAGiver=true;

        gp.npc[12] = new NPC_Explorer(gp); //pre stanza 4
        gp.npc[12].worldX=gp.tileSize*4;
        gp.npc[12].worldY=gp.tileSize*56;
        gp.npc[12].isAGiver=true;

        gp.npc[13] = new NPC_BlondeWoman(gp); //stanza 4
        gp.npc[13].worldX=gp.tileSize*28;
        gp.npc[13].worldY=gp.tileSize*57;
        gp.npc[13].isAGiver=true;

        gp.npc[14] = new NPC_BlondeWoman(gp);//corridoio 4
        gp.npc[14].worldX=gp.tileSize*30;
        gp.npc[14].worldY=gp.tileSize*60;
        gp.npc[14].isAGiver=true;

        gp.npc[15] = new NPC_Explorer(gp); //pre stanza 4
        gp.npc[15].worldX=gp.tileSize*5;
        gp.npc[15].worldY=gp.tileSize*56;
        gp.npc[15].isAGiver=true;

        /*gp.npc[16] = new NPC_BlondeWoman(gp); //stanza 4
        gp.npc[16].worldX=gp.tileSize*28;
        gp.npc[16].worldY=gp.tileSize*57;
        gp.npc[16].isAGiver=true;*/

        gp.npc[17] = new NPC_BlondeWoman(gp);//corridoio 4
        gp.npc[17].worldX=gp.tileSize*30;
        gp.npc[17].worldY=gp.tileSize*60;
        gp.npc[17].isAGiver=true;

        gp.npc[18] = new NPC_Explorer(gp); //pre stanza 5
        gp.npc[18].worldX=gp.tileSize*4;
        gp.npc[18].worldY=gp.tileSize*67;
        gp.npc[18].isAGiver=true;

       /* gp.npc[19] = new NPC_BlondeWoman(gp); //stanza 5
        gp.npc[19].worldX=gp.tileSize*28;
        gp.npc[19].worldY=gp.tileSize*67;
        gp.npc[19].isAGiver=true;

        //NPC Pen GIVER BONUS
        gp.npc[20] = new NPC_Explorer(gp); // bonus pre stanza 0
        gp.npc[20].worldX=gp.tileSize*12;
        gp.npc[20].worldY=gp.tileSize*7;
        gp.npc[20].isAGiver=true;

        gp.npc[21] = new NPC_Explorer(gp); //bonus pre stanza 3
        gp.npc[21].worldX=gp.tileSize*12;
        gp.npc[21].worldY=gp.tileSize*39;
        gp.npc[21].isAGiver=true;

*/
        //NPC Gin GIVER
        gp.npc[22] = new NPC_BlondeWoman(gp); //gin giver stanza 4
        gp.npc[22].worldX=gp.tileSize*26;
        gp.npc[22].worldY=gp.tileSize*55;
        gp.npc[22].isAGiver=true;
        gp.npc[22].itemToGive=1;

        gp.npc[23] = new NPC_Explorer(gp); //gin giver pre stanza 5
        gp.npc[23].worldX=gp.tileSize*14;
        gp.npc[23].worldY=gp.tileSize*65;
        gp.npc[23].isAGiver=true;
        gp.npc[23].itemToGive=1;

        gp.npc[75] = new NPC_BlondeWoman(gp); //stanza 3
        gp.npc[75].worldX=gp.tileSize*28;
        gp.npc[75].worldY=gp.tileSize*42;
        gp.npc[75].isAGiver=true;
        gp.npc[75].itemToGive=1;

        // NPC NOT GIVER
        gp.npc[24] = new NPC_BlondeWoman(gp); //pre stanza 0
        gp.npc[24].worldX=gp.tileSize*11;
        gp.npc[24].worldY=gp.tileSize*6;

        gp.npc[25] = new NPC_Explorer(gp); //pre stanza 0
        gp.npc[25].worldX=gp.tileSize*15;
        gp.npc[25].worldY=gp.tileSize*7;

        gp.npc[26] = new NPC_Explorer(gp); //pre stanza 0
        gp.npc[26].worldX=gp.tileSize*18;
        gp.npc[26].worldY=gp.tileSize*2;

        gp.npc[26] = new NPC_Explorer(gp); // stanza 0
        gp.npc[26].worldX=gp.tileSize*25;
        gp.npc[26].worldY=gp.tileSize*3;

        gp.npc[26] = new NPC_Explorer(gp); // stanza 0
        gp.npc[26].worldX=gp.tileSize*26;
        gp.npc[26].worldY=gp.tileSize*6;

        gp.npc[27] = new NPC_BlondeWoman(gp); //corridoio stanza 0
        gp.npc[27].worldX=gp.tileSize*18;
        gp.npc[27].worldY=gp.tileSize*11;

        gp.npc[28] = new NPC_BlondeWoman(gp); //pre stanza 1
        gp.npc[28].worldX=gp.tileSize*4;
        gp.npc[28].worldY=gp.tileSize*19;

        gp.npc[29] = new NPC_Explorer(gp); //pre stanza 1
        gp.npc[29].worldX=gp.tileSize*5;
        gp.npc[29].worldY=gp.tileSize*19;

        gp.npc[30] = new NPC_BlondeWoman(gp); //pre stanza 1
        gp.npc[30].worldX=gp.tileSize*8;
        gp.npc[30].worldY=gp.tileSize*19;

        gp.npc[31] = new NPC_Explorer(gp); //stanza 1
        gp.npc[31].worldX=gp.tileSize*27;
        gp.npc[31].worldY=gp.tileSize*16;


        gp.npc[32] = new NPC_BlondeWoman(gp); //stanza 1
        gp.npc[32].worldX=gp.tileSize*27;
        gp.npc[32].worldY=gp.tileSize*16;

        gp.npc[33] = new NPC_BlondeWoman(gp);//corridoio 1
        gp.npc[33].worldX=gp.tileSize*19;
        gp.npc[33].worldY=gp.tileSize*23;


        gp.npc[34] = new NPC_Explorer(gp);//corridoio 1
        gp.npc[34].worldX=gp.tileSize*29;
        gp.npc[34].worldY=gp.tileSize*23;

        gp.npc[35] = new NPC_Explorer(gp); //pre stanza 2
        gp.npc[35].worldX=gp.tileSize*4;
        gp.npc[35].worldY=gp.tileSize*30;

        gp.npc[36] = new NPC_Explorer(gp); //pre stanza 2
        gp.npc[36].worldX=gp.tileSize*6;
        gp.npc[36].worldY=gp.tileSize*28;

        gp.npc[37] = new NPC_BlondeWoman(gp); //pre stanza 2
        gp.npc[37].worldX=gp.tileSize*7;
        gp.npc[37].worldY=gp.tileSize*31;

        gp.npc[38] = new NPC_BlondeWoman(gp); //pre stanza 2
        gp.npc[38].worldX=gp.tileSize*11;
        gp.npc[38].worldY=gp.tileSize*25;

        gp.npc[39] = new NPC_Explorer(gp); //pre stanza 2
        gp.npc[39].worldX=gp.tileSize*14;
        gp.npc[39].worldY=gp.tileSize*29;

        gp.npc[40] = new NPC_BlondeWoman(gp); //pre stanza 2
        gp.npc[40].worldX=gp.tileSize*12;
        gp.npc[40].worldY=gp.tileSize*26;

        gp.npc[41] = new NPC_BlondeWoman(gp); //stanza 2
        gp.npc[41].worldX=gp.tileSize*29;
        gp.npc[41].worldY=gp.tileSize*31;

        gp.npc[42] = new NPC_Explorer(gp); //stanza 2
        gp.npc[42].worldX=gp.tileSize*30;
        gp.npc[42].worldY=gp.tileSize*29;

        gp.npc[43] = new NPC_BlondeWoman(gp);//corridoio 2
        gp.npc[43].worldX=gp.tileSize*3;
        gp.npc[43].worldY=gp.tileSize*33;

        gp.npc[44] = new NPC_Explorer(gp);//corridoio 2
        gp.npc[44].worldX=gp.tileSize*13;
        gp.npc[44].worldY=gp.tileSize*34;

        gp.npc[45] = new NPC_BlondeWoman(gp); //pre stanza 3
        gp.npc[45].worldX=gp.tileSize*4;
        gp.npc[45].worldY=gp.tileSize*40;

        gp.npc[46] = new NPC_Explorer(gp); //pre stanza 3
        gp.npc[46].worldX=gp.tileSize*5;
        gp.npc[46].worldY=gp.tileSize*43;

        gp.npc[47] = new NPC_Explorer(gp); //pre stanza 3
        gp.npc[47].worldX=gp.tileSize*6;
        gp.npc[47].worldY=gp.tileSize*43;

        gp.npc[48] = new NPC_BlondeWoman(gp); //pre stanza 3
        gp.npc[48].worldX=gp.tileSize*7;
        gp.npc[48].worldY=gp.tileSize*43;

        gp.npc[49] = new NPC_BlondeWoman(gp); //pre stanza 3
        gp.npc[49].worldX=gp.tileSize*8;
        gp.npc[49].worldY=gp.tileSize*43;

        gp.npc[50] = new NPC_Explorer(gp); //stanza 3
        gp.npc[50].worldX=gp.tileSize*29;
        gp.npc[50].worldY=gp.tileSize*43;

        gp.npc[51] = new NPC_BlondeWoman(gp); //stanza 3
        gp.npc[51].worldX=gp.tileSize*27;
        gp.npc[51].worldY=gp.tileSize*43;

        gp.npc[52] = new NPC_BlondeWoman(gp);//corridoio 3
        gp.npc[52].worldX=gp.tileSize*16;
        gp.npc[52].worldY=gp.tileSize*47;


        gp.npc[53] = new NPC_Explorer(gp);//corridoio 3
        gp.npc[53].worldX=gp.tileSize*26;
        gp.npc[53].worldY=gp.tileSize*47;


        gp.npc[54] = new NPC_BlondeWoman(gp); //pre stanza 4
        gp.npc[54].worldX=gp.tileSize*5;
        gp.npc[54].worldY=gp.tileSize*56;

        gp.npc[55] = new NPC_Explorer(gp); //pre stanza 4
        gp.npc[55].worldX=gp.tileSize*6;
        gp.npc[55].worldY=gp.tileSize*56;

        gp.npc[56] = new NPC_BlondeWoman(gp); //pre stanza 4
        gp.npc[56].worldX=gp.tileSize*7;
        gp.npc[56].worldY=gp.tileSize*56;

        gp.npc[57] = new NPC_Explorer(gp); //pre stanza 4
        gp.npc[57].worldX=gp.tileSize*8;
        gp.npc[57].worldY=gp.tileSize*56;

        gp.npc[58] = new NPC_BlondeWoman(gp); //pre stanza 4
        gp.npc[58].worldX=gp.tileSize*9;
        gp.npc[58].worldY=gp.tileSize*56;

        gp.npc[59] = new NPC_Explorer(gp); //pre stanza 4
        gp.npc[59].worldX=gp.tileSize*10;
        gp.npc[59].worldY=gp.tileSize*56;

        gp.npc[60] = new NPC_BlondeWoman(gp); //stanza 4
        gp.npc[60].worldX=gp.tileSize*24;
        gp.npc[60].worldY=gp.tileSize*57;

        gp.npc[61] = new NPC_Explorer(gp); //stanza 4
        gp.npc[61].worldX=gp.tileSize*25;
        gp.npc[61].worldY=gp.tileSize*57;

        gp.npc[62] = new NPC_BlondeWoman(gp); //stanza 4
        gp.npc[62].worldX=gp.tileSize*29;
        gp.npc[62].worldY=gp.tileSize*57;

        gp.npc[63] = new NPC_Explorer(gp); //stanza 4
        gp.npc[63].worldX=gp.tileSize*18;
        gp.npc[63].worldY=gp.tileSize*57;

        gp.npc[64] = new NPC_BlondeWoman(gp);//corridoio 4
        gp.npc[64].worldX=gp.tileSize*3;
        gp.npc[64].worldY=gp.tileSize*60;

        gp.npc[65] = new NPC_Explorer(gp);//corridoio 4
        gp.npc[65].worldX=gp.tileSize*23;
        gp.npc[65].worldY=gp.tileSize*60;

        gp.npc[66] = new NPC_Explorer(gp); //pre stanza 5
        gp.npc[66].worldX=gp.tileSize*4;
        gp.npc[66].worldY=gp.tileSize*67;

        gp.npc[67] = new NPC_BlondeWoman(gp); //pre stanza 5
        gp.npc[67].worldX=gp.tileSize*5;
        gp.npc[67].worldY=gp.tileSize*67;

        gp.npc[68] = new NPC_BlondeWoman(gp); //pre stanza 5
        gp.npc[68].worldX=gp.tileSize*6;
        gp.npc[68].worldY=gp.tileSize*67;

        gp.npc[69] = new NPC_BlondeWoman(gp); //pre stanza 5
        gp.npc[69].worldX=gp.tileSize*7;
        gp.npc[69].worldY=gp.tileSize*67;

        gp.npc[70] = new NPC_BlondeWoman(gp); //pre stanza 5
        gp.npc[70].worldX=gp.tileSize*8;
        gp.npc[70].worldY=gp.tileSize*67;

        gp.npc[71] = new NPC_Explorer(gp); //pre stanza 5
        gp.npc[71].worldX=gp.tileSize*9;
        gp.npc[71].worldY=gp.tileSize*67;

        gp.npc[72] = new NPC_BlondeWoman(gp); //pre stanza 5
        gp.npc[72].worldX=gp.tileSize*10;
        gp.npc[72].worldY=gp.tileSize*67;

        gp.npc[73] = new NPC_BlondeWoman(gp); //stanza 5
        gp.npc[73].worldX=gp.tileSize*30;
        gp.npc[73].worldY=gp.tileSize*67;

        gp.npc[74] = new NPC_Explorer(gp); //corridoio 5
        gp.npc[74].worldX=gp.tileSize*3;
        gp.npc[74].worldY=gp.tileSize*70;












    }
}
