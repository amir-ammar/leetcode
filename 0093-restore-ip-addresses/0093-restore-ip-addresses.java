class Solution {
    static List<String> ans;
    public static void solve (int i, ArrayDeque<String> str, String ip, int seg) {


        if (i == ip.length() && seg == 4) {
            ans.add(str.toString());
            return;
        }
        
        if (i == ip.length() || seg == 4) {
            return;
        }

        str.add(ip.charAt(i)+"");
        solve(i+1, str, ip, seg+1);
        str.removeLast();

        if (ip.charAt(i) != '0' && i+1 < ip.length()) {
            str.add(ip.substring(i, i+2));
            solve(i + 2, str, ip, seg+1);
            str.removeLast();
        }

        if (ip.charAt(i) != '0' && i+2 < ip.length() && Integer.parseInt(ip.substring(i, i+3)) <= 255) {
            str.add(ip.substring(i, i+3));
            solve(i + 3, str, ip, seg+1);
            str.removeLast();
        }

    }

    public static List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        solve(0, new ArrayDeque<>(), s, 0);
        List <String> res = new ArrayList<>();
        for (String temp : ans) {
            temp = temp.substring(1, temp.length() - 1);
            temp = temp.replace(", ", ".");
            res.add(temp);
        }
        return res;
    }
}