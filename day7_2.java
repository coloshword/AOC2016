import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


public class day7_2 {
    public static void main(String[] args) throws FileNotFoundException {
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
        ArrayList<String> canABA = new ArrayList<>();
        // no element can be true
        ArrayList<String> canBAB = new ArrayList<>();
        while(input.indexOf("[") > 0) {
            canABA.add(input.substring(0, input.indexOf("[")));
            canBAB.add(input.substring(input.indexOf("[") + 1, input.indexOf("]")));
            input = input.substring(input.indexOf("]") + 1, input.length());
        }
        canABA.add(input);
        System.out.println(canBAB);
        for(int i = 0; i < canBAB.size(); i++) {
            ArrayList<String> BABs = isBAB(canBAB.get(i));
            for(int k = 0; k < BABs.size();k++) {
                for(int j = 0; j < canABA.size(); j++) {
                    if(canABA.get(j).indexOf(BABs.get(k)) >= 0) {
                        return true;
                    }
                }
            }
        }
        return false;    
    }
    public static ArrayList<String> isBAB(String input) {
        // checks the BAB inputs, returns the empty String if none found, or returns the corresponding ABA sequence if found
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < input.length() - 2; i++) {
            char first = input.charAt(i);
            char second = input.charAt(i + 1);
            if(first == input.charAt(i+2) && second != first) {
                ans.add("" + second + first + second);
            }
        }
        return ans;
    }
}
