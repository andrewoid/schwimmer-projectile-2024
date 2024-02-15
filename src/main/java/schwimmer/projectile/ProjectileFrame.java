package schwimmer.projectile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JTextField velocityField = new JTextField();
        JTextField angleField = new JTextField();
        JTextField secondsField = new JTextField();

        add(velocityLabel);
        add(velocityField);

        add(angleLabel);
        add(angleField);

        add(secondsLabel);
        add(secondsField);

        add(new JLabel());
        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Projectile projectile = new Projectile(
                        Double.parseDouble(velocityField.getText()),
                        Double.parseDouble(angleField.getText())
                );
                projectile.setSeconds(
                        Double.parseDouble(secondsField.getText())
                );

            }
        });

    }

}
