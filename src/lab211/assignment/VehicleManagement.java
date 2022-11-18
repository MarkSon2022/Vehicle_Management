package lab211.assignment;

import java.io.IOException;
import lab211.vehicles.Vehicles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* This is comment, do not delete 2021.11.31
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class VehicleManagement {

    public static void main(String args[]) throws IOException {
        I_Menu menu = new Menu();
        // ađd menu here
        menu.addItem("Menu: ");
        menu.addItem("1. Add new vehicle");
        menu.addItem("2. Update new vehicle");
        menu.addItem("3. Delete vehicle");
        menu.addItem("4. Search Vehicle");
        menu.addItem("5. Show list");
        menu.addItem("6. Store data in file");
        menu.addItem("7. Quit");
        int choice;
        boolean cont = false;
        VehicleList veList = new VehicleList();     
        veList.loadData("src\\vehicles.txt");
        
        do {           
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1: {
                    veList.addVehicles();
                    break;
                }
                case 2: {
                    veList.updateByID();
                    break;
                }
                case 3: {
                    veList.deleteByID();
                    break;
                }
                case 4: {
                    veList.search();
                    break;
                }
                case 5: {
                    veList.show();
                    break;
                }
                case 6: {
                    String filename = "src\\vehicles.txt";
                    veList.storeToFile(filename);
                    break;
                }
                case 7:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N): ");                   
                    break;
            }
        } while (!cont);  
    }
}
