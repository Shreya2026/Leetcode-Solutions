class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0;
        int n=cardPoints.length;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        int maxScore=lsum;
        int rsum=0;
        for(int i=0;i<k;i++){
            lsum-=cardPoints[k-1-i];
            rsum+=cardPoints[n-1-i];
            maxScore=Math.max(maxScore,lsum+rsum);
        }
        return maxScore;
    }
}