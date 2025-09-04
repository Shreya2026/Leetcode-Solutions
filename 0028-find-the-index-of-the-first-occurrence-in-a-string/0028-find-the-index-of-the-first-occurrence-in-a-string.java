//Optimal (KMP Algorithm, O(n+m))
//Use prefix function (LPS array) to avoid re-checking characters.
/*
Time: O(n + m)
Space: O(m)
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) return 0;

        // Build LPS array
        int[] lps = new int[m];
        int len = 0;
        for (int i = 1; i < m; ) {
            if (needle.charAt(i) == needle.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        // KMP search
        int i = 0, j = 0;
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
                if (j == m) return i - j; // found
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }
}




/*
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) return i;
        }
        return -1;
    }
}
Time: O(n·m) worst case, but fewer allocations.
Space: O(1).
*/

/*
Brute Force (O(n·m))

Check every substring of haystack of length m (needle.length).

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
Time: O(n·m) (bad if strings are long).
Space: O(1).*/