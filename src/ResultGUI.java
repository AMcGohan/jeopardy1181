import javax.swing.*;
import java.awt.*;

public class ResultGUI extends JFrame {

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