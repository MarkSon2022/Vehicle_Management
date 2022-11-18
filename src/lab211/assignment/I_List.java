package lab211.assignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import lab211.vehicles.Vehicles;

/* Interface for a group of objects
 */
/**
 *
 * @author Hoa Doan
 */
public interface I_List {
    // your code here
    // public ArrayList<Vehicles> loadData(String filename);

    public void addVehicles();

    public void updateByID();

    public void deleteByID();

    public void searchByID(String id);

    public void searchByName(String name);

    public void search();

    public Vehicles searchID(String id);

    public void showAll();

    public void showByPrice();

    public void show();

    public void loadData(String filename) throws FileNotFoundException, IOException;

    public void storeToFile(String filename) throws IOException;

}
