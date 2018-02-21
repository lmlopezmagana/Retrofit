package com.example.lmlopez.googleplacesautocomplete.model.details;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmlopez on 21/02/2018.
 */

public class Result {

    private Geometry geometry;
    private List<Photo> photos = new ArrayList<>();

    public Result() {
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (geometry != null ? !geometry.equals(result.geometry) : result.geometry != null)
            return false;
        return photos != null ? photos.equals(result.photos) : result.photos == null;
    }

    @Override
    public int hashCode() {
        int result = geometry != null ? geometry.hashCode() : 0;
        result = 31 * result + (photos != null ? photos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "geometry=" + geometry +
                ", photos=" + photos +
                '}';
    }
}
