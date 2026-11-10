import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // graph
        PlaceGraph places = new PlaceGraph();
        String[] linePlaces = new String[2];

        // Main Menu
        String choice = "";
        boolean loaded = false;
        IO.println("=========================================");
        IO.println("           CAMPUS MAP FINDER");
        IO.println("=========================================");

        while (!choice.equalsIgnoreCase("4")) {
            IO.println("\n1. Load Map");
            IO.println("2. Show All Places");
            IO.println("3. Find Shortest Path");
            IO.println("4. Exit");
            choice = IO.readln("Enter Your Choice: ");
            IO.println();

            switch (choice)
            {
                case "1":   // load the map
                    try(BufferedReader r = new BufferedReader(new FileReader("map.txt")))
                    {
                        String line;
                        while(((line = r.readLine()) != null))
                        {
                            linePlaces = line.split(" ");
                            places.addEdge(linePlaces[0], linePlaces[1]);
                        }
                        IO.println("The map has been successfully loaded.");
                        loaded = true;
                    } catch(FileNotFoundException e){
                        IO.println("[ERROR] Map file not found.");
                    } catch (IOException e) {
                        IO.println("[ERROR] Unable to read map file.");
                    }
                    break;
                case "2":   // show all places from A-Z
                    if (!loaded)
                        IO.println("[ERROR] Please load the map first.");
                    else{
                        IO.println("Places in A-Z:");
                        String[] sortedPlaces = places.showPlaces();
                        for (int i = 0; i < sortedPlaces.length; i++) {
                            IO.println((i + 1) + ". " + sortedPlaces[i]);
                        }
                    }
                    break;
                case "3":   // find shortest path between two places
                    if (!loaded)
                        IO.println("[ERROR] Please load the map first.");
                    else {
                        String choicePlaces = IO.readln("Enter two places separated by comma: ");
                        String[] twoPlaces = choicePlaces.split(",");

                        if (twoPlaces.length != 2) {
                            IO.println("[ERROR] Please enter exactly two places separated by a comma.");
                        } else {
                            String from = twoPlaces[0].trim().replace(' ', '_');
                            String to = twoPlaces[1].trim().replace(' ', '_');

                            int f = places.getIndex(from);
                            int t = places.getIndex(to);

                            if (f == -1 || t == -1) {
                                IO.println("[ERROR] One or both places do not exist.");
                            } else if (f == t) {
                                IO.println("You are already at " + places.places[f].replace("_", " ") + ".");
                            } else {
                                List<String> path = BFS.shortestPath(places.toAdjacencyList(),
                                        places.places[f], places.places[t]);

                                if (path.isEmpty()) {
                                    IO.println("No path found between those places.");
                                } else {
                                    IO.println("Shortest path (" + (path.size() - 1) + " steps):");
                                    for (int i = 0; i < path.size(); i++) {
                                        IO.print(path.get(i).replace("_", " "));
                                        if (i < path.size() - 1) IO.print(" -> ");
                                    }
                                    IO.println();
                                }
                            }
                        }
                    }
                    break;
                case "4":   // Exit
                    IO.println("Thank you for using Campus Map Finder!");
                    break;
                default:
                    IO.println("Please choose a valid option.");
            }
        }
    }
}