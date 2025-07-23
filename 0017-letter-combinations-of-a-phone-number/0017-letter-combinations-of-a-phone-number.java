class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] mapping = {
            "",     "",     "abc",  "def",  "ghi",  "jkl",
            "mno",  "pqrs", "tuv",  "wxyz"
        };

        backtrack(0, new StringBuilder(), digits, mapping, result);
        return result;
    }

    private void backtrack(int index, StringBuilder current, String digits, String[] mapping, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters=mapping[digits.charAt(index)-'0'];
        for (char ch : letters.toCharArray()){
            current.append(ch);
            backtrack(index + 1, current, digits, mapping, result);
            current.deleteCharAt(current.length() - 1);
        }

    }
}