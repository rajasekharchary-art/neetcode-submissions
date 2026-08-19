class Solution {
    public boolean isPalindrome(String s) {
        int beg= 0;
        int end = s.length() - 1;

        while (beg < end) {
            while(beg < end && !isAlphaNumeric(s.charAt(beg))) {
                beg++;
            }
            while(beg < end && !isAlphaNumeric(s.charAt(end))) {
                end--;
            }
            if(beg < end && Character.toLowerCase(s.charAt(beg)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            beg++;
            end--;
        }
        return true;
    }

    boolean isAlphaNumeric(char c) {
       return (c >= 'a' && c <= 'z') 
            || (c >= 'A' && c <= 'Z')  
            || (c >= '0' && c <= '9') ; 
    }
}
