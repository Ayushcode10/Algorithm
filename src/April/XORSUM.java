package April;

import java.util.ArrayList;
import java.util.List;

public class XORSUM {
    public static void main(String[] args) {
        int[] arr = {1,3};
        System.out.println(xorBIT(arr));

    }



//    this is my brute force solution
    // this creates all the possible subsets of the given array
    //then iterates over all the subsets and add all the xors
    // then returns the sum
    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        subset(res, temp,nums,0);
        for(int i = 0;i<res.size();i++){
            int xor = 0;
            List<Integer> sub = res.get(i);
            for(int j = 0;j<sub.size();j++){
                xor ^= sub.get(j);
            }
            sum += xor;
        }
        return sum;
    }

    private static void subset(List<List<Integer>> res, List<Integer> temp, int[] arr, int i){
        if(i == arr.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        subset(res,temp,arr,i+1);
        temp.add(arr[i]);
        subset(res,temp,arr,i+1);
        temp.remove(temp.size()-1);
    }

    //optimized backtracking

    public static int optimizedXor(int[] arr){
        return XORSum(arr,0,0);
    }
    private static int XORSum(int[] arr, int i, int currXor){
        // Return currentXOR when all elements in nums are already considered
        if (i == arr.length) return currXor;

        // Calculate sum of subset xor with current element
        int withElement = XORSum(arr, i + 1, currXor ^ arr[i]);

        // Calculate sum of subset xor without current element
        int withoutElement = XORSum(arr, i + 1, currXor);

        // Return sum of xor totals
        return withElement + withoutElement;
    }


    //bitwise manipulation
    public static int xorBIT(int[] nums) {
        int result = 0;
        // Capture each bit that is set in any of the elements
        for (int num : nums) {
            result |= num;
        }
        // Multiply by the number of subset XOR totals that will have each bit set
        return result << (nums.length - 1);
    }

}
