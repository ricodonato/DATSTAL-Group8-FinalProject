public class PlaceGraph {

    int[][] adjacency = new int[10][10];

    String[] places = {"Br_Connon_Hall", "La_Salle_Hall", "Henry_Sy_Sr_Hall",
            "Bloemen_Hall", "Mutien_Marie_Hall", "Velasco_Hall",
            "Miguel_Hall", "Gokongwei_Hall", "Razon_Sports_Complex",
            "Andrew_Gonzales_Building"};

    void addEdge(String a, String b) {
        int index1 = indexOf(a);
        int index2 = indexOf(b);
        if (index1 == -1 || index2 == -1) {
            return;
        }
        adjacency[index1][index2] = 1;
        adjacency[index2][index1] = 1;
    }

    int indexOf(String name) {
        for (int i = 0; i < places.length; i++) {
            if (places[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    void displayAdjacencyMatrix() {
        System.out.println("                                BCH        LSH      " +
                " HSSH         BH         MM " +
                "        VH         MH         GH " +
                "       RSC        AGH");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%-33s", places[i]);
            for (int j = 0; j < 10; j++) {
                System.out.printf("%-11s", adjacency[i][j]);
            }
            System.out.println();
        }
    }
}