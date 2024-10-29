import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionGUI extends JFrame implements ActionListener {

    private final String gameAnswer;
    private final JTextField answerField;
    private final int questionPoints;

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
            dispose();
        }
    }


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

        add(qMain);
        pack();
        setVisible(true);


    }
}
