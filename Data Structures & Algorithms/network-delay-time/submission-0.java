class Solution {
    class Pair {
        int node, dist;

        public Pair(int n, int d) {
            node = n;
            dist = d;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : times) {
            int n1 = edge[0];
            int n2 = edge[1];
            int w = edge[2];

            graph.get(n1).add(new Pair(n2,w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new Pair(k,0));
        dist[k] = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int x = curr.node;
            int w = curr.dist;

            if(dist[x] < w) continue;

            for(Pair nei : graph.get(x)) {
                int newNode = nei.node;
                int newDis = nei.dist;
                if(dist[newNode] > newDis + w) {
                    dist[newNode] = newDis + w;
                    pq.add(new Pair(newNode, dist[newNode]));
                }
            }
        }

        int max = 0;
        for(int i = 1 ; i <= n ; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                max = Math.max(max, dist[i]);
            }
        }
        return max;
    }
}
