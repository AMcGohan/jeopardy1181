import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //File reader
        ArrayList<String[]> game = new ArrayList<>(JeoInput.gameInput());

        //Makes window
        JFrame main = new GameGUI();
    }
}