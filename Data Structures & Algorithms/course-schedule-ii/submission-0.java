class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] ans = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites) {
            int u = edge[0];
            int v = edge[1];

            graph.get(v).add(u);
        }

        int[] in = new int[n];

        for(int i = 0 ; i < n ; i++) {
            for(int nei : graph.get(i)) {
                in[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++) {
            if(in[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()) {
            int curr = q.poll();
            list.add(curr);

            for(int nei : graph.get(curr)) {
                in[nei]--;
                if(in[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if(list.size() == n) {
            for(int i = 0 ; i < n ; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
        return new int[]{};
    }
}
