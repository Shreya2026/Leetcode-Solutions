/*class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0) return 0;
          StringBuilder sb=new StringBuilder();
          int sign=1;
          int i=0;
          if(s.charAt(i)=='+' || s.charAt(i)=='-'){
            if(s.charAt(i)=='-'){
                sign=-1;
                i++;
            }
          }
          while(i<s.length() && Character.isDigit(s.charAt(i))){
            sb.append(s.charAt(i));
            i++;
          }
          if(sb.length()==0) return 0;

          try{
            return sign*Integer.parseInt(sb.toString());
          }catch(NumberFormatException e){
            return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
          }
    }
}*/

/*
public class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int i = 0, sign = 1;
        long result = 0;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // clamp if overflow
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * result);
    }
}
*/



class Solution {
    public int myAtoi(String s) {
    int i=0,sign=1;
    long result=0;
    while(i<s.length()&& s.charAt(i)==' ') i++;
    if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            result = result * 10 + (s.charAt(i) - '0');
            if(sign*result<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else if(sign*result>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i++;
        }
        return (int) (sign*result);
    }
}