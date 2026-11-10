import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Graph
        System.out.println("==== PlaceGraph TEST ====");
        PlaceGraph places = new PlaceGraph();
        String[] linePlaces = new String[2];

        PlaceList mapList = new PlaceList();

        // Read map file
        try(BufferedReader r = new BufferedReader(new FileReader("map.txt")))
        {
            String line;
            while(((line = r.readLine()) != null))
            {
                linePlaces = line.split(" ");
                places.addEdge(linePlaces[0], linePlaces[1]);

                // save each place once
                for (String name : linePlaces) {
                    if (mapList.indexOf(name) == -1) {
                        mapList.add(name);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // print the adjacency matrix
        places.displayAdjacencyMatrix();

        // sort test
        System.out.println("\n\n===== Sort TEST =====");
        System.out.println("Before:");
        for (int i = 0; i < mapList.size; i++) {
            System.out.println(mapList.get(i));
        }
        mapList.sortAZ();
        System.out.println("\nAfter (A to Z):");
        for (int i = 0; i < mapList.size; i++) {
            System.out.println(mapList.get(i));
        }



        PlaceList list = new PlaceList();
        list.add("Learning Commons");
        list.add("Bloemen");
        list.add("Yuchengco Auditorium");

    /*    System.out.println("\n\n===== PlaceList TEST =====");

        // size
        System.out.println("A. Count the places");
        System.out.println("Total places: " + list.size);
        System.out.println();

        // get
        System.out.println("B. Get a place by spot");
        System.out.println("Spot 0 (first): " + list.get(0));
        System.out.println("Spot 1 (middle): " + list.get(1));
        System.out.println("Spot 2 (last): " + list.get(2));
        System.out.println("Spot 3 (empty): " + list.get(3));
        System.out.println();

        // search
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

     */
    }
}