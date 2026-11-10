public class PlaceList {

    // stores place names
    String[] places = new String[50];

    // number of places saved
    int size = 0;

    // adds a new place
    void add(String name) {
        places[size] = name;
        size++;
    }

    // gets a place
    String get(int i) {
        return places[i];
    }

    // finds a place (linear search)
    int indexOf(String name) {
        for (int i = 0; i < size; i++) {
            if (places[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // sorts the places A to Z (selection sort)
    void sortAZ() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;

            for (int j = i + 1; j < size; j++) {
                if (places[j].compareToIgnoreCase(places[min]) < 0) {
                    min = j;
                }


            }
            String temp = places[i];
            places[i] = places[min];
            places[min] = temp;
        }

    }
}