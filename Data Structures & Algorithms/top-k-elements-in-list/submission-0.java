class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n: nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] counts = new ArrayList[nums.length + 1];

        for(int n: freq.keySet()) {
            int count = freq.get(n);
            if(counts[count] == null) {
                counts[count] = new ArrayList<Integer>();
            }
            counts[count].add(n);
        }

        int[] result = new int[k];
        int r = 0;

        for(int i = counts.length - 1;  i >=0 && r < k; i--) {
            if(counts[i] != null) { 
                for(int n: counts[i]) {
                    result[r++] = n;
                    if(r == k) {
                        break;
                    }
                }
            }
        }

        return result;



    }
}
