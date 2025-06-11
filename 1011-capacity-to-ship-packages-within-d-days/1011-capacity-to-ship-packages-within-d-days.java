class Solution {

    private int possible(int[] weights,int cap){
        int days=1,load=0;
        for(int i=0;i<weights.length;i++){
            if((load+weights[i])>cap){
                days++;
                load=weights[i];
            }else{
                load+=weights[i];
            }
        }
        return days;
    }


    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int sum=0,maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,weights[i]);
            sum+=weights[i];
        }

        int low=maxi,high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            int noOfDays=possible(weights,mid);

            if(noOfDays<=days){
                high=mid-1;
            }else{
                low=mid+1;
                }
        }
        return low;
    }
}