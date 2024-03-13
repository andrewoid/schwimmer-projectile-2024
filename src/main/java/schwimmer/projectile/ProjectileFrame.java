package schwimmer.projectile;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProjectileFrame extends JFrame {

    private final JSlider velocitySlider;
    private final JLabel velocityField;
    private final JSlider angleSlider;
    private final JLabel angleField;
    private final JTextField secondsField;
    private final ProjectileGraph graph;

    public ProjectileFrame() {
        setSize(800, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        setContentPane(main);

        graph = new ProjectileGraph();
        main.add(graph, BorderLayout.CENTER);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);
        west.setLayout(new GridLayout(6, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        velocitySlider = new JSlider(0, 100, 65);
        velocityField = new JLabel("65");
        angleSlider = new JSlider(0, 90, 31);
        angleField = new JLabel("31");
        secondsField = new JTextField("2.7");

        west.add(velocityLabel);
        west.add(velocitySlider);
        west.add(new JLabel());
        west.add(velocityField);

        west.add(angleLabel);
        west.add(angleSlider);
        west.add(new JLabel());
        west.add(angleField);

        west.add(secondsLabel);
        west.add(secondsField);

        angleSlider.addChangeListener(e -> displayProjectile());
        velocitySlider.addChangeListener(e -> displayProjectile());
        secondsField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                displayProjectile();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                displayProjectile();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                displayProjectile();
            }
        });

        displayProjectile();
    }

    private void displayProjectile() {
        try {
            int velocity = velocitySlider.getValue();
            velocityField.setText(String.valueOf(velocity));
            int angle = angleSlider.getValue();
            angleField.setText(String.valueOf(angle));
            Projectile projectile = new Projectile(
                    angle,
                    velocity
            );
            projectile.setSeconds(
                    Double.parseDouble(secondsField.getText())
            );
            graph.setProjectile(projectile);
        } catch (NumberFormatException e) {
            // expected if a field doesn't contain a number
        }
    }

}
