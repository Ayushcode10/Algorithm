package NumberTheory;

public class PrimalityTest
{
    public static void main(String[] args) {
        System.out.println(isPrimeBF(4));
    }
    //naive approach TC-->O(N)
    private static boolean isPrimeBF(int n){
        if(n==1) return false;
        for (int i = 2; i < n; i++) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }


    //better approach -> O(sqrt(N))
    private static boolean better(int n){
        if(n==1) return false;
        if(n==2) return true;
        if(n%2==0) return false;

        for (int i = 3; i*i<n; i++) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

}
