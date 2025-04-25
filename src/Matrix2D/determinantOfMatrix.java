package Matrix2D;

public class determinantOfMatrix {
    public static int det(int[][] mat, int n){
        //base cases
        if(n==1) return mat[0][0];
        if(n==2) return mat[0][0]*mat[1][1] - mat[0][1]*mat[1][0];
        int det = 0; //initialise determinant
        int sign = 1;//to use sign


        for (int j = 0; j < n; j++) {
            //get a minor matrix(cofactor) for each element
            //in the first row
            int[][] minor = getMinor(mat,n,j);
            //calculate det and call the func. recursively
            det += sign*mat[0][j]*det(mat,n-1);
            //alternate signs
            sign = -sign;
        }
        return det;
    }


    //function to get minor(cofactor) for an element
    public static int[][] getMinor(int[][] mat, int n, int col){
        //make a minor mat, to store elements
        int[][] minor = new int[n-1][n-1];
        int r = 0; // track row
        //skip the first row
        for (int i = 1; i < n; i++) {
            int c = 0; //track column
            for (int j = 0; j < n; j++) {
                if(j==col) continue; //skip the column that needs to be removed
                minor[r][c] = mat[i][j];
                c++;
            }
            r++;
        }
        return minor;
    }

}
