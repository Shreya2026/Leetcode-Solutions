//BRUTE FORCE
/*class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing=0;
        int current=1;
        int i=0;

        while(missing<k){
            if(i<arr.length && arr[i]==current){
                i++;
            }else{
                missing++;
                if(missing==k) return current;
            }
            current++;
        }
        return -1;
    }
}*/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0,high=arr.length-1;
        while(low<=high){
        int mid=low+(high-low)/2;
        int missing=arr[mid]-(mid+1);
        if(missing<k) low=mid+1;
        else high=mid-1;
        }
        return k+low;
    }
}
