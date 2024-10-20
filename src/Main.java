import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //File reader
        ArrayList<String> gameFile = new ArrayList<>(RWGameFiles.readFile());

        //Makes window
        JFrame main = new GameGUI();
    }
}