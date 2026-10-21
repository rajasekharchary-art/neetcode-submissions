class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(ans, new ArrayList(), nums);
        return ans;
    }

    private void permute(List<List<Integer>> ans, List<Integer> curr, int[] nums) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return ;
        }

        for(int n: nums) {
            if(!curr.contains(n)) {
                curr.add(n);
                permute(ans, curr, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}