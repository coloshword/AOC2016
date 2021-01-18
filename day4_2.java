import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class day4_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day4.txt"));
        while(input.hasNextLine()) {
            String line = input.nextLine();
            if(line.indexOf("[") > 0) {
                line = line.substring(0, line.indexOf("["));
            }
            int shift = Integer.parseInt(line.substring(line.length() - 3, line.length()));
            String searching = decrypt(line.substring(0, line.length() - 3), shift);
            if(searching.indexOf("object") > -1) {
                System.out.println(line.substring(line.length() - 3, line.length()));
            }
        }
    }

    public static String decrypt(String line, int shift) {
        shift = shift % 26;
        String ans = "";
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '-') {
                ans += ' ';
                continue;
            }
            int decrypted = (char) shift + line.charAt(i); 
            char letter = (char) decrypted;
            if(letter > 'z') {
                letter = (char) ((decrypted - 'z') + 'a' - 1);
            }
            ans += letter;
        }
        return ans;
    }
}