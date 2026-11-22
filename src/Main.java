import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("==== PlaceGraph TEST ====");
        PlaceGraph places = new PlaceGraph();

        try (BufferedReader r = new BufferedReader(new FileReader("map.txt")))
        {
            String line;
            while ((line = r.readLine()) != null)
            {
                String[] linePlaces = line.split(" ");
                places.addEdge(linePlaces[0], linePlaces[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        places.displayAdjacencyMatrix();


        PlaceList list = new PlaceList();
        list.add("Learning Commons");
        list.add("Bloemen");
        list.add("Yuchengco Auditorium");

        System.out.println("\n\n===== PlaceList TEST =====");

        System.out.println("A. Count the places");
        System.out.println("Total places: " + list.size);
        System.out.println();

        System.out.println("B. Get a place by spot");
        System.out.println("Spot 0 (first): " + list.get(0));
        System.out.println("Spot 1 (middle): " + list.get(1));
        System.out.println("Spot 2 (last): " + list.get(2));
        System.out.println("Spot 3 (empty): " + list.get(3));
        System.out.println();

        System.out.println("C. Find a place by name");
        System.out.println("Learning Commons (first): "
                + list.indexOf("Learning Commons"));
        System.out.println("Bloemen (middle): " + list.indexOf("Bloemen"));
        System.out.println("Yuchengco Auditorium (last): "
                + list.indexOf("Yuchengco Auditorium"));
        System.out.println("bloemen (small letters): "
                + list.indexOf("bloemen"));
        System.out.println("BLOEMEN (capital letters): "
                + list.indexOf("BLOEMEN"));
        System.out.println("Bloem (incomplete name): "
                + list.indexOf("Bloem"));
        System.out.println("Gym (not in list): " + list.indexOf("Gym"));

        System.out.println("\n\n===== BFS TEST =====");
        String from = "Br_Connon_Hall";
        String to = "Gokongwei_Hall";
        int startIdx = places.indexOf(from);
        int goalIdx = places.indexOf(to);
        String[] route = BFS.shortestPath(places.adjacency,
                places.places, startIdx, goalIdx);
        if (route.length == 0) {
            System.out.println("No route from " + from + " to " + to);
        } else {
            System.out.print("Route: ");
            for (int i = 0; i < route.length; i++) {
                System.out.print(route[i]);
                if (i < route.length - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }
}