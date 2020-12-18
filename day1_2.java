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
            int[] currentCoordinate = {0, 0}; // [N/S, E/W]
            int facing = 0;
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(0);
            ans.add(0);
            for(String i : instructions) {
                facing = direction(i.charAt(0), facing);
                currentCoordinate = getNewLocations(ans, i, facing, currentCoordinate);
                System.out.println(ans);
            }
            // checking
            boolean flag = false;
            for(int i = 0; i < ans.size(); i+=2) {
                int x = ans.get(i);
                int y = ans.get(i + 1);
                for(int a = i + 2; a < ans.size(); a+=2) {
                    if(x == ans.get(a) && y == ans.get(a + 1)) {
                        System.out.println("ans");
                        System.out.printf("(%d, %d)" ,ans.get(a), ans.get(a+1));
                        System.out.println();
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
    public static int[] getNewLocations(ArrayList<Integer> m, String instructions, int face, int[] currentLoc) {
        switch(face) {
            case 0:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    currentLoc[0] = currentLoc[0] + 1;
                    m.add(currentLoc[0]);
                    m.add(currentLoc[1]);
                    break;
                }
            case 2:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    currentLoc[0] = currentLoc[0] - 1;
                    m.add(currentLoc[0]);
                    m.add(currentLoc[1]);
                    break;
                }
            case 3:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    currentLoc[1] = currentLoc[1] + 1;
                    m.add(currentLoc[0]);
                    m.add(currentLoc[1]);
                    break;
                }
            case 4:
                for(int i = 0; i < Integer.parseInt(instructions.substring(1)); i++) {
                    currentLoc[1] = currentLoc[1] - 1;
                    m.add(currentLoc[0]);
                    m.add(currentLoc[1]);
                    break;
                }
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