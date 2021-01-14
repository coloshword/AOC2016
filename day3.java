import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

// numCorrect2 is the answer to part 2

public class day3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day3.txt"));
        int numCorrect = 0;
        int numCorrect2 = 0;
        ArrayList<String> sides = new ArrayList<>();
        while (input.hasNext()) {
            sides.add(input.next());
        }
        // for part 1;
        for(int i = 0; i < sides.size(); i+= 3) {
            if(isTriangle(sides.get(i), sides.get(i+1), sides.get(i+2))) {
                numCorrect++;
            }
        }
        // for part 2:   // 0, 3, 6, 1, 4, 7 , 9, 12, 15
        // number of iterations for 3 vertical triangles
        for(int i = 0; i < sides.size() / 9; i++) {
            for(int x = 0; x < 3; x++) {
                if (isTriangle(sides.get(x + i * 9), sides.get(x + 3 + i * 9), sides.get(x + 6 + i * 9))) {
                    numCorrect2++;
                }
            }
        }
        System.out.println(numCorrect);
        System.out.println(numCorrect2);
    }
    public static boolean isTriangle(String s1, String s2, String s3) {
        int side1 = Integer.parseInt(s1);
        int side2 = Integer.parseInt(s2);
        int side3 = Integer.parseInt(s3);
        if(side1 + side2 <= side3) {
            return false;
        }
        if(side2 + side3 <= side1) {
            return false;
        }
        if(side1 + side3 <= side2) {
            return false;
        }
        return true;
    }
}