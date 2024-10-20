import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads text file to add category and questions to the game
 */
public class RWGameFiles {

    public static ArrayList<String> catAndQuest = new ArrayList<>();

    public static ArrayList<String> readFile() throws FileNotFoundException {
        File gameFile = new File("CatAndQuestions.txt");
        Scanner fileScan = new Scanner(gameFile);
        fileScan.useDelimiter("\s[|]\s");

        while (fileScan.hasNext()) {
            catAndQuest.add(fileScan.next());
        }

        fileScan.close();
        return catAndQuest;
    }
}
