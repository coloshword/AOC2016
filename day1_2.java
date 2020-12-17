import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
new strategy: Add all coordinates right next to each other, and check all odd
 */
public class day1_2 {
    public static void main(String[] args) {
        try {
            File fh = new File("day1.txt");
            Scanner input = new Scanner(fh);
            String[] instructions = input.nextLine().split(", ");
            ArrayList<Integer> ans = new ArrayList<Integer>();
            int[] currentCoordinate = {0, 0};
            int facing = 0;
            boolean flag = false;
            for(String i : instructions){
                ans.add(currentCoordinate[0]);
                ans.add(currentCoordinate[1]);
                facing = direction(i.charAt(0), facing);
                currentCoordinate = getNewLocation(currentCoordinate, i, facing);
                for(int j = 0; j < ans.size(); j+=2) {
                    if(currentCoordinate[0] == ans.get(j) && currentCoordinate[1] == ans.get(j + 1)) {
                        System.out.println("ans");
                        System.out.println(Arrays.toString(currentCoordinate));
                        System.out.println(Math.abs(currentCoordinate[0]) + Math.abs(currentCoordinate[1]));
                        flag = true;
                    }
                } // [0, 2, 0, 2] i = 0, i = 2
                if(flag) {
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
    public static int[] getNewLocation(int[] oldLocation, String instruct, int curPosition) {
        switch(curPosition) {
            case 0:
                oldLocation[0] = oldLocation[0] + Integer.parseInt(instruct.substring(1));
                break;
            case 2:
                oldLocation[0] = oldLocation[0] - Integer.parseInt(instruct.substring(1));
                break;
            case 1:
                oldLocation[1] = oldLocation[1] + Integer.parseInt(instruct.substring(1));
                break;
            case 3:
                oldLocation[1] = oldLocation[1] - Integer.parseInt(instruct.substring(1));
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
        if(curPosition >= 0) {
            curPosition %= 4;
        }
        else {
            curPosition += 4;
        }
        return curPosition;
    }
}