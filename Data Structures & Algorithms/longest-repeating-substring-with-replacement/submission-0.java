class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0;
        int res = 0;
        Map<Character, Integer> fmap = new HashMap<>();
        int maxF = 0; // Track the frequency of the most common character in the window
        for(int r = 0; r < s.length(); r++) {
            fmap.put(s.charAt(r), fmap.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, fmap.get(s.charAt(r)));
            while( (r - l + 1) - maxF > k) {
                fmap.put(s.charAt(l), fmap.get(s.charAt(l)) - 1 );
                l++;
             }
             res = Math.max(res, r-l+1);

        }

        return res;
        
    }
}
