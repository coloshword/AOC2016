// create a 2d-array, where the elements correspond to the num pad. If index is out of bounds, ignore
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
public class day2 {
    public static void main(String[] args) {
        try {
            int[][] numPad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            int[] keyLocation = {1, 1};
            String ans = "";
            File fh = new File("day2.txt");
            Scanner input = new Scanner(fh);
            while (input.hasNextLine()) {
                String instructions = input.nextLine();
                keyLocation = readInstructions(instructions, keyLocation);
                ans += numPad[keyLocation[0]][keyLocation[1]];
            }
            System.out.println(ans);
        }
        catch(Exception e) {
            System.out.println("Something went wrong");
        }
    }
    public static int[] readInstructions(String instruct, int[] start) {
        for(int i = 0; i < instruct.length(); i++) {
            char movement = instruct.charAt(i);
            switch(movement) {
                case 'U':
                    if(start[0] > 0)
                        start[0] -= 1;
                    break;
                case 'D':
                    if(start[0] < 2)
                        start[0] += 1;
                    break;
                case 'R':
                    if(start[1] < 2)
                        start[1] += 1;
                    break;
                case 'L':
                    if(start[1] > 0)
                        start[1] -= 1;
                    break;
            }
        }
        return start;
    }
}