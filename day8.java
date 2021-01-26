import java.util.Scanner;
import java.io.*;

// 1 == on, 0 == off
public class day8 {
    public static void main(String[] args) throws FileNotFoundException{
        int[][] grid = new int[6][50];
        Scanner input = new Scanner(new File("day8.txt"));
        while(input.hasNextLine()) {
            String instruct = input.nextLine();
            readInstructions(instruct.split(" "), grid);
            //display(grid);
        }
        // at the end 
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        display2(grid);
        System.out.println(ans);
    }
    
    public static void readInstructions(String[] inst, int[][] grid) {
        switch(inst[0]) {
            case "rect":
                rect(inst, grid);
                break;
            case "rotate":
                if(inst[1].equals("row")) {
                    rotateRow(inst, grid);
                }
                else {
                    rotateColumn(inst, grid);
                }
                break;
        }
    }
    // column by row 
    public static void rect(String[] inst, int[][] grid) {
        String on = inst[1];
        int row = Integer.parseInt(on.substring(0, on.indexOf("x")));
        int column = Integer.parseInt(on.substring(on.indexOf("x") + 1));
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                grid[j][i] = 1;
            }
        }
    }

    public static void rotateRow(String[] inst, int[][] grid) {
        String line = inst[2];
        int rowToMove = Integer.parseInt(line.substring(line.indexOf("=") + 1));
        int moveBy = Integer.parseInt(inst[4]);
        int[] newRow = new int[50];
        for(int i = 0; i < 50; i++) {
            int swapIndex = i + moveBy;
            if(swapIndex < 50) {
                newRow[swapIndex] = grid[rowToMove][i];
            }
            else {
                newRow[swapIndex - 50] = grid[rowToMove][i];
            }
        }
        grid[rowToMove] = newRow;
    }

    public static void rotateColumn(String[] inst, int[][] grid) {
        String line = inst[2];
        int columnToMove = Integer.parseInt(line.substring(line.indexOf("=") + 1));
        int moveBy = Integer.parseInt(inst[4]);
        int[] newColumn = new int[6];
        for(int i = 0; i < 6; i++) {
            int swapIndex = i + moveBy;
            if(swapIndex < 6) {
                newColumn[swapIndex] = grid[i][columnToMove];
            }
            else {
                newColumn[swapIndex - 6] = grid[i][columnToMove];
            }
        }
        // change grid values
        for(int i = 0; i < 6; i++) {
            grid[i][columnToMove] = newColumn[i];
        }
    }

    public static void display(int[][] grid) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 20; j++) {
                System.out.print("|" + grid[i][j]);
            }
            System.out.print("|\n");
        }
        System.out.println("--------------------------");
    }

    public static void display2(int[][] grid) {
        for(int i = 0; i < 10; i++) {
            for(int row = 0; row < 6; row++) {
                for(int column = 5 * i; column < 5 * i + 5; column++) {
                    if(grid[row][column] == 1) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            System.out.println("-----------------");
        }
    }
}
