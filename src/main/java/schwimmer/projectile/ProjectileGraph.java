package schwimmer.projectile;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;

public class ProjectileGraph extends JComponent {

    private static final int OFFSET = 30;
    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

    private Projectile projectile = new Projectile(0,0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        clear(g);

        g.translate(OFFSET, getHeight() - OFFSET);

        drawGrid(g);

        drawCurrentLocation(g);

        drawPath(g);

        drawApex(g);
    }

    private void drawApex(Graphics g) {
        Projectile clone = new Projectile(projectile);
        clone.setSeconds(clone.getApexTime());
        g.setColor(Color.BLUE);
        g.fillOval((int) clone.getX()-5, (int) -clone.getY()-5, 10, 10);
        g.drawString(
                "(" + FORMAT.format(clone.getX()) +", " + FORMAT.format(clone.getY()) +")",
                (int) clone.getX() - OFFSET,
                (int) -(clone.getY() + OFFSET)
        );
    }

    private void drawPath(Graphics g) {
        Projectile clone = new Projectile(projectile);
        g.setColor(Color.BLACK);
        int x = 0;
        int y = 0;
        double seconds = 0;
        do {
            seconds++;
            clone.setSeconds(seconds);
            g.drawLine(x, -y, (int) clone.getX(), (int) -clone.getY());
            x = (int) clone.getX();
            y = (int) clone.getY();
        } while (seconds < clone.getApexTime() * 2);
    }

    private void drawCurrentLocation(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int) projectile.getX()-5, (int) -projectile.getY()-5, 10, 10);
        g.drawString(
                "(" + FORMAT.format(projectile.getX()) +", " + FORMAT.format(projectile.getY()) +")",
                (int) projectile.getX() - OFFSET,
                (int) -(projectile.getY() + OFFSET)
        );
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(-OFFSET, 0, getWidth(), 0); // X Axis
        g.drawLine(0, +OFFSET, 0, -getHeight()); // Y Axis

        g.setColor(Color.LIGHT_GRAY);
        for (int y=OFFSET; y<getHeight(); y+=OFFSET) {
            g.drawLine(-OFFSET, -y, getWidth(), -y); // X Lines
        }
        for (int x=OFFSET; x<getWidth(); x+=OFFSET) {
            g.drawLine(x, +OFFSET, x, -getHeight()); // Y Lines
        }
    }

    private void clear(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, getWidth(), getHeight());
    }


    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        repaint();
    }
}
