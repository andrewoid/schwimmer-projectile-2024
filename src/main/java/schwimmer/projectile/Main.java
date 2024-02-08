package schwimmer.projectile;

public class Main {

    public static void main(String[] args) {
        Projectile projectile = new Projectile(31, 65);

        for (int i = 0; i < 10; i++) {
            projectile.setSeconds(i);
            System.out.println("t = " + i + " y = " + projectile.getY());
        }

    }

}
