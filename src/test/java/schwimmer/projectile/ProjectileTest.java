package schwimmer.projectile;

import org.junit.jupiter.api.Test;
import schwimmer.projectile.Projectile;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectileTest {

    @Test
    public void getX() {
        // given
        Projectile projectile = new Projectile(31, 20);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getX();

        // then
        assertEquals(46.28, actual, 0.01);
    }

    @Test
    public void getY() {
        // given
        Projectile projectile = new Projectile(31, 20);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getY();

        // then
        assertEquals(-7.90, actual, 0.01);
    }

    @Test
    public void getApexTime() {
        // given
        Projectile projectile = new Projectile(31, 20);

        // when
        double actual = projectile.getApexTime();

        // then
        assertEquals(1.05, actual, 0.01);
    }

}