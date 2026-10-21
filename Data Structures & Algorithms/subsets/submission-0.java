class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        subsets(0, new ArrayList<Integer>(), nums);
        return ans;    
        
    }

    private void subsets(int start, List<Integer> curr, int[] nums) {
        
        if(start > nums.length) {
            return;
        }

        ans.add(new ArrayList<Integer>(curr));
        
        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            subsets(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
