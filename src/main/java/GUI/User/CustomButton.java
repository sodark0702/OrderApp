package GUI.User;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {

    public CustomButton(String name) {
        super(name);
        this.setBackground(new Color(0, 120, 255));
        this.setForeground(Color.WHITE);
    }

    public CustomButton(String name, Color color) {
        super(name);
        this.setBackground(color);
        this.setForeground(Color.decode("#666666"));
    }

}
