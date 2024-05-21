package main;
import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale =5;

    public final int tileSize= originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol= 16;
    public final int maxScreenRow =12;
    public final int  screenWidth=tileSize*maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels


    // WORLD SETTINGS

    public  final int maxWorldCol=33;
    public final int maxWorldRow=74;
    public final int worldWidth =tileSize*maxWorldCol;
    public final int worldHeight = tileSize*maxWorldRow;




    //FPS
    int FPS = 60;
    TileManager tileM = new TileManager(this);
    KeyHandler keyH=new KeyHandler();


    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public AssetSpawn aSpawner= new AssetSpawn(this);

    Thread gameThread;
    public UI ui = new UI(this);

    //ENTITY AND OBJECT
    public Player player =new Player(this,keyH);
    public SuperObject obj[] =new SuperObject[100];
    public Entity npc[] = new Entity[100];






    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame(){

        aSetter.setObject();
        aSetter.setNPC();
    }

    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval =1000000000/FPS;
        double delta =0;
        long lastTime =System.nanoTime();
        long currentTime;


        while(gameThread != null) {
            currentTime = System.nanoTime();
            //currentTime2=System.currentTimeMillis(); //nano is more precise than milli
            delta += (currentTime - lastTime) / drawInterval; //se tra lastTime e currentTime è passato almeno drawInterval(tempo necessario per garantire 60 fps) allora avviene update e repaint
            lastTime=currentTime;

            if (delta >= 1) {
                //1 UPDATE: update information such as character position
                update();
                //2 DRAW: draw the screen with the updated information
                repaint();
                delta--;  //sottraggo 1 così se c'era scarto (deta >1) viene mantenuto in delta e il prossimo update è eseguito prima
            }

        }




    }
    public void update(){
        //PLAYER
        player.update();
        // NPC
        for(int i=0;i<npc.length;i++){
            if(npc[i]!=null){
                npc[i].update();
            }
        }
        aSpawner.npcLeaveObject(npc);

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;

        //TILE
        tileM.draw(g2);

        //OBJECT
        for (int i = 0; i<obj.length;i++){
            if(obj[i]!= null){
                obj[i].draw(g2,this);
            }
        }
        //NPC
        for (int i=0;i<npc.length;i++){
            if(npc[i] != null){
                npc[i].draw(g2);
            }
        }

        //PLAYER
        player.draw(g2);
        //UI
        ui.draw(g2,g3);
        g2.dispose();
    }
}

