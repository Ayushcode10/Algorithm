package April;

import java.util.Arrays;

public class segment {
    static int[] arr;
    static int[] st;

    void build(int i,int s, int e){
        if(s==e){
            st[i] = arr[s];
            return;
        }
        int mid = (s+e)/2;
        build(2*i + 1, s, mid);
        build(2*i + 2, mid + 1, e);
        st[i] = st[2*i+1]+st[2*i+2];
    }

    int query(int i, int l, int r, int ql, int qr){
        //completely overlap
        if(ql<=l && r<=qr){
            return st[i];
        }
        //no overlap
        if(r<ql || l>qr){
            return 0;
        }
        //partial overlapping
        int mid = (l + r)/2;
        int left = query(2*i+1, l, mid, ql,qr);
        int right = query(2*i+2, mid+1, r, ql,qr);
        return left + right;
    }

    void update(int i, int l, int r, int pos, int nv){
        if(l == r){
            st[i] = nv;
            return;
        }
        int mid = (l+r)/2;
        if(pos<=mid){
            update(2*i+1,l,mid,pos,nv);
        }else {
            update(2*i+2,mid+1,r,pos,nv);
        }
        st[i] = st[2*i+1] + st[2*i+2];
    }

    public static void main(String[] args) {
        segment tree = new segment();
        arr = new int[]{1,2,3,4,5,6,7,8};
        int n = arr.length;
        st = new int[4*n];
        tree.build(0,0,n-1);
        System.out.println(Arrays.toString(st));
        tree.update(0,0,n-1,4,14);
        System.out.println(tree.query(0,0,n-1,2,6));
    }
}
