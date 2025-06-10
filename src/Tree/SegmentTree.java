package Tree;

import java.util.Arrays;
import java.util.Scanner;

public class SegmentTree{
    static int[] arr;
    static int[] st;

    void buildTree(int idx, int l, int r){
        if(l == r){
            st[idx] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        buildTree(2*idx + 1, l, mid);
        buildTree(2*idx + 2, mid+1 , r);
        st[idx] = st[2*idx + 1] + st[2*idx + 2];
    }

    int getSum(int idx, int l, int r, int ql, int qr){
        //completely overlapping
        if(ql <= l && r <= qr){
            return st[idx];
        }
        //no overlapping
        if(r < ql || l > qr) return 0;// returns default value;

        //partial overlapping
        int mid = l + (r-l)/2;
        int left = getSum(2*idx + 1,l, mid, ql, qr);
        int right = getSum(2*idx + 2,mid + 1, r, ql, qr);
        return left+right;
    }

    void update(int idx, int l, int r, int pos, int nv){
        //at leaf
        if(l == r){
            st[idx] = nv; // update leaf
            return;
        }

        int mid = l + (r-l)/2;
        if(pos <= mid) {
            update(2 * idx + 1, l, mid, pos, nv);
        }else{
            update(2*idx + 2, mid + 1, r, pos, nv);
        }
        st[idx] = st[2*idx + 1] + st[2*idx + 2];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SegmentTree tree = new SegmentTree();
        System.out.println("enter size of the input array:");
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("enter " + i + "th element");
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter range left ");
        int ql = sc.nextInt();
        System.out.println("Enter range right ");
        int qr = sc.nextInt();

        st = new int[4*n];
        tree.buildTree(0,0,n-1);
        System.out.println(Arrays.toString(st));
        System.out.println(tree.getSum(0,0,n-1,ql,qr));
        tree.update(0,0,n-1,3,14);
        System.out.println(Arrays.toString(st));
        System.out.println(tree.getSum(0,0,n-1,ql,qr));
    }
}
