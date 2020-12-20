import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
public class day2_2 {
    public static void main(String[] args) {
        try {
            char[][] keypad = {
                    {'1'}, {'2', '3', '4'}, {'5', '6', '7', '8', '9'}, {'A', 'B', 'C'}, {'D'}
            };
            File fh = new File("day2.txt");
            Scanner input = new Scanner(fh);
            int[] currentKey = {2, 0};
            String key = "";
            while (input.hasNextLine()) {
                String instructions = input.nextLine();
                currentKey = readInstructions(instructions, currentKey, keypad);
                key += keypad[currentKey[0]][currentKey[1]];
            }
            System.out.println(key);
        }
        catch(Exception FileNotFoundException) {
            System.out.println("Something went wrong");
        }
    }
    public static int[] readInstructions(String instruct, int[] location, char[][] numPad) {
        for(int i = 0; i < instruct.length(); i++) {
            char movement = instruct.charAt(i);
            switch(movement) {
                case 'U':
                    if(location[0] > 0) {
                        location[0] -= 1;
                    }
                    break;
                case 'D':
                    if(location[0] < numPad.length - 1) {
                        location[0] += 1;
                    }
                    break;
                case 'L':
                    if(location[1] > 0) {
                        location[1] -= 1;
                    }
                    break;
                case 'R':
                    if(location[1] < numPad.length - 1) {
                        location[1] += 1;
                    }
                    break;
            }
        }
        return location;
    }
}