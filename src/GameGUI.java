import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class GameGUI extends JFrame {

    private static int currentPoint;
    private JLabel pointCounter;
    private JLabel qLabel;
    private JTextField answerText;
    private String gameAnswer;
    private int questionPoints;

    /**
     * Once a button is pressed, actionPerformed checks the buttons category and question, then opens a new panel that
     * asks the question  to the user with a text field.
     */
    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] points = new String[]{"$250", "$500", "$1000"};
            String[] category;

            //Question buttons
            if (e.getSource() instanceof JButton && !((JButton) e.getSource()).getText().equalsIgnoreCase("submit")) {
                ((JButton) e.getSource()).setEnabled(false);
                for (int i = 0; i < 5; i++)
                    if (((JButton) e.getSource()).getName().equalsIgnoreCase("c" + i)) {
                        category = JeoInput.gameLines.get(i);
                        for (int j = 1; j < 4; j++) {
                            if (((JButton) e.getSource()).getText().equalsIgnoreCase(points[j - 1])) {
                                questionPoints = Integer.parseInt(points[j - 1].replace("$", ""));

                                int a = j + 3;
                                timeToQuestion(category[j], category[a]);
                            }
                        }
                    }
            }
            //Submit button
            if (e.getSource() instanceof JButton) {
                String userAnswer = answerText.getText();
                if (((JButton) e.getSource()).getText().equalsIgnoreCase("Submit")) {
                    answerText.setText("");

                    //Answer was correct
                    if (userAnswer.equalsIgnoreCase(gameAnswer.trim())) {
                        qLabel.setText("Correct!");
                        currentPoint += questionPoints;
                        pointCounter.setText("$" + currentPoint);

                        //Answer was incorrect
                    } else {
                        qLabel.setText("Incorrect. Answer was: " + gameAnswer);
                        currentPoint -= questionPoints;
                        System.out.println(gameAnswer);
                        pointCounter.setText("$" + currentPoint);
                    }
                }
            }
        }
    }


    public void timeToQuestion(String q, String a) {
        qLabel.setText("Question: " + q);
        gameAnswer = a;

    }

    /**
     * Adds the main grid with Categories on the left side and questions with points on the right
     *
     * @param p main JPanel
     */
    public void mainLayout(JPanel p) {
        Collections.shuffle(JeoInput.gameLines);
        Integer[] points = new Integer[]{250, 500, 1000};
        GridBagConstraints gbc;
        ButtonListener bl = new ButtonListener();

        for (int i = 0; i < 5; i++) {
            //Categories
            String[] catArray = JeoInput.gameLines.get(i);
            JButton c = new JButton(catArray[0]);
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.insets = new Insets(0, 0, 5, 0);
            c.addActionListener(bl);
            c.setEnabled(false);
            p.add(c, gbc);

            //Points
            //$250
            JButton q = new JButton("$" + points[0]);
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.insets = new Insets(0, 0, 5, 0);
            q.addActionListener(bl);
            q.setName("c" + i);
            p.add(q, gbc);
            //$500
            JButton q2 = new JButton("$" + points[1]);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = i;
            gbc.insets = new Insets(0, 0, 5, 0);
            q2.addActionListener(bl);
            q2.setName("c" + i);
            p.add(q2, gbc);
            //$1000
            JButton q3 = new JButton("$" + points[2]);
            gbc = new GridBagConstraints();
            gbc.gridx = 3;
            gbc.gridy = i;
            gbc.insets = new Insets(0, 0, 5, 0);
            q3.addActionListener(bl);
            q3.setName("c" + i);
            p.add(q3, gbc);

            //Components that are added to panel ONE TIME
            if (i == 4) {
                //Point counter
                pointCounter = new JLabel("$0");
                gbc = new GridBagConstraints();
                gbc.gridx = 2;
                gbc.gridy = 4;
                p.add(pointCounter, gbc);

                //JLabel for Questions
                qLabel = new JLabel("Question: ");
                gbc = new GridBagConstraints();
                gbc.gridx = 3;
                gbc.gridy = 4;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                p.add(qLabel, gbc);

                //JTextField for Answer
                answerText = new JTextField();
                gbc = new GridBagConstraints();
                gbc.gridx = 4;
                gbc.gridy = 4;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                p.add(answerText, gbc);

                //Submit Button
                JButton submitButton = new JButton("Submit");
                gbc = new GridBagConstraints();
                gbc.gridx = 5;
                gbc.gridy = 4;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                submitButton.addActionListener(bl);
                p.add(submitButton, gbc);

//                //Instructions
//                JButton instructions = new JButton("Instructions");
//                gbc = new GridBagConstraints();
//                gbc.gridx = 0;
//                gbc.gridy= 6;
//                p.add(instructions, gbc);
            }
        }
    }

    GameGUI() {
        //Setting up GUI
        setTitle("Quiz Game");
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 5));

        mainLayout(mainPanel);
        add(mainPanel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}