import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BFS {
    public static List<String> shortestPath(Map<String, List<String>> graph,
                                            String start, String goal) {
        if (!graph.containsKey(start) || !graph.containsKey(goal)) {
            return Collections.emptyList();
        }

        Queue<String> queue = new Queue<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.enqueue(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.dequeue();

            if (current.equals(goal)) {
                return buildPath(parent, start, goal);
            }

            for (String neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.enqueue(neighbor);
                }
            }
        }

        return Collections.emptyList(); // goal not reachable
    }

}