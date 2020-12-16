import java.io.File;
import java.util.Scanner;
public class day1 {
    public static void main(String[] args) {
        try {
            File fh = new File("day1.txt");
            Scanner input = new Scanner(fh);
            String[] instructions = input.nextLine().split(", ");
            int[] currentCordinate = {0, 0}; // [N/S, E/W]
            int facing = 1;
//            facing = direction("R1".charAt(0), facing);
//            currentCordinate = getNewLocation(currentCordinate, "R2", facing);
//            facing = direction("L3".charAt(0), facing);
//            currentCordinate = getNewLocation(currentCordinate, "L3", facing);
//            for(int i : currentCordinate)
//                System.out.println(i);
            for(String i : instructions) {
                
            }
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
    public static int[] getNewLocation(int[] oldLocation, String instruct, int curPosition) {
        switch(curPosition) {
            case 1:
                oldLocation[0] = oldLocation[0] + Integer.parseInt("" + instruct.charAt(1));
                break;
            case 3:
                oldLocation[0] = oldLocation[0] - Integer.parseInt("" + instruct.charAt(1));
                break;
            case 2:
                oldLocation[1] = oldLocation[1] + Integer.parseInt("" + instruct.charAt(1));
                break;
            case 4:
                oldLocation[1] = oldLocation[1] - Integer.parseInt("" + instruct.charAt(1));
        }
        return oldLocation;
    }
    public static int direction(char turn, int curPosition) {
        // gets the new direction it is facing
        if(turn == 'R') {
            curPosition++;
        }
        else {
            curPosition--;
        }
        if(curPosition > 4) {
            curPosition = 1;
        }
        else if(curPosition < 1) {
            curPosition = 4;
        }
        return curPosition;
    }
}

/* the process :
Find the final location, compare it to the initial. How far left or right?
How far north or south?
Take the hypotenuse.
1, 2, 3, 4 for the direction faced.
 */