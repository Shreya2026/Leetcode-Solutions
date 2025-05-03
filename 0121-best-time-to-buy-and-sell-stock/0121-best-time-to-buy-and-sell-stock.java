
//BRUTE FORCE
// T.C -O(n^2) , S.C-O(1)
/*class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]>prices[i]){
                    maxProfit=Math.max(prices[j]-prices[i],maxProfit);
                }
            }
        }
        return maxProfit;
    }
}*/

//OPTIMAL SOLUTION
// T.C -O(n) , S.C-O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            mini=Math.min(mini,prices[i]);
            maxProfit=Math.max(prices[i]-mini,maxProfit);
           
        }
        return maxProfit;
    }
}
