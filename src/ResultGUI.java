import javax.swing.*;
import java.awt.*;

public class ResultGUI extends JFrame {

    /**
     * Constructor that displays the correct answer to the user if they inputted the wrong answer.
     * @param q
     */
    ResultGUI(String q) {
        JFrame wrong = new JFrame();
        JPanel pWrong = new JPanel();
        GridBagConstraints gbc;

        //Answer label
        JLabel answer = new JLabel("Incorrect. The correct answer was: " + q);
        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        pWrong.add(answer, gbc);

        wrong.add(pWrong);
        wrong.pack();
        wrong.setLocationRelativeTo(null);
        wrong.setVisible(true);

    }
}