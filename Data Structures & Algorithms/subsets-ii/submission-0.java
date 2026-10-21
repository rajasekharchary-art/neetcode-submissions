class Solution {
    Set<List<Integer>> ans = new HashSet();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets(0, new ArrayList<Integer>(), nums);
        List<List<Integer>> result = new ArrayList(ans);
        return result;
    }

    public void subsets(int start, List<Integer> curr, int[] nums) {
        if(start > nums.length) {
            return;
        }

        ans.add(new ArrayList<Integer>(curr));

        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            subsets(i+1, curr, nums);
            curr.remove(curr.size() - 1 );
        }
    }
}
