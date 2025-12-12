class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < m; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        // count how many characters currently match (need[i] == window[i])
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (need[i] == window[i]) matches++;
        }

        if (matches == 26) return true;

        for (int right = m; right < n; right++) {
            int inIdx = s2.charAt(right) - 'a';
            int outIdx = s2.charAt(right - m) - 'a';

            // include new char at 'right'
            // before changing window[inIdx], check if it matched and update matches
            if (window[inIdx] == need[inIdx]) matches--;
            window[inIdx]++;
            if (window[inIdx] == need[inIdx]) matches++;

            // remove char at 'right - m'
            if (window[outIdx] == need[outIdx]) matches--;
            window[outIdx]--;
            if (window[outIdx] == need[outIdx]) matches++;

            if (matches == 26) return true;
        }

        return false;
    }
}
