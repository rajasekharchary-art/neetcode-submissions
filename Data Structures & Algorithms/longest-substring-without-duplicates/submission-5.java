class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int[] freq = new int[128];
        while(r < s.length()) {
           
            while(l < r && freq[s.charAt(r)] != 0) {
                freq[s.charAt(l)]--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            freq[s.charAt(r)]++;
            r++;
        } 

        return maxLen;       
    }
}
