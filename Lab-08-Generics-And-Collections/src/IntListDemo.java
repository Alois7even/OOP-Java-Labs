import java.util.*;

public class IntListDemo {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(4, 9, 2, 15, 7, 1, 12, 8, 3, 10));

        int sum = 0;
        int max = nums.get(0);
        for (int n : nums) {
            sum += n;
            if (n > max) max = n;
        }

        List<Integer> reversed = new ArrayList<>(nums);
        Collections.reverse(reversed);                 // copy, so the original order is kept

        System.out.println("List: " + nums);
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max + " (check: " + Collections.max(nums) + ")");
        System.out.println("Reversed: " + reversed);
    }
}