package play.tharmsy;

import javax.swing.JOptionPane;
import play.tharmsy.UI.Auth.Auth;
import play.tharmsy.UI.JFrameWindow;

public class Start {
    public static void main(String[] args) {
        String[] options = { "Auth Window", "Simple Window" };
        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Window Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            Auth.main(args);
        } else if (choice == 1) {
            JFrameWindow.main(args);
        } else {
            System.out.println("Application closed.");
        }
    }
}
