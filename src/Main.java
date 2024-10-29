import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static JFrame tutorial;

    /**
     * ActionListener that disposes of tutorial window and opens the game GUI.
     */
    static class PlayGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                tutorial.dispose();
                JFrame main = new GameGUI();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //File reader
        ArrayList<String[]> game = new ArrayList<>(JeoInput.gameInput());
        
        //Instruction Window
        tutorial = new JFrame();
        JPanel tutPanel = new JPanel();
        tutPanel.setLayout(new GridLayout(2, 1));

        //Label
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel tut = new JLabel("<html>Welcome to the Quiz!<br/> To play the game, simply click a button next to each category to wager the points.</br>The game will ask you a question and you have to type in your answer into the text field and click submit.<br/> If you get it right, you earn that many points you've clicked on. If you lose, you'll lose that many points.</html>");
        gbc.gridx = 0;
        gbc.gridy= 0;
        tutPanel.add(tut, gbc);

        //Play Button
        JButton enter = new JButton("Play!");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy= 1;
        tutPanel.add(enter, gbc);
        PlayGame pg = new PlayGame();
        enter.addActionListener(pg);
        //Adding
        tutorial.add(tutPanel);
        tutorial.pack();
        tutorial.setLocationRelativeTo(null);
        tutorial.setVisible(true);
        tutorial.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }