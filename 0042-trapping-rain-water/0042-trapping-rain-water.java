//naive approach nested loop--O(n^2)

//better approach-could be considered good in an interview
/*
class Solution {
    public int trap(int[] height) {
        int[] leftMax=new int[height.length];
        int[] rightMax=new int[height.length];

        leftMax[0]=height[0];
        rightMax[height.length-1]=height[height.length-1];

        for(int i=1;i<height.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }

        for(int i=height.length-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }

        int ans=0;
        for(int i=0;i<height.length;i++){
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;

    }
}

*/

//optimal approach

class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int lmax=0,rmax=0;
        int l=0,r=n-1;
        int ans=0;

        while(l<r){
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);

            if(lmax<rmax){
                ans+=lmax-height[l];
                l++;
            }else{
                ans+=rmax-height[r];
                r--;
            }
        }
        return ans;
    }
}