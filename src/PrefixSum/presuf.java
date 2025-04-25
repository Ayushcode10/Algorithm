package PrefixSum;

public class presuf {

    public void prefixSuffixSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            suffix[n - i - 1] = suffix[n - i] + nums[n - i - 1];
        }
        System.out.println("Prefix Sum: " + java.util.Arrays.toString(prefix));
        System.out.println("Suffix Sum: " + java.util.Arrays.toString(suffix));
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new presuf().prefixSuffixSum(nums);
    }

}
