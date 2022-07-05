class Solution {
    
    
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n+1);
        int [] ans = new int[2];

        for (int [] x:edges) {
            if(uf.isSameSet(x[0], x[1])) {ans[0] = x[0]; ans[1] = x[1];}
            else
            {
                uf.unionSet(x[0], x[1]);
            }
        }

        return ans;
    }

    
    
    static public class UnionFind {
        int[] p, rank, setSize;
        int numSets;

        public UnionFind(int N)
        {
            p = new int[numSets = N];
            rank = new int[N];
            setSize = new int[N];
            for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
        }

        public int findSet(int i) { return p[i] == i ? i : (p[i] = findSet(p[i])); }

        public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

        public void unionSet(int i, int j)
        {
            if (isSameSet(i, j))
                return;
            numSets--;
            int x = findSet(i), y = findSet(j);
            if(rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
            else
            {	p[x] = y; setSize[y] += setSize[x];
                if(rank[x] == rank[y]) rank[y]++;
            }
        }

        public int numDisjointSets() { return numSets; }

        public int sizeOfSet(int i) { return setSize[findSet(i)]; }
    }
    
    
}