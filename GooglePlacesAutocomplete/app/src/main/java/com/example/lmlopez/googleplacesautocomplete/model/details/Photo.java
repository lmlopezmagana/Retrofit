package com.example.lmlopez.googleplacesautocomplete.model.details;

/**
 * Created by lmlopez on 21/02/2018.
 */

public class Photo {


    private String photo_reference;

    public Photo() {
    }

    public String getPhoto_reference() {
        return photo_reference;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        return photo_reference != null ? photo_reference.equals(photo.photo_reference) : photo.photo_reference == null;
    }

    @Override
    public int hashCode() {
        return photo_reference != null ? photo_reference.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photo_reference='" + photo_reference + '\'' +
                '}';
    }
}
