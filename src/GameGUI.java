import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class GameGUI extends JFrame {

    public static int currentPoint;
    public static JLabel pointCounter;
    private JLabel qLabel;
    private JTextField answerText;
    private String gameAnswer;
    public static int questionPoints;

    /**
     * Once a button is pressed, actionPerformed checks the buttons category and question, then opens a new panel that
     * asks the question  to the user with a text field.
     */
    public static class ButtonListener implements ActionListener {

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
                                QuestionGUI gui = new QuestionGUI(category[j], category[a], questionPoints);
                            }
                        }
                    }
            }
        }
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
            gbc.insets = new Insets(4, 0, 4, 0);
            c.addActionListener(bl);
            c.setEnabled(false);
            p.add(c, gbc);

            //Points
            //$250
            JButton q = new JButton("$" + points[0]);
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.insets = new Insets(4, 2, 4, 2);
            q.addActionListener(bl);
            q.setName("c" + i);
            p.add(q, gbc);
            //$500
            JButton q2 = new JButton("$" + points[1]);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = i;
            gbc.insets = new Insets(4, 2, 4, 2);
            q2.addActionListener(bl);
            q2.setName("c" + i);
            p.add(q2, gbc);
            //$1000
            JButton q3 = new JButton("$" + points[2]);
            gbc = new GridBagConstraints();
            gbc.gridx = 3;
            gbc.gridy = i;
            gbc.insets = new Insets(4, 2, 4, 2);
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