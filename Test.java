import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        int[][] array = new int[2][];
        int[] a =  {1};
        int[] b = {1, 2, 3};
        array[0] = a;
        array[1] = b;
        System.out.println(Arrays.toString(array[0]));
        System.out.println(Arrays.toString(array[1]));

    }
}