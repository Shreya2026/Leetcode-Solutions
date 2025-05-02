//my solution tie with striver just striver's better in readeability
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int maxOnes=0,count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) count++;
            else{
                if(count>maxOnes) maxOnes=count;
                count=0;
        }
        }
        if(count>maxOnes) maxOnes=count;
        return maxOnes;
    }
}


//Striver Solution
/*
import java.util.*;
public class Main {
    static int findMaxConsecutiveOnes(int nums[]) {
        int cnt = 0;
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }

            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }
    public static void main(String args[]) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println("The maximum  consecutive 1's are " + ans);
    }
}
*/