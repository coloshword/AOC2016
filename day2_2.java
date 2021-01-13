import java.io.File;
import java.util.Scanner;

// start index is 2
public class day2_2 {
    public static void main(String[] args) {
        try {
            File fh = new File("day2.txt");
            Scanner input = new Scanner(fh);
            char[][] keypad = {{'0','0','1','0','0'}, {'0','2','3','4','0'}, {'5', '6', '7', '8', '9'}, {'0','A', 'B', 'C', '0'}, {'0', '0', 'D', '0', '0'}};
            int[] keyLocation = {2, 0};
            String ans = "";
            while (input.hasNextLine()) {
                String instructions = input.nextLine();
                keyLocation = readInstructions(instructions, keyLocation, keypad);
                ans += keypad[keyLocation[0]][keyLocation[1]];
            }
            System.out.println(ans);
        }
        catch(Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static int[] readInstructions(String instruct, int[] start, char[][] keyPad) {
        for(int i = 0; i < instruct.length(); i++) {
            char movement = instruct.charAt(i);
            switch(movement) {
                case 'U':
                    if(start[0] > 0 && keyPad[start[0] - 1][start[1]] != '0')
                        start[0] -= 1;
                    break;
                case 'D':
                    if(start[0] < 4 && keyPad[start[0] + 1][start[1]] != '0')
                        start[0] += 1;
                    break;
                case 'R':
                    if(start[1] < 4 && keyPad[start[0]][start[1] + 1] != '0')
                        start[1] += 1;
                    break;
                case 'L':
                    if(start[1] > 0 && keyPad[start[0]][start[1] - 1] != '0')
                        start[1] -= 1;
                    break;
            }
        }
        return start;
    }
}