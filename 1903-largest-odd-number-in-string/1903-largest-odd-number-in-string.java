class Solution {
    public String largestOddNumber(String num) {
        int end=-1;
        StringBuilder str=new StringBuilder();
        for(int i=num.length()-1;i>=0;i--){
            if(num.charAt(i) % 2 !=0){
                end=i+1;
                break;
            }
        }
        if(end!=-1){
            str.append(num.substring(0,end));
            return str.toString();
        }
        return ""; 
    }
}