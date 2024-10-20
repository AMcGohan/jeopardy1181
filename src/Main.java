import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> gameFile = new ArrayList<>(RWGameFiles.readFile());

        Random rand = new Random() ;
        for (int i = 0; i < 20; i++) {
            System.out.println(gameFile.get(rand.nextInt(1, 6)));
        }
    }
}