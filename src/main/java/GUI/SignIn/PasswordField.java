package GUI.SignIn;

import javax.swing.*;

public class PasswordField extends JPanel {

    private final JLabel passwordl;
    private final JPasswordField passwordField;

    public PasswordField() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.passwordl = new JLabel("Password");
        this.passwordl.setHorizontalAlignment(SwingConstants.LEFT);

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
