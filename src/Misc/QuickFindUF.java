package Misc;

public class QuickFindUF {

    /*
        this is the quick find (eager approach)
        there's an int Misc.arr id of size N

# find
        numbers -- 0 1 2 3 4 5
        id ------- 0 0 1 1 2 2

        this means connected numbers are => {0,1} {2,3}, {4,5}
        p and q are connected iff they have the same id

# union
        to merge components containing p and q, change all the entries whose id is equal
        to id[p] to id[q]

        for eg if we are connecting 1 and 2 then we'll change the id of 1 and 0 to 1 so that
        they get connected and form a set {0,1,2,3}
        numbers -- 0 1 2 3 4 5
        id  ------ 1 1 1 1 2 2
    */
    private int[] id;

    //constructor
    public QuickFindUF(int N){
        //set id to each obj to itself (N array accesses)
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // check whether p and q are in the same component (2 array accesses)
    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        //change all the entries with id[p] to id[q]
        //(at most 2N + 2 array accesses)
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid){
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        QuickFindUF a = new QuickFindUF(5);
        a.union(0,1);
        a.union(1,2);
        a.union(3,2);
        a.union(4,3);

        System.out.println(a.connected(0,1));
        System.out.println(a.connected(0,2));
        System.out.println(a.connected(0,3));
        System.out.println(a.connected(0,4));
    }
}
