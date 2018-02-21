package com.example.lmlopez.googleplacesautocomplete.model.details;

/**
 * Created by lmlopez on 21/02/2018.
 */

public class Geometry {

    private Location location;

    public Geometry() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Geometry geometry = (Geometry) o;

        return location != null ? location.equals(geometry.location) : geometry.location == null;
    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "location=" + location +
                '}';
    }
}
