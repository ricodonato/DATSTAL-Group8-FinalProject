public class PlaceList {

    String[] places = new String[50];

    int size = 0;

    void add(String name) {
        places[size] = name;
        size++;
    }

    String get(int i) {
        return places[i];
    }

    int indexOf(String name) {
        for (int i = 0; i < size; i++) {
            if (places[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}