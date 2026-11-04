public class PlaceGraph {
    int[][] adjacency = new int[10][10];
    // initialize vertices
    String[] places = {"Bro_Connon_Hall", "La_Salle_Hall", "Henry_Sy_Sr_Hall"
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
        IO.println("        Bro. Connon Hall        La Salle Hall       " +
                "Henry Sy Sr. Hall      Bloemen Hall        Mutien Marie " +
                "Hall       Velasco Hall        Miguel Hall     Gokongwei " +
                "Hall       Razon Sports Complex        Andrew Gonzales Hall");

        // get every place
        for (int i = 0; i < 10; i++)
        {
            IO.print(places[i] + "\t");
            // generate place's every connection
            for (int j = 0; j < 10; j++)
            {
                IO.print(adjacency[i][j] + "\t");
            }
            IO.println();
        }
    }

}

