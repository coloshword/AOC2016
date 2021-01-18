import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;


public class salesman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("yaying.txt"));
        HashMap<String, Integer> map = new HashMap<>();
        while(input.hasNextLine()) {
            String line = input.nextLine();
            String firstCity = line.substring(0, line.indexOf(" to "));
            String secondCity = line.substring(line.indexOf("to") + 3, line.indexOf(" = "));
            int cost = Integer.parseInt(line.substring(line.indexOf("=") + 2, line.length()));
            map.put(firstCity + " " + secondCity, cost);
            map.put(secondCity + " " + firstCity, cost);
        }
        String[] cities = {"Faerun", "Norrath", "Tristram", "AlphaCentauri", "Arbre", "Snowdin", "Tambi", "Straylight"};
        String locations = "ABCDEFGH";
        ArrayList<String> paths = new ArrayList<>();
        for(int i = 0; i < locations.length(); i++) {
            paths.add("" + locations.charAt(i));
        }
        while(paths.get(0).length() != locations.length()) {
            ArrayList<String> toAdd = new ArrayList<>();
            for(int i = 0; i < paths.size(); i++) {
                String base = paths.get(i);
                String locationsCopy = locations;
                for(int j = 0; j < base.length(); j++) {
                    locationsCopy = locationsCopy.replace(base.charAt(j) + "", "");
                }
                for(int k = 0; k < locationsCopy.length(); k++) {
                    toAdd.add(base + locationsCopy.charAt(k));
                }
            }
            paths.clear();
            combineArrayLists(paths, toAdd);
        }
        //BH: Norrath to StrayLight
        //all paths created, now evaluates the cost of each
        //BHGCEFAD
        int min = 1000000000;
        for(int k = 0; k < paths.size(); k++) {
            String currentPath = paths.get(k);
            int cost = 0;
            String at = currentPath.charAt(0) + "";
            for(int i = 1; i < currentPath.length(); i++) {
                String to = currentPath.charAt(i) + "";
                String cityA = cities[locations.indexOf(at)];
                String cityB = cities[locations.indexOf(to)];
                //System.out.println(cityA + " to " + cityB);
                cost += map.get(cityA + " " + cityB);
                at = to;
            }
            if(cost < min) {
                min = cost;
            }
        }
        System.out.println(min);
    }

    public static void combineArrayLists(ArrayList<String> keep, ArrayList<String> old) {
        for(int i = 0; i < old.size(); i++) {
            keep.add(old.get(i));
        }
    }
}