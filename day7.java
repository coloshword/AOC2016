import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class day7 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("day7.txt"));
        int ans = 0;
        while(input.hasNextLine()) {
            String line = input.nextLine();
            if(isIP(line)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
    
    public static boolean isIP(String input) {
        // split bracket section and non bracket section
        // any one element has to be true
        ArrayList<String> canABBA = new ArrayList<>();
        // no element can be true
        ArrayList<String> notABBA = new ArrayList<>();
        while(input.indexOf("[") > 0) {
            canABBA.add(input.substring(0, input.indexOf("[")));
            notABBA.add(input.substring(input.indexOf("[") + 1, input.indexOf("]")));
            input = input.substring(input.indexOf("]") + 1, input.length());
        }
        canABBA.add(input);
        boolean con1 = false;
        boolean con2 = true;
        for(int i = 0; i < canABBA.size(); i++) {
            if(isABBA(canABBA.get(i))) {
                con1 = true;
            }
        }
        for(int i = 0; i < notABBA.size(); i++) {
            if(isABBA(notABBA.get(i))) {
                con2 = false;
            }
        }
        return con1 && con2;
    }

    public static boolean isABBA(String input) {
        for(int i = 0; i < input.length() - 3; i++) {
            if((input.charAt(i) == input.charAt(i + 3) && input.charAt(i+1) == input.charAt(i + 2)) && input.charAt(i) != input.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }
}