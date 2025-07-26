class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result=new int[nums1.length];

        Stack<Integer> stack=new Stack<>();

        //nge for nums2
        int[] nge=new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums2[i]) stack.pop();
            if(stack.isEmpty()) nge[i]=-1;
            else nge[i]=stack.peek();
            stack.push(nums2[i]);
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],nge[i]);
        }

        for(int i=0;i<nums1.length;i++){
            result[i]=map.get(nums1[i]);
        }
        return result;

    }
}