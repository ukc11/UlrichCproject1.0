// GameWindow.java
import javax.swing.JFrame;

public class GameWindow extends JFrame {

    public GameWindow() {
        setTitle("Crossy Cat - Powerup Demo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GamePanel panel = new GamePanel();
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}
