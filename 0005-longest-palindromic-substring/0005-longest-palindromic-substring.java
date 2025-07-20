/*class Solution {
    public String longestPalindrome(String s) {
        String res="";
        int n = s.length();
        for(int i=0;i<n;i++){
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > res.length()) {
                res = sub;
            }
            }
        }
        return res;
    }

    private boolean isPalindrome(String str) {
    int l = 0, r = str.length() - 1;
    while (l < r) {
        if (str.charAt(l++) != str.charAt(r--)) return false;
    }
    return true;
}
}*/


class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;

    for (int i = 0; i < s.length(); i++) {
        int len1 = expandFromCenter(s, i, i);     // odd length
        int len2 = expandFromCenter(s, i, i + 1); // even length
        int len = Math.max(len1, len2);

        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
    }


    
    private int expandFromCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1; // final valid length
}
}