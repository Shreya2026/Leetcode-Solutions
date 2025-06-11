class Solution {
    private int findMax(int[] piles){
        int max=Integer.MAX_VALUE;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }
        return max;
    }


    private int calculateTotalHours(int hourly,int[] piles){
        int totalH=0;

        for(int i=0;i<piles.length;i++){
            totalH+=Math.ceil((double)piles[i]/(double)hourly);
        }
        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=findMax(piles);
        while(low<=high){
            int mid=low+(high-low)/2;

            int totalH=calculateTotalHours(mid,piles);

            if(totalH>h) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}