package April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {

    }
//    public static List<Integer> largestDivisibleSubset(int[] arr){
//
//    }
    private static void backtrack(int[] arr, int i, List<Integer> temp,List<List<Integer>> res){
        if(i == arr.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[i]);
        backtrack(arr,i+1,temp,res);
        temp.remove(temp.size()-1);
        backtrack(arr,i+1,temp,res);
    }

//    private static boolean isDivisible(List<Integer> a){
//
//    }
}
