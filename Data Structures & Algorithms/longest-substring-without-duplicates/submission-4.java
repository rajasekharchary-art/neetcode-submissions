class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;  // Must be 0, not 1
        int l = 0;
        int[] freq = new int[128];

        for (int r = 0; r < s.length(); r++) {
            char current = s.charAt(r);

            while (freq[current] > 0) {
                freq[s.charAt(l)]--;
                l++;
            }

            freq[current]++;
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}