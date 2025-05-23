package GUI.SignIn;

import javax.swing.*;
import java.awt.*;

public class PasswordField extends JPanel {

    private final JLabel passwordl;
    private final JPasswordField passwordField;

    public PasswordField() {
        this.setLayout(new GridLayout(2, 1));

        this.passwordl = new JLabel("Password");


        this.passwordField = new JPasswordField();

        this.add(this.passwordl);
        this.add(this.passwordField);
    }


    public JLabel getPasswordl() {
        return passwordl;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
}
