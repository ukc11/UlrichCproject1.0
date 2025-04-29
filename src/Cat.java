// Cat.java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cat {
    private List<ActivePowerUp> activePowerUps;
    private int lives;

    public Cat() {
        this.activePowerUps = new ArrayList<>();
        this.lives = 1; // Default one life
    }

    public void pickUpPowerUp(PowerUp powerUp) {
        System.out.println("Picked up: " + powerUp);
        if (powerUp.getType() == PowerUpType.EXTRA_LIFE) {
            lives++;
            System.out.println("Extra life gained! Total lives: " + lives);
        } else {
            activePowerUps.add(new ActivePowerUp(powerUp));
        }
    }

    public boolean isShielded() {
        return activePowerUps.stream()
                .anyMatch(p -> p.getPowerUp().getType() == PowerUpType.SHIELD);
    }

    public boolean isInvisible() {
        return activePowerUps.stream()
                .anyMatch(p -> p.getPowerUp().getType() == PowerUpType.INVISIBILITY);
    }

    public boolean isSpeedBoosted() {
        return activePowerUps.stream()
                .anyMatch(p -> p.getPowerUp().getType() == PowerUpType.SPEED_BOOST);
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

    public void getHit() {
        if (isShielded()) {
            System.out.println("Hit absorbed by shield!");
            removePowerUp(PowerUpType.SHIELD);
        } else if (lives > 1) {
            lives--;
            System.out.println("Lost a life! Remaining lives: " + lives);
        } else {
            System.out.println("Game over! Cat is out of lives.");
        }
    }

    private void removePowerUp(PowerUpType type) {
        activePowerUps.removeIf(p -> p.getPowerUp().getType() == type);
    }
}
