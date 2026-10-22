class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        combinationSum(0, new ArrayList(), nums, target, 0);
        return ans;
    }


    private void combinationSum(int start, List<Integer> curr, int[] nums, int target, int total) {
        if(total == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(total + nums[i] > target) {
                return;
            }

            curr.add(nums[i]);
            combinationSum(i, curr, nums, target, total + nums[i]);
            curr.remove(curr.size() - 1);
        }
    }


}
