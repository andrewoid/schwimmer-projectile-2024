package schwimmer.projectile;

import static java.lang.Math.sin;

public class Projectile {

    private static final double GRAVITY = 9.8;

    private final double angle;
    private final double radians;
    private final double velocity;
    private double seconds;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public Projectile(Projectile projectile) {
        this(projectile.angle, projectile.velocity);
        this.seconds = projectile.seconds;
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return sin(radians) * velocity * seconds
                - .5 * GRAVITY * seconds * seconds;
    }

    /**
     * @return the time when the Projectile is at its highest point.
     */
    public double getApexTime() {
        return (velocity * sin(radians)) / GRAVITY;
    }

    public double getPeakY() {
        return (sin(radians) * velocity) * (sin(radians) * velocity)  /  (GRAVITY * 2);
    }
}
