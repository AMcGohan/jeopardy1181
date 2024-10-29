import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionGUI extends JFrame implements ActionListener {

    private String questionText;
    private String gameAnswer;
    private JTextField answerField;
    private int questionPoints;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            String userAnswer = answerField.getText();
            if (userAnswer.equalsIgnoreCase(gameAnswer.trim())) {
                GameGUI.currentPoint += questionPoints;
            } else {
                GameGUI.currentPoint -= questionPoints;
            }
            GameGUI.pointCounter.setText("$" + GameGUI.currentPoint);
            dispose();
        }
    }


    QuestionGUI(String q, String a, int p) {

        questionText = q;
        gameAnswer = a;
        questionPoints = p;


        setTitle(questionText);
        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GridBagConstraints gbc = new GridBagConstraints();

        //JPanel Setup
        JPanel qMain = new JPanel();
        qMain.setLayout(new GridBagLayout());

        //Question
        JLabel qLabel = new JLabel("Question: " + questionText);
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
