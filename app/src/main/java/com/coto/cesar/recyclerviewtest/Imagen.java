package com.coto.cesar.recyclerviewtest;

import java.util.Objects;

public class Imagen {

    private long id;
    private String name;
    private String description;
    private String urlImage;

    public Imagen() {
    }

    public Imagen(long id, String name, String description, String urlImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlImage = urlImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imagen imagen = (Imagen) o;
        return id == imagen.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
