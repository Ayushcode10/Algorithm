package Matrix2D;

public class RichestCustomer {


    public int maximumWealth(int[][] accounts){
        int maxWealth = 0;

        for(int[] customer: accounts){
                int wealth = 0;

                for (int bank : customer){
                    wealth += bank;
                }
            maxWealth = Math.max(maxWealth, wealth);
        }
        return maxWealth;
    }
}
