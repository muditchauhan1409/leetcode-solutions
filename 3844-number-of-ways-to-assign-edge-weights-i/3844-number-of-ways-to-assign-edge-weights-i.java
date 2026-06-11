class Solution {
    static final int MOD = 1000000007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(1);
        vis[1] = true;

        int depth = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int node = q.poll();

                for(int nei : graph[node]) {
                    if(!vis[nei]) {
                        vis[nei] = true;
                        q.offer(nei);
                    }
                }
            }

            if(!q.isEmpty()) depth++;
        }

        long ans = 1;
        long base = 2;
        int exp = depth - 1;

        while(exp > 0) {
            if((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return (int)ans;
    }
}