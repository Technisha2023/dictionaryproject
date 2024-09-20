package testSamples;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryFile {


    public static boolean doesFileExist(String path) {
        try {


            File file = new File(path);
            if (file.exists() && file.isFile()) {
                readAndPrintDictionary(path);
                return true;
            } else {
                System.out.println("The file does not exist at the specified path.");
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println("Throwing the error occurred during file search "+e.getMessage());
            return false;
        }
    }
    public static void readAndPrintDictionary(String path) {
        Map<String, String[]> dictionary = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    String word = parts[0].trim();
                    String[] meanings = parts[1].split(", ");
                    dictionary.put(word, meanings);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // Print the dictionary
        for (Map.Entry<String, String[]> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey());
            for (String meaning : entry.getValue()) {
                System.out.println("  " + meaning);
            }
        }
    }
    public static void main(String[] args) {
        String filePath = "dictionary.txt";
        boolean exists = doesFileExist(filePath);
        System.out.println("File exists: " + exists);
    }
}
