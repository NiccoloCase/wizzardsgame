package main;
import java.io.File;
import javax.swing.JFrame;
public class Main {
    public static void main(String[] args){
        JFrame window =new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Wizards Game");


        GamePanel gamePanel =new GamePanel();
        window.add(gamePanel);

        window.pack(); //la finestra viene ridimensionata automaticamente per adattarsi al contenuto

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();

        //TODO: finish keyInput (video #2 from min 12:02) //non ricordo se ho fatto ma penso di si
    }
}