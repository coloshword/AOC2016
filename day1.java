import java.io.File;
import java.util.Scanner;
public class day1 {
    public static void main(String[] args) {
        try {
            File fh = new File("day1.txt");
            Scanner input = new Scanner(fh);
            String[] instructions = input.nextLine().split(", ");
            int[] currentCordinate = {0, 0}; // [N/S, E/W]
            int facing = 0;
            for(String i : instructions) {
                facing = direction(i.charAt(0), facing);
                currentCordinate = getNewLocation(currentCordinate, i, facing);
            }
            int ans = 0;
            for(int i : currentCordinate) {
                ans += Math.abs(i);
            }
            System.out.println(ans);
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
