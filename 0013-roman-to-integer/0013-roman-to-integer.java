/*class Solution {
    public int romanToInt(String s) {
        int sum=0;
        int i=0;
        while(i<s.length()){
            char current=s.charAt(i);
            int currentVal=value(current);

            if(i+1<s.length()){
                 char next=s.charAt(i+1);
                 int nextVal=value(next);

                 if(currentVal<nextVal){
                    sum+=(nextVal-currentVal);
                    i+=2;
                    continue;
                 }
            }
            sum+=currentVal;
            i++;
            
        }
        return sum;
    }

    private int value(char c){
        switch(c){
            case 'I' : return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}*/

/*
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = roman.get(s.charAt(i));

            // Lookahead for subtraction case
            if (i < s.length() - 1 && val < roman.get(s.charAt(i + 1))) {
                result -= val;
            } else {
                result += val;
            }
        }

        return result;
    }
}*/

public class Solution {
    public int romanToInt(String s) {
        int sum=0;
        int prev=getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int current=getValue(s.charAt(i));
            if (prev < current) {
                sum -= prev;
            } else {
                sum += prev;
            }
            prev = current;
        }
        sum+=prev;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
