package com.example.lmlopez.googleplacesautocomplete.model.prediction;

/**
 * Created by lmlopez on 19/02/2018.
 */

public class Prediction {

    private String description;
    private String place_id;

    public Prediction() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prediction that = (Prediction) o;

        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        return place_id != null ? place_id.equals(that.place_id) : that.place_id == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (place_id != null ? place_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return description;
    }
}
