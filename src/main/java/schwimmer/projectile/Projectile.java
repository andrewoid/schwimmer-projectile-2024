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
//        double peakSeconds = getApexTime();
//        return sin(radians) * velocity * peakSeconds
//                - .5 * GRAVITY * peakSeconds * peakSeconds;
    }



}
