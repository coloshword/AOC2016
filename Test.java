import java.util.ArrayList;
import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        ArrayList<int[]> ans = new ArrayList<int[]>();
        int[] a = {1, 2};
        int[] b = {2, 3};
        int[] c = {2, 3};
        ans.add(a);
        ans.add(b);
        ans.add(c);
        int[] removed = ans.remove(0);
        System.out.println(Arrays.toString(ans));
        ans.add(0, removed);
        System.out.println((ans));

    }
}