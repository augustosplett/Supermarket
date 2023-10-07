package Warehouse;

import Item.Item;
import java.util.ArrayList;

public class Warehouse {

    ArrayList<Item> inventory;

    public Warehouse() {
        this.inventory = new ArrayList<Item>();
    }

    public void addItem(Item itemParam) {
        inventory.add(itemParam);
    } //method to add items in the array

    public void displayItems() {
        for(Item itemVariable: inventory)
            System.out.println("Name: " + itemVariable.getName()
                    + " Price: " + itemVariable.getPrice()
                    + " Current Quantity: " + itemVariable.getCurrentQuantity()
                    + " Sold Quantity: " + itemVariable.getSoldQuantity()
                    + " Bought Quantity: " + itemVariable.getBoughtQuantity()
            );/// Display each student in the array
    }

    public void availableItemsWithQuantityTable(){
        String tableFormat = "| %-2d | %-15s | %-7.2f | %-4d |%n";

        System.out.format("+----+-----------------+---------+------+%n");
        System.out.format("| ID | ITEM NAME       | PRICE   | QTDE |%n");
        System.out.format("+----+-----------------+---------+------+%n");
        var i = 0;
        for(Item item : inventory){
            if(item.getCurrentQuantity() > 0){
                System.out.format(tableFormat,
                        i += 1,
                        item.getName(),
                        item.getPrice(),
                        item.getCurrentQuantity());
            }
        }
        System.out.format("+----+-----------------+---------+------+%n");

    }

    public void buyItem(Warehouse originWarehouse, Item itemToBuy, int quantity){

        try{
            var itemOnOriginWarehouse = findItemOnWarehouse(originWarehouse, itemToBuy);
            if (itemOnOriginWarehouse.getCurrentQuantity() >= quantity){
                //move the item on the origin warehouse
                itemOnOriginWarehouse.itemSold(quantity);
                try{
                    //move the item on the destination warehouse
                    var itemOnDestinationWarehouse = findItemOnWarehouse(this, itemToBuy);
                    itemOnDestinationWarehouse.itemBought(quantity);
                }catch (Exception e){
                    //if there is an error, it means that the final warehouse doesn't have the item yet, so I create it
                    this.inventory.add(new Item(itemOnOriginWarehouse.getName(),
                            itemOnOriginWarehouse.getPrice(),
                            quantity,
                            0,
                            quantity));
                }
            }
        }catch (Exception e){
            //System.out.println(e.getMessage());
        }
    }

    private Item findItemOnWarehouse(Warehouse warehouse, Item item){
        return warehouse.inventory.stream()
                .filter( product -> item.getName().equals(product.getName()))
                .findAny()
                .orElse(null);
    }

    public int getItemsSold(){
        int quantity = 0;
        for(Item item : inventory){
            quantity += item.getSoldQuantity();
        }
        return quantity;
    }

    public int getItemsBought(){
        int quantity = 0;
        for(Item item : inventory){
            quantity += item.getBoughtQuantity();
        }
        return quantity;
    }
}

