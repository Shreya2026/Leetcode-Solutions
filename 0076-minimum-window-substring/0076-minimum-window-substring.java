class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] tFreq = new int[128]; // Assuming ASCII
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int[] windowFreq = new int[128];
        int have = 0, need = t.length();
         int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;

         for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Count character in window
            if (tFreq[c] > 0) {
                if (windowFreq[c] < tFreq[c]) {
                    have++;
                }
                windowFreq[c]++;
            }
         while (have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if (tFreq[leftChar] > 0) {
                    windowFreq[leftChar]--;
                    if (windowFreq[leftChar] < tFreq[leftChar]) {
                        have--;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}