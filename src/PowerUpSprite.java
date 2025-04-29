// PowerUpSprite.java
import java.awt.*;

public class PowerUpSprite {
    private int x, y, size;
    private PowerUpType type;

    public PowerUpSprite(int x, int y, PowerUpType type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.size = 30;
    }

    public void draw(Graphics g) {
        switch (type) {
            case SHIELD -> g.setColor(Color.CYAN);
            case SPEED_BOOST -> g.setColor(Color.ORANGE);
            case INVISIBILITY -> g.setColor(Color.GRAY);
            case EXTRA_LIFE -> g.setColor(Color.RED);
        }
        g.fillOval(x, y, size, size);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    public PowerUpType getType() {
        return type;
    }
}
