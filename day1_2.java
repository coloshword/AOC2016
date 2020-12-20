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
                System.out.println("------------------");
                facing = direction(i.charAt(0), facing);
                currentCoordinate = getNewLocations(ans, i, facing, currentCoordinate);
            }
            //checking for duplicates
            System.out.println("***************************");
            for(int i = 0; i < ans.size(); i++) {
                System.out.println(Arrays.toString(ans.get(i)));
            }
//            for(int i = 0; i < ans.size(); i++) {
//                int[] output = ans.remove(i);
//                if(ans.contains(output)) {
//                    System.out.println(Arrays.toString(output));
//                    break;
//                }
//                else {
//                    ans.add(i, output);
//                }
//            }
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
        }
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
                    System.out.println(face);
                    System.out.println(Arrays.toString(add));
                }
                break;
            case 1:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    int[] add = new int[2];
                    add[1] = currentLoc[1] + 1;
                    add[0] = currentLoc[0];
                    m.add(add);
                    currentLoc[1] += 1;
                    System.out.println(face);
                    System.out.println(Arrays.toString(add));
                }
                break;
            case 2:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    int[] add = new int[2];
                    add[0] = currentLoc[0] - 1;
                    add[1] = currentLoc[1];
                    currentLoc[0] -= 1;
                    m.add(add);
                    System.out.println(face);
                    System.out.println(Arrays.toString(add));
                }
                break;
            case 3:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    int[] add = new int[2];
                    add[1] = currentLoc[1] - 1;
                    add[0] = currentLoc[0];
                    m.add(add);
                    currentLoc[1] -= 1;
                    System.out.println(face);
                    System.out.println(Arrays.toString(add));
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