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

    public static boolean isRoom(String room, String checkSum) {
        // create the checkSum
        ArrayList<Integer> occurrencesOfEach = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < room.length() - 10; i++) {
            char currentChar = room.charAt(i);
            if(currentChar != '-' && !(characters.contains(currentChar))) {
                characters.add(currentChar);
                occurrencesOfEach.add(occurrences(currentChar, room));
            }
        }
        // bubble sort both lists
        sortBoth(characters, occurrencesOfEach);
        String correctCheckSum = printCheckSum(characters);
        if(correctCheckSum.equals(checkSum)) {
            return true;
        }
        return false;
    }

    public static String printCheckSum(ArrayList<Character> a ) {
        String ans = "";
        for(int i = a.size() - 1; i > a.size() - 6; i--) {
            ans += a.get(i);
        }
        return ans;
    }

    public static void sortBoth(ArrayList<Character> charList, ArrayList<Integer> intList) {
        for(int i = 0; i < intList.size() - 1; i++) {
            for(int j = 0; j < intList.size() - i - 1; j++) {
                if(intList.get(j) > intList.get(j + 1)) {
                    int temp = intList.get(j);
                    char tempChar = charList.get(j);
                    intList.set(j, intList.get(j+1));
                    charList.set(j, charList.get(j+1));
                    intList.set(j+1, temp);
                    charList.set(j+1, tempChar);
                }
            }
        }
        // sort alphabetically if necessary:
        int current = intList.get(0);
        int startIndex = 0;
        int endIndex = intList.size() - 1;
        for(int i = 1; i < intList.size(); i++) {
            if(current == intList.get(i)) {
                continue;
            }
            else {
                endIndex = i;
                if(endIndex - startIndex > 1)
                    sortAlphabeticalSection(charList, startIndex, endIndex - 1);
                startIndex = i;
                current = intList.get(i);
            }
        }
        // in case the if statement runs through the entire list
        sortAlphabeticalSection(charList, startIndex, endIndex);
    }

    public static void sortAlphabeticalSection(ArrayList<Character> charList, int startIndex, int endIndex) {
        for(int i = 0; i < endIndex - startIndex; i++) {
            for(int j = startIndex; j < endIndex; j++) {
                if(("" + charList.get(j)).compareTo("" + charList.get(j+1)) < 0) {
                    char temp = charList.get(j);
                    charList.set(j, charList.get(j+1));
                    charList.set(j+1, temp);
                }
            }
        }
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