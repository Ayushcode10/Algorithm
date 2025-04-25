package Misc;

public class AlternatingGroups {
    public static void main(String[] args) {

    }

    public static int alternate(int[] arr){
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int p = arr[(i-1+n)%n];
            int c = arr[i];
            int nx = arr[(i+1)%n];

            if(p != c && c!= nx){
                count++;
            }
        }
        return count;
    }

}
