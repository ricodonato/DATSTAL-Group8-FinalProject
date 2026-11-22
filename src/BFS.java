public class BFS {

    public static String[] shortestPath(int[][] adj, String[] names,
                                        int start, int goal) {
        int n = names.length;
        if (start < 0 || start >= n || goal < 0 || goal >= n) {
            return new String[0];
        }

        int[] queue = new int[n];
        int head = 0;
        int tail = 0;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        queue[tail] = start;
        tail++;
        visited[start] = true;

        while (head < tail) {
            int current = queue[head];
            head++;

            if (current == goal) {
                return buildPath(parent, names, goal);
            }

            for (int next = 0; next < n; next++) {
                if (adj[current][next] != 0 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    queue[tail] = next;
                    tail++;
                }
            }
        }

        return new String[0];
    }

    private static String[] buildPath(int[] parent, String[] names,
                                      int goal) {
        int length = 0;
        for (int at = goal; at != -1; at = parent[at]) {
            length++;
        }

        String[] path = new String[length];
        int at = goal;
        for (int i = length - 1; i >= 0; i--) {
            path[i] = names[at];
            at = parent[at];
        }
        return path;
    }
}