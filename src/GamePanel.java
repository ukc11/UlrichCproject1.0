// GamePanel.java
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private CatSprite cat;
    private List<PowerUpSprite> powerUps;
    private Random random;

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);

        cat = new CatSprite(100, 500);
        powerUps = new ArrayList<>();
        random = new Random();

        // Spawn a powerup every so often
        spawnPowerUp();

        timer = new Timer(); // Roughly 60 FPS
    }

    private void spawnPowerUp() {
        int x = random.nextInt(700) + 50;
        int y = random.nextInt(400) + 50;
        PowerUpType[] types = PowerUpType.values();
        PowerUpType type = types[random.nextInt(types.length)];
        powerUps.add(new PowerUpSprite(x, y, type));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cat.update(1); // Assume 1 second passes for simplicity

        // Check for collisions with powerups
        List<PowerUpSprite> collected = new ArrayList<>();
        for (PowerUpSprite p : powerUps) {
            if (cat.getBounds().intersects(p.getBounds())) {
                cat.pickUpPowerUp(new PowerUp(p.getType(), 10));
                collected.add(p);
            }
        }
        powerUps.removeAll(collected);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw Cat
        cat.draw(g);

        // Draw PowerUps
        for (PowerUpSprite p : powerUps) {
            p.draw(g);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Simple movement
        if (key == KeyEvent.VK_LEFT) {
            cat.move(-10, 0);
        } else if (key == KeyEvent.VK_RIGHT) {
            cat.move(10, 0);
        } else if (key == KeyEvent.VK_UP) {
            cat.move(0, -10);
        } else if (key == KeyEvent.VK_DOWN) {
            cat.move(0, 10);
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}
