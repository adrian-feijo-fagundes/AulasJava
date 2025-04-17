package set;

import java.util.Objects;

public record Guest(int code, String name) implements Comparable<Guest> {
    @Override
    public int compareTo(Guest o) {
        return name.compareTo(o.name());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Guest guest)) return false;
        return Objects.equals(code(), guest.code());
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "";
    }
}
