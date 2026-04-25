class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int n: nums) {
           boolean unique = set.add(n);
           if(!unique){
                return true;
           }
        }
        return false;
    }
}