// ActivePowerUp.java
public class ActivePowerUp {
    private PowerUp powerUp;
    private int remainingTimeInSeconds;

    public ActivePowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
        this.remainingTimeInSeconds = powerUp.getDurationInSeconds();
    }

    public void decreaseTime(int seconds) {
        remainingTimeInSeconds -= seconds;
    }

    public boolean isExpired() {
        return remainingTimeInSeconds <= 0;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }
}
