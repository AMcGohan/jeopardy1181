import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuestionGUI extends JFrame implements ActionListener {

    private final String gameAnswer;
    private final JTextField answerField;
    private final int questionPoints;

    /**
     * If the submit button is pressed, the action listener checks the text field to see if it matches with the game files
     * answer. If it does, it gives points to the users score. If not, it takes away the points. Closes window and changes
     * the color of the score depending on if the score is negative/positive.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            String userAnswer = answerField.getText();
            //If answer is correct:
            if (userAnswer.equalsIgnoreCase(gameAnswer.trim())) {
                GameGUI.currentPoint += questionPoints;
            } else {
                ResultGUI result = new ResultGUI(gameAnswer);
                GameGUI.currentPoint -= questionPoints;
            }
            GameGUI.pointCounter.setText("$" + GameGUI.currentPoint);
            if (GameGUI.currentPoint > 0) {
                GameGUI.pointCounter.setForeground(Color.GREEN);
            } else if (GameGUI.currentPoint < 0) {
                GameGUI.pointCounter.setForeground(Color.RED);
            } else {
                GameGUI.pointCounter.setForeground(Color.gray);
            }
            dispose();
        }
    }

    /**
     * GUI constructor that creates a window displaying the question with a text field and a submit button.
     * @param q game's question
     * @param a game's answer
     * @param p user's points
     */
    QuestionGUI(String q, String a, int p) {

        gameAnswer = a;
        questionPoints = p;


        setTitle(q);
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();

        //JPanel Setup
        JPanel qMain = new JPanel();
        qMain.setLayout(new GridBagLayout());

        //Question
        JLabel qLabel = new JLabel("Question: " + q);
        gbc = new GridBagConstraints();
        gbc.gridx= 0;
        gbc.gridy=0;
        gbc.insets = new Insets(10,10,10,10);
        qMain.add(qLabel, gbc);

        //JTextField for Answer
        answerField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        answerField.setColumns(25);
        gbc.insets = new Insets(10,10,10,10);
        qMain.add(answerField, gbc);

        //JButton for Submit
        JButton submit = new JButton("Submit");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,10,10,10);
        submit.addActionListener(this);
        qMain.add(submit, gbc);

        /**
         * This is in case user clicks a question and clicks 'X' on the window. The game will immediately subtract
         * their score
         * Source for addWindowListener: https://www.clear.rice.edu/comp310/JavaResources/frame_close.html
         */
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GameGUI.currentPoint -= questionPoints;
                GameGUI.pointCounter.setText("$" + GameGUI.currentPoint);
                if (GameGUI.currentPoint > 0) {
                    GameGUI.pointCounter.setForeground(Color.GREEN);
                } else if (GameGUI.currentPoint < 0) {
                    GameGUI.pointCounter.setForeground(Color.RED);
                } else {
                    GameGUI.pointCounter.setForeground(Color.gray);
                }
            }
        });

        add(qMain);
        pack();
        setVisible(true);


    }
}
