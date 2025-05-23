import GUI.Frame;
import GUI.SignIn.SignIn;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SignIn::new);
    }

}
