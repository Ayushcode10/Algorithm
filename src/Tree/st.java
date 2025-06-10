package Tree;

import java.util.Arrays;

public class st {
    static int[] arr;
    static int[] st;

    void build(int i, int l , int r){
        if(l == r) {
            st[i] = arr[l];
            return;
        }
        int mid = l +(r-l)/2;
        build(i*2 + 1, l, mid);
        build(i*2 + 2, mid+1, r);
        st[i] = st[i*2 +1] + st[i*2 + 2];
    }

    int query(int i, int l, int r, int ql, int qr){
        //completely overlapping
        if(ql <= l && r <= qr){
            return st[i];
        }
        //completely outside
        if(r < ql || l > qr) return 0; // return default value
        //partial overlapping
        int mid = l + (r-l)/2;
        int left = query(2*i +1, l, mid, ql, qr);
        int right = query(2*i +2, mid+1, r, ql, qr);
        return left + right;
    }

    //update
    void update(int i, int l, int r, int pos, int nv){
        //leaf node
        if(l == r) {
            st[i] = nv;
            return;
        }
        int mid = l + (r-l)/2;
        if(pos <= mid){
            update(2*i + 1, l, mid, pos, nv);
        }else{
            update(2*i+2, mid + 1, r, pos,nv);
        }
        st[i] = st[2*i + 1] + st[2*i +2];
    }
    public static void main(String[] args) {
        st tree = new st();
        arr = new int[]{3,8,7,6,-2,-8,4,9};
        int n = arr.length;
        st = new int[4*n];
        tree.build(0,0,n-1);
        System.out.println(Arrays.toString(st));
        System.out.println(tree.query(0,0,n-1,2,6));
        tree.update(0,0,n-1,3,14);
        System.out.println(Arrays.toString(st));
        System.out.println(tree.query(0,0,n-1,2,6));
    }
}
