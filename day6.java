import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class day6 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day6.txt"));
        ArrayList<Character> chars = new ArrayList<>();
        int lines = 0;
        int charPerLine = 0;
        while(input.hasNextLine()) {
            lines++;
            String line = input.nextLine();
            charPerLine = line.length();
            for(int i = 0; i < charPerLine; i++) {
                chars.add(line.charAt(i));
            }
        }
        // now check for the most common occurence
        for(int column = 0; column < charPerLine; column++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int row = 0; row < lines; row++) {
                
            }
        }
    }

    public static void updateMap(HashMap<Character, Integer> a, char b) {
        
    }
    
}
