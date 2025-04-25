package Matrix2D;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(searchII(arr,7));
    }

    public static boolean search(int[][] arr, int target){
        int m = arr.length;
        int n = arr[0].length;
        int s = 0;
        int e = (m*n)-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid/n][mid%n] == target){
                return true;
            }
            if(arr[mid/n][mid%n] > target){
                e = m-1;
            }
            else{
                s = m+1;
            }
        }
        return false;
    }

    public static boolean searchII(int[][] arr, int target){
        int m = arr.length, n = arr[0].length;
        int rIndex = 0, cIndex = n-1;
        while(rIndex<m && cIndex >= 0){
            int element = arr[rIndex][cIndex];
            if(element == target){
                return true;
            } else if (element > target) {
                cIndex--;
            }
            else{
                rIndex++;
            }
        }
        return false;
    }
}
