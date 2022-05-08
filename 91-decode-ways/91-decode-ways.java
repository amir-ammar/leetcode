class Solution {
    static int memo[][];
    

    public static int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0)=='0')return 0;
        
            
        memo = new int[n][2];
        for (int [] arr : memo) {
            Arrays.fill(arr, -1);
        }
        int ans = solve(0, 0, n, s);
        return ans<=0?0:ans;
        
    }

    public static int solve(int idx, int rev, int n, String s){

        
        if(idx==n-1)return 1;
        if(memo[idx][rev]!=-1)return memo[idx][rev];

        int tmp = 0;

        if(rev==1){
            if(s.charAt(idx+1)=='0')
                return 0;
            else
                tmp += solve(idx+1, 0, n, s);
        }else{

            // connect if the next is zero
            if(s.charAt(idx+1)=='0' && Integer.parseInt(s.charAt(idx)+""+"0")<=26){
                
                tmp += solve(idx+1, 1, n, s);
            }else if (s.charAt(idx+1)=='0' && Integer.parseInt(s.charAt(idx)+""+"0")>26){
                return Integer.MIN_VALUE;
            }else{
                String str = s.charAt(idx) + "" + s.charAt(idx+1);
                if(Integer.parseInt(str)<=26){
                    tmp += solve(idx+1, 0, n, s) + solve(idx+1, 1, n, s);
                }else{
                    tmp += solve(idx+1, 0, n, s);
                }
            }

        }
        
        return memo[idx][rev] = tmp;
    }
}   