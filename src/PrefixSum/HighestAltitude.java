package PrefixSum;

public class HighestAltitude {
        public int largestAltitude(int[] gain) {
            //initializing maxalt-> in the given Misc.arr and curralt -> at which the biker is
            int maxAltitude = 0, currentAltitude = 0;

            //iterating over the whole array once
            for (int g : gain) {
                //in each iteration we add the elements using prefix sum
                currentAltitude += g;
                //compare the sum at each iteration to get the max value
                maxAltitude = Math.max(maxAltitude, currentAltitude);
            }

            //return the max value
            return maxAltitude;
        }

}
