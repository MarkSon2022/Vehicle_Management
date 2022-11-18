/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211.vehicles;

import lab211.assignment.Utils;

/**
 * Comparable
 *
 * @author asus
 */
public abstract class Vehicles implements Comparable<Vehicles> {

    private String typeVehicle;

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }
    private String id;
    private String name;
    private String color;
    private int price;
    private String brand;

    public Vehicles() {
    }

    public Vehicles(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Vehicles(String id) {
        this.id = id;
    }

    public Vehicles(String id, String name, String color, int price, String brand) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //methods
    public void inputVehicle() {
        this.name = Utils.getString("Name: ");
        this.color = Utils.getString("Color: ");
        this.price = Utils.getInt("Price: ", 1, 100000);
        this.brand = Utils.getString("Brand: ");
    }

    public void updateVehicle() {
        this.name = Utils.updateString("Name: ", name);
        this.color = Utils.updateString("Color: ", color);
        this.price = Utils.updateInt("Price: ", 1, 100000, price);
        this.brand = Utils.updateString("Brand: ", brand);
    }

    public abstract void display();

    @Override
    public int compareTo(Vehicles o) {
        return o.getPrice() - this.getPrice();
    }

    @Override
    public boolean equals(Object obj) {
        Vehicles vehicle = (Vehicles) obj;
        return this.id.equalsIgnoreCase(vehicle.getId()); //To change body of generated methods, choose Tools | Templates.
    }

    public String makeSound(Vehicles vehicle) {
        if (vehicle instanceof Motorbike) {
            return "Tin Tin TIn";
        }
        return "";
    }
}
