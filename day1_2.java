import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class day1_2 {
    public static void main(String[] args) {
        try {
            File fh = new File("day1.txt");
            Scanner input = new Scanner(fh);
            String[] instructions = input.nextLine().split(", ");
            int[] currentCoordinate = {0, 0};
            int[] placeHolder = {0, 0};
            int facing = 0;
            ArrayList<int[]> ans = new ArrayList<>();
            ans.add(placeHolder);
            for(String i : instructions) {
                facing = direction(i.charAt(0), facing);
                currentCoordinate = getNewLocations(ans, i, facing, currentCoordinate);
            }
            // search for duplicate
            boolean flag = false;
            for(int i = 0; i < ans.size(); i++) {
                for(int a = i + 1; a < ans.size(); a++) {
                    if(arrayIsEqual(ans.get(i), ans.get(a))) {
                        System.out.println("Answer!");
                        System.out.println(Math.abs(ans.get(i)[0]) + Math.abs(ans.get(i)[1]));
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
    public static boolean arrayIsEqual(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
    public static int[] getNewLocations(ArrayList<int[]> m, String instructions, int face, int[] currentLoc) {
        switch(face) {
            case 0:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    int[] add = new int[2];
                    add[0] = currentLoc[0] + 1;
                    add[1] = currentLoc[1];
                    currentLoc[0] += 1;
                    m.add(add);
                }
                break;
            case 1:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    int[] add = new int[2];
                    add[1] = currentLoc[1] + 1;
                    add[0] = currentLoc[0];
                    m.add(add);
                    currentLoc[1] += 1;
                }
                break;
            case 2:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    int[] add = new int[2];
                    add[0] = currentLoc[0] - 1;
                    add[1] = currentLoc[1];
                    currentLoc[0] -= 1;
                    m.add(add);
                }
                break;
            case 3:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    int[] add = new int[2];
                    add[1] = currentLoc[1] - 1;
                    add[0] = currentLoc[0];
                    m.add(add);
                    currentLoc[1] -= 1;
                }
                break;
        }
        return currentLoc;
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