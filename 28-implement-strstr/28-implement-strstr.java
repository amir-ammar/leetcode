class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0 && needle.length()==0)return 0;
        if(haystack.length()==0)return -1;
        if(needle.length()==0)return 0;
        int i;
        String tmp = "";
        for( i = 0 ; i<haystack.length() ; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(!(i+needle.length()>haystack.length())) 
                    tmp = haystack.substring(i , i+needle.length());
                if(tmp.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}