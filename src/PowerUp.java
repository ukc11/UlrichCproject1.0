// PowerUp.java
public class PowerUp {
    private PowerUpType type;
    private int durationInSeconds; // How long it lasts

    public PowerUp(PowerUpType type, int durationInSeconds) {
        this.type = type;
        this.durationInSeconds = durationInSeconds;
    }

    public PowerUpType getType() {
        return type;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    @Override
    public String toString() {
        return type + " (" + durationInSeconds + "s)";
    }
}
