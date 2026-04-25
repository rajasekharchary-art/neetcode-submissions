class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        

        for(String s: strs) {
            int[] counts = new int[26];
            for(int i = 0 ; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
            }
            StringBuilder keySB = new StringBuilder();
            for(int c: counts) {
                keySB.append("#").append(c);
            }
            String key = keySB.toString();
            List<String> group = groups.get(key);
            if(group == null) {
                group = new ArrayList<>();
            }
            group.add(s);
            groups.put(key, group);
        }
        return new ArrayList<>(groups.values());
    }

}
