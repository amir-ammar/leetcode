public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> auxStack = new ArrayDeque<>();
        int[] order = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0], prere = prerequisites[i][1];
            graph.get(prere).add(course);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                stack.push(i);
                while (!stack.isEmpty()) {
                    Integer prere = stack.peek();
                    if(visited[prere] == 0) {
                        // start of dfs search rooted at prere
                        visited[prere] = -1;
                    }
                    else if (visited[prere] == -1){
                        // end of dfs search rooted at prere; prere is a normal node
                        stack.pop();
                        visited[prere] = 1;
                        auxStack.push(prere);
                        continue;
                    } 
                    else if (visited[prere] == 1) {
                       // since prere is an end node of a cross edge; the dfs search rooted at prere
                       // has been finished as part of another dfs search rooted at another node
                       // we have no need to explore its neighbors again
                        stack.pop();
                        continue;
                    }
                    for (Integer course: graph.get(prere)) {
                        if (visited[course] == 0) {
                            stack.push(course);
                        }
                        else if (visited[course] == -1) {
                            return new int[0];
                        }
                    }
                }
                
            }
        }
        for (int i = 0; i<numCourses; i++) {
            order[i] = auxStack.pop();
        }
        return order;
    }
}
