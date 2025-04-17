package set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GuestList {
    private Set<Guest> guests;

    public GuestList() {
        guests = new HashSet<>();
    }

    public void addGuest(int code, String name) {
        guests.add(new Guest(code, name));
    }

    public void removeByCode(int code) {
        if (guests.isEmpty()) return;
        for (Guest g : guests) {
            if (g.code() == code) {
                guests.remove(g);
                break;
            }
        }
    }

    public int size() {
        return guests.size();
    }

    public Set<Guest> sortByCode() {

    }

    public Set<Guest> sortByName() {

    }
}
