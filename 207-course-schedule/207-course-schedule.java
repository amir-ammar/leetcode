class Solution {
    static ArrayList<Integer> [] graph;
    static Boolean [] token;
    

    public static boolean dfs(int v, HashSet<Integer> path){
        if(graph[v].size() == 0) {return true;}
        if(token[v] != null && token[v]) return true;

        for (int x: graph[v]) {
            if(path.contains(x) || (token[x]!= null && !token[x])){
                token[v] = false;
                return false;
            }else{
                path.add(x);
                token[v] = (token[v] == null? dfs(x, path) : token[v] & dfs(x, path));
                path.remove(x);
            }
        }
        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        token = new Boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length ; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> path = new HashSet<>();
            path.add(i);
            dfs(i, path); 
        }
        boolean ans = true;
        for (int i = 0; i < numCourses; i++) {
            ans &= (token[i] == null || token[i]);
        }
        return ans;
    }
}