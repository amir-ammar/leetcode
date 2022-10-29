class Solution {
    static HashMap<Integer, Boolean> map;
    public static boolean solve (int node, int [][] graph) {

        if (map.containsKey(node)) return map.get(node);
        boolean ans = true;
        for (int x: graph[node]) {
            map.put(node, false);
            ans &= solve(x, graph);
        }
        map.put(node, ans);
        return ans;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!map.containsKey(i)) solve(i, graph);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (map.get(i)) ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }
}