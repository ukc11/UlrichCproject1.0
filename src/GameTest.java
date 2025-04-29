// GameTest.java
public class GameTest {
    public static void main(String[] args) {
        Cat cat = new Cat();

        PowerUp shield = new PowerUp(PowerUpType.SHIELD, 10);
        PowerUp speedBoost = new PowerUp(PowerUpType.SPEED_BOOST, 5);
        PowerUp extraLife = new PowerUp(PowerUpType.EXTRA_LIFE, 0); // Instant effect

        cat.pickUpPowerUp(shield);
        cat.pickUpPowerUp(speedBoost);
        cat.pickUpPowerUp(extraLife);

        // Simulate some game seconds passing
        cat.update(3);
        cat.update(3);

        cat.getHit(); // Should use shield
        cat.getHit(); // Should lose a life now

        // Simulate more seconds passing
        cat.update(5);
    }
}
