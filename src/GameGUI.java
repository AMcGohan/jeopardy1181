import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;

public class GameGUI extends JFrame {

//    public void questionButtons() {
//        for (int i = 1; i < RWGameFiles.catAndQuest.size(); i++) {
//            JButton q = new JButton(RWGameFiles.catAndQuest.get(i));
//            gbc = new GridBagConstraints();
//            gbc.gridx=0;
//            gbc.gridy=0;
//            gamePanel.add(q, gbc);
//        }
//    }


    GameGUI() {
        //Setting up GUI
        setTitle("Quiz Game");
        setSize(600,600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));
        GridBagConstraints gbc = null;
        //Buttons for questions
        for (int i = 1; i < RWGameFiles.catAndQuest.size(); i++) {
            JButton q = new JButton(RWGameFiles.catAndQuest.get(i));
            gbc = new GridBagConstraints();
            gbc.gridx=0;
            gbc.gridy = i;
            gbc.insets = new Insets(0, 0, 5, 0);
            mainPanel.add(q, gbc);
        }
        add(mainPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
