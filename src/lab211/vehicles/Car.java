/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211.vehicles;

import lab211.assignment.Utils;

/**
 *
 * @author asus
 */
public class Car extends Vehicles {   

    private String type;
    private int yearOfManufacture;

    public Car() {
    }

    public Car(String id) {
        super(id);
    }

    public Car(String type, int yearOfManufacture) {
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Car(String type, int yearOfManufacture, String id, String name) {
        super(id, name);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Car(String type, int yearOfManufacture, String id) {
        super(id);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Car(String type, int yearOfManufacture, String id, String name, String color, int price, String brand) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public void updateVehicle() {
        super.updateVehicle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inputVehicle() {
        super.inputVehicle(); //To change body of generated methods, choose Tools | Templates.
        this.type = Utils.getString("Type of car: ");
        this.yearOfManufacture = Utils.getInt("Year of manufacture: ", 1, 3000);
    }

    @Override
    public void display() {
        System.out.printf("%-20s %-40s %-20s %-20d %-30s %-20s %-20d\n"
                ,this.getId(),this.getName(),this.getColor(),this.getPrice(),this.getBrand(),this.getType(),this.getYearOfManufacture() );
    }

    @Override
    public String toString() {
        return "Car" + "," + this.getId() + "," + this.getName() + "," + this.getColor() + "," + this.getPrice() 
                + "," + this.getBrand() + ","+ this.getType() + "," + this.getYearOfManufacture();
    }

   
}
