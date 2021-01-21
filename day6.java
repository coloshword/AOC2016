import java.util.Scanner;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class day6 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day6.txt"));
        ArrayList<Character> chars = new ArrayList<>();
        int charPerLine = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            charPerLine = line.length();
            for (int i = 0; i < charPerLine; i++) {
                chars.add(line.charAt(i));
            }
        }
        //System.out.println(chars);
        //now check for the most common occurence
        String ans = "";
        String ans2 = "";
        for (int column = 0; column < charPerLine; column++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int row = 0; row < chars.size(); row += charPerLine) {
                updateMap(map, chars.get(column + row));
            }
            ans += getMaxValue(map);
            ans2 += getMinValue(map);
        }
        System.out.println(ans);
        // for part 2:
        System.out.println(ans2);
    }

    public static void updateMap(HashMap<Character, Integer> a, char b) {
        if (a.get(b) == null) {
            a.put(b, 1);
        } else {
            a.put(b, a.get(b) + 1);
        }
    }

    public static char getMaxValue(HashMap<Character, Integer> a) {
        int max = 0;
        char ans = 'x';
        // for part 2
        for (Entry<Character, Integer> entry : a.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if(value > max) {
                max = value;
                ans = key;
            }
        }
        return ans;
    }

    public static char getMinValue(HashMap<Character, Integer> a) {
        int min = 100000;
        char ans = 'x';
        // for part 2
        for (Entry<Character, Integer> entry : a.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if(value < min) {
                min = value;
                ans = key;
            }
        }
        return ans;
    }
    
}
