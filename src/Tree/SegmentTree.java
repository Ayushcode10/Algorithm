package Tree;

import java.util.Scanner;

public class SegmentTree {
    int n;
    int[] arr = new int[n];
    int[] st = new int[4*n];
    void BuildTree(int start, int end, int idx){
        if(start == end){
            st[idx] = arr[start];
            return;
        }
        int mid = start + (end - start)/2;
        BuildTree(start, mid, (2*idx)+1);
        BuildTree(mid + 1, end, (2*idx)+2);
        st[idx] = Math.max(st[(2*idx)+1],st[(2*idx)+2]);
    }

    int getMax(int low, int high, int l, int r, int idx){
        if(low <= l && r<= high){
            return st[idx]; //completely inside
        }
        if(r < low || l > high){ //completely outside
            return Integer.MIN_VALUE;
        }
        int mid = l + (r - l) / 2;
        int left = getMax(low, high, l, mid, (2 * idx) + 1);
        int right = getMax(low, high, mid + 1, r, (2 * idx) + 2);
        return Math.max(left,right);

    }

    void update(int idx, int low, int high, int i, int nv){
        if(high == low){
            arr[i] = nv;
            arr[idx] = nv;
            return;
        }
        int mid = low + (high-low)/2;

        if(i >= low && i <=mid){
            update((2*idx)+1,low,mid,i,nv);
        }
        else{
            update((2*idx)+2,mid+1,high,i,nv);
        }
        st[idx] = Math.max(st[(2 * idx) + 1], st[(2 * idx) + 2]);
    }
    public static void main(String[] args) {
        SegmentTree tree = new SegmentTree();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree.arr = new int[] {1,3,2,7,9,11};
        n = 6;
        tree.BuildTree(0,n-1,0);

        System.out.println(tree.getMax(1,4,0,n-1,0));
    }
}
