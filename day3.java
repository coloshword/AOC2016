import java.io.*;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day3.txt"));
        int numCorrect = 0;
        while (input.hasNext()) {
            if(isTriangle(input.next(), input.next(), input.next())) {
                numCorrect++;
            }
        }
        System.out.println(numCorrect);
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