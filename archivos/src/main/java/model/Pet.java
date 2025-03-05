package model;

import java.time.LocalDate;
import java.util.*;

public class Pet implements Comparable<Pet> {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Pet other) {
        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Pet{name='" + name + "'}";
    }
}

