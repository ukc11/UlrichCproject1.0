// CatSprite.java
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CatSprite {
    private int x, y, width, height;
    private List<ActivePowerUp> activePowerUps;
    private int lives;

    public CatSprite(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.activePowerUps = new ArrayList<>();
        this.lives = 1;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void pickUpPowerUp(PowerUp powerUp) {
        System.out.println("Picked up: " + powerUp);
        if (powerUp.getType() == PowerUpType.EXTRA_LIFE) {
            lives++;
        } else {
            activePowerUps.add(new ActivePowerUp(powerUp));
        }
    }

    public void update(int secondsPassed) {
        Iterator<ActivePowerUp> iterator = activePowerUps.iterator();
        while (iterator.hasNext()) {
            ActivePowerUp active = iterator.next();
            active.decreaseTime(secondsPassed);
            if (active.isExpired()) {
                System.out.println(active.getPowerUp().getType() + " expired!");
                iterator.remove();
            }
        }
    }

    public void draw(Graphics g) {
        if (isShielded()) {
            g.setColor(Color.CYAN);
        } else {
            g.setColor(Color.PINK);
        }
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isShielded() {
        return activePowerUps.stream()
                .anyMatch(p -> p.getPowerUp().getType() == PowerUpType.SHIELD);
    }
}
