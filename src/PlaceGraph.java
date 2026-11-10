import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaceGraph {

    int[][] adjacency = new int[10][10];
    // initialize vertices
    String[] places = {"Br_Connon_Hall", "La_Salle_Hall", "Henry_Sy_Sr_Hall"
            , "Bloemen_Hall", "Mutien_Marie_Hall", "Velasco_Hall",
            "Miguel_Hall", "Gokongwei_Hall", "Razon_Sports_Complex",
                "Andrew_Gonzales_Building"};

    // add the edges (roads) connected to each place
    void addEdge(String a, String b){
        int index1 = 0;
        int index2 = 0;

        // get adjacency
        for (int i = 0; i < 10; i++)
        {
            index1 = 0;
            index2 = 0;
            // Get the connection of that vertex
            if (places[i].equals(a)) {
                index1 = i;
                for (int j = 0; j < 10; j++) {
                    if (places[j].equals(b))
                    {
                        index2 = j;
                        adjacency[index1][index2] = 1;
                        adjacency[index2][index1] = 1;
                        break;
                    }
                }
            }
        }

        // for other matrices, put 0

    }

    // print the adjacency matrix
    void displayAdjacencyMatrix(){
        // header
        IO.println("                                BCH        LSH      " +
                " HSSH         BH         MM " +
                "        VH         MH         GH " +
                "       RSC        AGH");

        // get every place
        for (int i = 0; i < 10; i++)
        {
            System.out.printf("%-33s", places[i]);
            // generate place's every connection
            for (int j = 0; j < 10; j++)
            {
                System.out.printf("%-11s", adjacency[i][j]);
            }
            IO.println();
        }
    }

    // display all places from A-Z
    String[] showPlaces(){
        PlaceList sorted = new PlaceList();

        for (int i = 0; i < places.length; i++) {
            sorted.add(places[i]);
        }

        sorted.sortAZ();

        String[] result = new String[sorted.size];
        for (int i = 0; i < sorted.size; i++) {
            result[i] = sorted.get(i);
        }
        return result;
    }

    // find shortest path between two places
    Map<String, List<String>> toAdjacencyList() {
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < places.length; i++) {
            List<String> neighbors = new ArrayList<>();
            for (int j = 0; j < places.length; j++) {
                if (adjacency[i][j] == 1) {
                    neighbors.add(places[j]);
                }
            }
            graph.put(places[i], neighbors);
        }
        return graph;
    }

    int getIndex(String name) {
        for (int i = 0; i < places.length; i++) {
            if (places[i].equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }
}

