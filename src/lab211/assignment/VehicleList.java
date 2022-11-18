package lab211.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import lab211.vehicles.Car;
import lab211.vehicles.Vehicles;
import java.util.Collections;
import java.util.StringTokenizer;
import lab211.vehicles.Motorbike;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * This is comment, do not delete 2021.11.30
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class VehicleList extends ArrayList<Vehicles> implements I_List {

    public VehicleList() {

    }

    @Override
    public void addVehicles() {
        boolean confirm = false;
        do {
            Vehicles vehicle = null;
            Menu submenu = new Menu();
            submenu.addItem("Add Vehicles: ");
            submenu.addItem("1. Car");
            submenu.addItem("2. Motorbike");
            submenu.showMenu();
            int choice = Utils.getInt("You choose: ", 1, 2);
            if (choice == 1) {
                System.out.println("Car: ");
            } else if (choice == 2) {
                System.out.println("Motorbike: ");
            }
            String id = Utils.getString("Input your ID: ");

            switch (choice) {
                case 1: {
                    vehicle = new Car(id);
                    vehicle.inputVehicle();
                    this.add(vehicle);
                    System.out.println("Add success!");
                    break;
                }
                case 2: {
                    vehicle = new Motorbike(id);
                    vehicle.inputVehicle();
                    this.add(vehicle);
                    System.out.println("Add success!");
                    break;
                }
            }
            confirm = Utils.confirmYesNo("Continue ? Y/N: ");
        } while (confirm);
    }

    @Override
    public void updateByID() {
        String id = Utils.getString("Input id to get update: ");
        if (this.searchID(id) != null) {
            this.searchID(id).updateVehicle();
            this.searchID(id).display();
        } else {
            System.out.println("Vehicle does not exist");
        }
    }

    @Override
    public void deleteByID() {
        String id = Utils.getString("Input id to get delete: ");
        if (this.searchID(id) == null) {
            System.out.println("Vehicle does not exist");
        } else {
            Boolean confirm = Utils.confirmYesNo("Do you want to delete this vehicle ? Y/N: ");
            if (confirm) {
                this.remove(this.searchID(id));
                System.out.println("Success !!");
            } else {
                System.out.println("Fail !!");
            }
        }
    }

    @Override
    public void searchByID(String id) {
        VehicleList list = new VehicleList();
        Vehicles vehicle = null;
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().contains(id)) {
                vehicle = this.get(i);
                list.add(vehicle);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Vehicle does not exist !!");
        } else {
            System.out.printf("%-20s %-40s %-20s %-20s %-30s %-20s %-20s %-15s\n",
                    "ID", " Name", "Color", "Price", "Brand", "Type/Speed", "YOM/Licence", "Message");
            System.out.println("==========================================================================================================================================="
                    + "===============================================================================================================================");
            for (int i = 0; i < list.size(); i++) {
                list.get(i).display();
            }
        }
    }

    @Override
    public Vehicles searchID(String id) {
        Vehicles vehicle = null;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equals(id)) {
                vehicle = this.get(i);
            }
        }
        return vehicle;
    }

    @Override
    public void searchByName(String name) {
        VehicleList list = new VehicleList();
        Vehicles vehicle = null;
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getName().contains(name)) {
                vehicle = this.get(i);
                list.add(vehicle);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Vehicle does not exist !!");
        } else {
            System.out.printf("%-20s %-40s %-20s %-20s %-30s %-20s %-20s %-15s\n",
                    "ID", " Name", "Color", "Price", "Brand", "Type/Speed", "YOM/Licence", "Message");
            System.out.println("==========================================================================================================================================="
                    + "===============================================================================================================================");
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).display();
            }
        }
    }

    @Override
    public void search() {
        Menu submenu = new Menu();
        submenu.addItem("1. Search by Name");
        submenu.addItem("2. Search by ID");
        submenu.showMenu();
        int choice = Utils.getInt("Enter your choice: ", 1, 2);
        switch (choice) {
            case 1: {
                String name = Utils.getString("Enter the name to search: ");
                this.searchByName(name);
                break;
            }
            case 2: {
                String id = Utils.getString("Enter the id to search: ");
                this.searchByID(id);
                break;
            }
        }
    }

    @Override
    public void showAll() {
        for (int i = 0; i < this.size(); i++) {
            this.get(i).display();
        }
    }

    @Override
    public void showByPrice() {
        VehicleList list = new VehicleList();
        Collections.sort(list);
        for (int i = 0; i < this.size(); i++) {
            this.get(i).display();
            //this.makeSound(this.get(i));
        }
    }

    @Override
    public void show() {
        Menu submenu = new Menu();
        submenu.addItem("1.Show all");
        submenu.addItem("2.Show all( decreasing by price:)");
        submenu.showMenu();
        int choice = Utils.getInt("Enter your choice: ", 1, 2);
        switch (choice) {
            case 1: {
                System.out.printf("%-20s %-40s %-20s %-20s %-30s %-20s %-20s %-15s\n",
                        "ID", " Name", "Color", "Price", "Brand", "Type/Speed", "YOM/Licence", "Message");
                System.out.println("==========================================================================================================================================="
                        + "===============================================================================================================================");
                this.showAll();
                break;
            }
            case 2: {
                System.out.printf("%-20s %-40s %-20s %-20s %-30s %-20s %-20s %-15s\n",
                        "ID", " Name", "Color", "Price", "Brand", "Type/Speed", "YOM/Licence", "Message");
                System.out.println("==========================================================================================================================================="
                        + "==================================================================================================================");
                this.showByPrice();
                break;
            }
        }
        System.out.println();
    }
    // @Override

    @Override
    public void storeToFile(String filename) throws IOException {
        if (this.size() == 0) {
            System.out.println("Empty List");
            return;
        }
        File f = new File(filename);
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);
        try {
            for (Vehicles vehicle : this) {
                if (vehicle instanceof Motorbike) {
                    Vehicles vehicle1 = new Motorbike();
                    vehicle1 = vehicle;
                    pw.println(vehicle1.toString());
                } else if (vehicle instanceof Car) {
                    Vehicles vehicle2 = new Car();
                    vehicle2 = vehicle;
                    pw.println(vehicle2.toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Print complete");
            fw.close();
            pw.close();
        }
    }

    @Override
    public void loadData(String filename) throws FileNotFoundException, IOException {
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        BufferedReader bf = new BufferedReader(fr);
        String details;
        Vehicles vehicle = null;
        try {
            if (!f.exists()) {
                return;
            }
            while ((details = bf.readLine()) != null && !details.isEmpty()) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String typeVehicle = stk.nextToken();
                //Attributes
                String id = stk.nextToken();
                String name = stk.nextToken();
                String color = stk.nextToken();
                int price = Integer.parseInt(stk.nextToken());
                String brand = stk.nextToken();
                if (typeVehicle.equalsIgnoreCase("Car")) {
                    // Car attributes
                    String type = stk.nextToken();
                    int yearOfManufacture = Integer.parseInt(stk.nextToken());
                    //Object will add
                    vehicle = new Car(type, yearOfManufacture, id, name, color, price, brand);
                } else if (typeVehicle.equalsIgnoreCase("Motorbike")) {
                    //Motorbike attributes
                    int speed = Integer.parseInt(stk.nextToken());
                    boolean license = Boolean.parseBoolean(stk.nextToken());
                    //Object will add
                    vehicle = new Motorbike(speed, license, id, name, color, price, brand);
                }
                //add to list
                this.add(vehicle);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            bf.close();
            fr.close();
        }
    }

}
