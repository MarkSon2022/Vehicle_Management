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
public class Motorbike extends Vehicles {

    private int speed;
    private boolean license;

    public Motorbike() {

    }

    public Motorbike(String id, String name) {
        super(id, name);
    }

    public Motorbike(String id) {
        super(id);
    }

    public Motorbike(String id, String name, String color, int price, String brand) {
        super(id, name, color, price, brand);
    }

    public Motorbike(int speed, boolean license) {
        this.speed = speed;
        this.license = license;
    }

    public Motorbike(int speed, boolean license, String id, String name) {
        super(id, name);
        this.speed = speed;
        this.license = license;
    }

    public Motorbike(int speed, boolean license, String id) {
        super(id);
        this.speed = speed;
        this.license = license;
    }

    public Motorbike(int speed, boolean license, String id, String name, String color, int price, String brand) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.license = license;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    @Override
    public void updateVehicle() {
        super.updateVehicle(); //To change body of generated methods, choose Tools | Templates.
        this.speed = Utils.updateInt("Speed: ", 1, 1000, speed);
        this.license = Utils.confirmYesNo("License(Y/N): " );             
    }

    @Override
    public void inputVehicle() {
        super.inputVehicle(); //To change body of generated methods, choose Tools | Templates.
        this.speed = Utils.getInt("Speed: ", 1, 1000);
        this.license = Utils.confirmYesNo("License(Y/N): " );
    }

    @Override
    public void display() {
        System.out.printf("%-20s %-40s %-20s %-20d %-30s %-20d %-20s %-15s\n",
                this.getId(),this.getName(),this.getColor(),this.getPrice(),this.getBrand(),this.getSpeed(),this.getLicense(),this.makeSound(this) );
    }

    @Override
    public String toString() {
        return "Motorbike" + "," + this.getId() + "," + this.getName() + "," + this.getColor()
                + "," + this.getPrice() + "," + this.getBrand() + "," + this.getSpeed() + "," + this.getLicense();
    }

}
