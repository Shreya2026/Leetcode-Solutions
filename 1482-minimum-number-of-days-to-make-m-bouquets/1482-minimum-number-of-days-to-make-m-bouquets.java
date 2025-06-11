class Solution {
    private boolean possible(int[] bloomDay,int m,int k,int day){
        int cnt=0;
        int booquet=0;
        int n=bloomDay.length;

        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){
                cnt++;
            }else{
                booquet+=(cnt/k);
                cnt=0;
            }
            
        }
        booquet+=(cnt/k);
        return (booquet>=m);
    }



    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n) return -1;

        int mini=Integer.MAX_VALUE,maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,bloomDay[i]);
            mini=Math.min(mini,bloomDay[i]);
        }

        int low=mini,high=maxi;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(possible(bloomDay,m,k,mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;

    }
}