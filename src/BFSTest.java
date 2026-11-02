import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFSTest {

    public static void main(String[] args) {
        testQueue();
        testBFS();
        System.out.println("\nAll tests finished.");
    }

    static void testQueue() {
        System.out.println("=== Queue tests ===");
        Queue<String> q = new Queue<>();
        check("new queue is empty", q.isEmpty());

        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        check("size is 3 after 3 enqueues", q.size() == 3);
        check("peek returns front (A)", q.peek().equals("A"));
        check("dequeue returns A (FIFO)", q.dequeue().equals("A"));
        check("dequeue returns B", q.dequeue().equals("B"));
        check("dequeue returns C", q.dequeue().equals("C"));
        check("queue is empty again", q.isEmpty());
    }
    static void testBFS() {
        System.out.println("\n=== BFS tests ===");

        // Graph:  A - B - D - E
        //         |       |
        //         C ------+
        // Two paths from A to E: A-B-D-E and A-C-D-E (both length 4)
        Map<String, List<String>> graph = new HashMap<>();
        addEdge(graph, "A", "B");
        addEdge(graph, "A", "C");
        addEdge(graph, "B", "D");
        addEdge(graph, "C", "D");
        addEdge(graph, "D", "E");

        List<String> path = BFS.shortestPath(graph, "A", "E");
        check("A to E has length 4 nodes", path.size() == 4);
        check("path starts at A and ends at E",
                path.get(0).equals("A") && path.get(path.size() - 1).equals("E"));
        System.out.println("  Path A to E: " + path);

        // Shortest path must be used, not a longer one
        Map<String, List<String>> line = new HashMap<>();
        addEdge(line, "X", "Y");
        addEdge(line, "Y", "Z");
        addEdge(line, "X", "Z"); // direct shortcut
        check("X to Z takes the direct edge",
                BFS.shortestPath(line, "X", "Z").equals(List.of("X", "Z")));

        // Start equals goal
        check("start equals goal gives one node",
                BFS.shortestPath(graph, "C", "C").equals(List.of("C")));
        // Unreachable goal
        Map<String, List<String>> split = new HashMap<>();
        addEdge(split, "P", "Q");
        addEdge(split, "R", "S");
        check("no path from P to S gives empty list",
                BFS.shortestPath(split, "P", "S").isEmpty());

        // Place not in the graph
        check("unknown place gives empty list",
                BFS.shortestPath(graph, "A", "Nowhere").isEmpty());
    }

    // Adds an undirected edge (both directions)
    static void addEdge(Map<String, List<String>> graph, String a, String b) {
        graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
    }

    static void check(String name, boolean passed) {
        System.out.println((passed ? "PASS: " : "FAIL: ") + name);
    }
}