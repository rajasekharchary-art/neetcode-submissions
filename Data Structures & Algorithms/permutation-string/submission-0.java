class Solution {
    public boolean checkInclusion(String s1, String s2) {

        char[] sa1 = new char[26];
        char[] sa2 = new char[26];

        for(char c: s1.toCharArray()) {
            sa1[c - 'a']++;
        }

        int l = 0;
        for(int r = 0; r < s2.length(); r++) {
            sa2[s2.charAt(r) - 'a']++;
            if(r-l+1 > s1.length()) {
                sa2[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(sa1, sa2)) {
                return true;
            }

        }

        return false;

    }

}
