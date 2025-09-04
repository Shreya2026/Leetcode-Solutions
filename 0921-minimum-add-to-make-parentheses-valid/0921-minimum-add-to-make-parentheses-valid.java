/*
Better / Optimal (Greedy with Counters)

We don’t need a stack — just keep track of:

open → number of unmatched '('

add → number of unmatched ')'
*/
/*
Time: O(n)
Space: O(1)
*/
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, add = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else { // ')'
                if (open > 0) {
                    open--; // match with previous '('
                } else {
                    add++;  // need an extra '('
                }
            }
        }
        
        return add + open;
    }
}


/*
Brute Force (Using Stack)

Push ( to stack, pop when matching ) is found.
Anything left unmatched → needs fixing.

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int add = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // ')'
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    add++; // extra ')'
                }
            }
        }
        
        return add + stack.size();
    }
}
Time: O(n)
Space: O(n)*/