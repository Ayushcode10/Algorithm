package BinarySearch;

public class MaxScoreSplit {

    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore(s));
    }
    public static int maxScore(String s){
        int totalOnes = 0;
        int maxScore = Integer.MIN_VALUE;

        for(char c : s.toCharArray()){
            if(c == '1'){
                totalOnes++;
            }
        }
        int leftZeros = 0;
        int rightOnes = totalOnes;

        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == '0'){
                leftZeros++;
            }
            else{
                rightOnes--;
            }
            maxScore = Math.max(maxScore, rightOnes+ leftZeros);
        }

        return maxScore;
    }
}
