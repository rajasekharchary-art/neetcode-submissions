class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        for(int n: nums) {
            set.add(n);
        }

        for(int i: set) {
            if(!set.contains(i-1)) { // start of the sequence
                int x = i;
                int count = 1;
                while(set.contains(x+1)) {
                  x++;
                  count++;
                }
                maxLen = Math.max(count, maxLen);
            }
        }
        return maxLen;
    }
}
