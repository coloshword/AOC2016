import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class day9 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int length = 0;
        Path filePath = Paths.get("/Users/swirlycone/IdeaProjects/AdventOfCode2016/day9.txt");
        String text = Files.readString(filePath, StandardCharsets.US_ASCII);
        for(int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if(current == ' ' || current == '\n') {
                continue;
            }
            //System.out.println(i);
            if(current >= 'A' && current <= 'Z') {
                length++;
            }
            else {
                int endOfString = i + text.substring(i).indexOf(")");
                String compressed = text.substring(i + 1, endOfString);
                int startIndex = Integer.parseInt(compressed.substring(0, compressed.indexOf("x")));
                length += startIndex * Integer.parseInt(compressed.substring(compressed.indexOf("x") + 1));
                i = endOfString + startIndex;
            }
        }
        System.out.println(length);
    }
}
