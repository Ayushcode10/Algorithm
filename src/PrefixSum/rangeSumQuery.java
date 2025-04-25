package PrefixSum;

public class rangeSumQuery {


    //303
    private int[] prefix;
    public rangeSumQuery(int[] nums) {
        int sum = 0;
        int n = nums.length;
        prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
    }



    public int sumRange(int left, int right) {
        if(left == 0){
            return prefix[right];
        }
        else {
            return prefix[right] - prefix[left-1];
        }
    }


}
