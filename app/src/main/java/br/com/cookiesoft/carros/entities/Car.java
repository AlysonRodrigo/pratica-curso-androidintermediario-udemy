package br.com.cookiesoft.carros.entities;

import android.graphics.drawable.Drawable;

/**
 * Created by Cookiesoft on 16/10/2017.
 */

public class Car {

    private int id;
    private String model;
    private String fabricante;
    private int cavalos;
    private Double price;
    private Drawable picture;

    public Car(int id, String model, String fabricante, int cavalos, Double price, Drawable picture) {
        this.id = id;
        this.model = model;
        this.fabricante = fabricante;
        this.cavalos = cavalos;
        this.price = price;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getCavalos() {
        return cavalos;
    }

    public Double getPrice() {
        return price;
    }

    public Drawable getPicture() {
        return picture;
    }
}
