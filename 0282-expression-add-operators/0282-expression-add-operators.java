import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> res, String num, int target,
                           int index, long eval, long prev,
                           StringBuilder expr) {

        if (index == num.length()) {
            if (eval == target) {
                res.add(expr.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // avoid numbers with leading zero
            if (i != index && num.charAt(index) == '0') break;

            long curr = Long.parseLong(num.substring(index, i + 1));
            int len = expr.length();

            if (index == 0) {
                // first number, no operator
                expr.append(curr);
                backtrack(res, num, target, i + 1, curr, curr, expr);
                expr.setLength(len);
            } else {
                // '+'
                expr.append('+').append(curr);
                backtrack(res, num, target, i + 1, eval + curr, curr, expr);
                expr.setLength(len);

                // '-'
                expr.append('-').append(curr);
                backtrack(res, num, target, i + 1, eval - curr, -curr, expr);
                expr.setLength(len);

                // '*'
                expr.append('*').append(curr);
                backtrack(res, num, target, i + 1,
                        eval - prev + prev * curr,
                        prev * curr,
                        expr);
                expr.setLength(len);
            }
        }
    }
}


/*
Type	Complexity
Time	O(4ⁿ) (worst case, branching on operators)
Space	O(n) recursion depth
*/