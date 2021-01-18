import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class day4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day4.txt"));
        int sum = 0;
        while(input.hasNextLine()) {
            String line = input.nextLine();
            String key = line.substring(line.length() - 6, line.length() - 1);
            if(isRoom2(line, key)) {
                sum += Integer.parseInt(line.substring(line.length() - 10, line.length() - 7));
            }
        }
        System.out.println(sum);
    }

    public static boolean isRoom2(String room, String checkSum) {
        int priorOccurrences = occurrences(checkSum.charAt(0), room);
        HashMap<Character, Integer> map = new HashMap<>();
        String uniqueChars = "";
        for(int i = 0; i < room.length() - 11; i++) {
            char currentChar = room.charAt(i);
            if(!(contains(uniqueChars, currentChar)) && currentChar != '-') {
                uniqueChars += currentChar;
                map.put(currentChar, occurrences(currentChar, room));
            }
        }
        System.out.println(map);
        System.out.println(uniqueChars);
        for(int i = 1; i < checkSum.length(); i++) {
            char currentChar = checkSum.charAt(i);
            int currentOccurrences = occurrences(currentChar, room);
            if (currentOccurrences > priorOccurrences) {
                return false;
            }
            if (currentOccurrences == priorOccurrences && ("" + checkSum.charAt(i - 1)).compareTo(currentChar + "") > 0) {
                return false;
            }
            priorOccurrences = currentOccurrences;
        }
        // now check if no letters outside the checksum have a greater occurrence
        for(int j = 0; j < checkSum.length(); j++) {
            int currentMax = occurrences(checkSum.charAt(j), room);
            for (int i = 0; i < uniqueChars.length(); i++) {
                char currentChar = uniqueChars.charAt(i);
                if (!contains(checkSum, currentChar)) {
                    if(map.get(currentChar) > currentMax) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean contains(String a, char b) {
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b) {
                return true;
            }
        }
        return false;
    }
    
    public static int occurrences(char c, String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[') {
                break;
            }
            if(s.charAt(i) == c) {
                ans++;
            }
        }
        return ans;
    }
}