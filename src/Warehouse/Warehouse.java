package Warehouse;

import java.util.ArrayList;

public class Warehouse {

    ArrayList<Item> itemsProperty;
    ////<type> NAME OF VARIABLE

    public Warehouse() {
        this.itemsProperty = new ArrayList<Item>();
    }

    public void addItem(Item itemParam) {
        itemsProperty.add(itemParam);
    } //method to add items in the array

    public void removeItem(Item itemParam) {
        itemsProperty.remove(itemParam);
    } ///method to remove items in the array

    public void displayItems() {
        for(Item itemVariable: itemsProperty)
            System.out.println("name: " +itemVariable.getName()+ "Price: " + itemVariable.getPrice());   /// Display each student in the array
    }

}

