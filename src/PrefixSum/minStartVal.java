package PrefixSum;

public class minStartVal {
    public static void main(String[] args) {

    }
    public int minstartval(int[] nums){
        //intitalize minsum and sum
        int minSum = 0; // the minimum value in the prefix sum Misc.arr
        int sum = 0; // the sum of elements of the Misc.arr

        for(int n : nums){
            sum += n; //calculate prefix sum
            minSum = Math.min(minSum,sum); // calculate the min val. element in the prefix sum Misc.arr
        }
        //subtract the minsum from -1 to get the desired result
        return 1 - minSum;
    }
}
