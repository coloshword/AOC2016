import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;


public class salesman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("yaying.txt"));
        String locations = "ABCDEFGH";
        // ArrayList<String> paths = new ArrayList<>();
        // for(int i = 0; i < locations.length(); i++) {
        //     paths.add("" + locations.charAt(i));
        // }
        // while(paths.get(paths.size() - 1).length() != locations.length()) {
        //     ArrayList<String> toAdd = new ArrayList<>();
        //     for(int i = 0; i < paths.size(); i++) {
        //         String base = paths.get(i);
        //         String locationsCopy = locations;
        //         for(int j = 0; j < base.length(); j++) {
        //             locationsCopy = locationsCopy.replace(base.charAt(j) + "", "");
        //         }
        //         for(int k = 0; k < locationsCopy.length(); k++) {
        //             toAdd.add(base + locationsCopy.charAt(k));
        //         }
        //     }
        //     paths.clear();
        //     combineArrayLists(paths, toAdd);
        // }
        // System.out.println(paths.size());
    }

    public static void combineArrayLists(ArrayList<String> keep, ArrayList<String> old) {
        for(int i = 0; i < old.size(); i++) {
            keep.add(old.get(i));
        }
    }
}