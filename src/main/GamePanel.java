package main;
import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale =3;

    final int tileSize= originalTileSize * scale; // 48x48 tile
    final int maxScreenCol= 16;
    final int maxScreenRow =12;
    final int  screenWidth=tileSize*maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    Thread gameThread;
    //TODO: complete class GamePanel (video#3 min 2:30)
    //TODO: complete class GamePanel (video#4 min 0:00,video#7 min:5:40)

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while(gameThread != null){
           // System.out.println("The game loop is running");

            //1 UPDATE: update information such as character position
            update();
            //2 DRAW: draw the screen with the updated information
            repaint();
        }

    }
    public void update(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(100,100,tileSize,tileSize);
        g2.dispose();
    }
}
