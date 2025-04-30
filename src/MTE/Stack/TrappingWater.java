package MTE.Stack;

public class TrappingWater {
    /*Algo
        1.use two pointers, left = 0, right = n-1;
        2.track leftmax and rightmax
        3. while left < right
            -if height[left] >= leftmax, update leftmax
            -else -> water = leftmax - height[left]
            -move left forward (left++)
       4. else
            if height[right] > rightmax ->update rightmax
            -else-> water = rightmax - height[right]
            -move right--
   */
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    private static int trap(int[] arr){
        int n = arr.length;
        int left = 0, right = n-1;
        int lmax = 0, rmax = 0, water = 0;
        while(left < right){
            if(arr[left]<arr[right]){
                if(arr[left] >= lmax){
                    lmax = arr[left];
                }
                else{
                    water += lmax - arr[left];
                }
                    left++;
            }
            else{
                if(arr[right]>rmax){
                    rmax = arr[right];
                }
                else{
                    water += rmax  - arr[right];
                }
                right--;
            }
        }
        return water;
    }
}
