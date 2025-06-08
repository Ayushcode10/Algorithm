package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,5,3,3,4};
        int[] s = {4,2,1,2,1,3};
        System.out.println(findContentChildren(g,s));
    }
    private static int findContentChildren(int[] g, int[] s){
        //why sort?
        //so that we can match satisfy the least greedy child with the closest
        //size of the cookie and maximise the satisfaction count
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j =0;
        while(i<g.length && j<s.length){
            if(s[j]>=g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}
