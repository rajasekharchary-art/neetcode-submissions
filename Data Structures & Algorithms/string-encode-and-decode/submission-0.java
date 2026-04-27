class Solution {

    public String encode(List<String> strs) {
        // find the length of each string and add a delimiter # and append the string in loop
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();


    }

    public List<String> decode(String str) {
        System.out.println(str.toString());
        //first read the size of string until first delmiter # and 
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            StringBuilder numSB = new StringBuilder();
           while (i < str.length() && str.charAt(i) != '#') {
                numSB.append(str.charAt(i++));
            }
            System.out.println(i + " : "+ numSB.toString());
            int size = Integer.parseInt(numSB.toString());
            i++;
            StringBuilder strSB = new StringBuilder();
            for(int j = 0; j < size && i < str.length(); j++) {
                strSB.append(str.charAt(i++));
            }
            result.add(strSB.toString());
        }
        return result;

    }
}
