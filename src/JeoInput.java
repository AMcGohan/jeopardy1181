import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JeoInput {

    private static final File gameFile = new File("CatAndQuestions.txt");
    public static ArrayList<String[]> gameLines = new ArrayList<>();

    public static ArrayList<String[]> gameInput() throws FileNotFoundException {
        Scanner fileScan = new Scanner(gameFile);
        fileScan.useDelimiter(" [|] ");
        while (fileScan.hasNext()) {
            String[] lines = new String[7];
            for (int i = 0; i < 7; i++) {
                String newLine = fileScan.next();
                lines[i] = newLine;
                if (!fileScan.hasNext()) {
                    break;
                }
            }
            gameLines.add(lines);
        }
        return gameLines;
    }
}
