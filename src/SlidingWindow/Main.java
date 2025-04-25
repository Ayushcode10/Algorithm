package SlidingWindow;

public class Main {
    public static void main(String[] args){
       
    }

    public static int MaxSumSubArr(int[] arr, int k){
        int n = arr.length;
        if(n<k){
            //the size of the window can't be greater than
            //the array itself
            return -1;
        }

        int max = 0,  WindowSum = 0;
        //compute the sum of the elements in the window
        for (int i = 0; i < k; i++) {
            WindowSum += arr[i];
        }
        //update the max sum
        max = WindowSum;

        //slide the window
        for (int i = k; i <n ; i++) {

            //adding new element and removing the old element
            WindowSum += arr[i] - arr[i-k];
            max = Math.max(max, WindowSum);
        }
        return max;
    }

    //using only one loop
    public static int ans(int[] arr,int k){
        int n = arr.length;
        int i =0, j = 0;
        int windowSum = 0, max = Integer.MIN_VALUE;

        while (j<n){

            //add new element to the window
            windowSum += arr[j];
            //if window size is exactly k, process the result
            if(j-i+1 == k){
                max = Math.max(max,windowSum);
                //remove the left most element (shrink window)
                windowSum -= arr[i];
                i++;//move left pointer forward
            }
            //move the right pointer to expand window
            j++;
        }
        return max;
    }
    
}
