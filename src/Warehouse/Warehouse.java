package Warehouse;

import Item.Item;
import java.util.ArrayList;

public class Warehouse {

    public ArrayList<Item> inventory;

    public Warehouse() {
        this.inventory = new ArrayList<Item>();
    }

    public void addItem(Item itemParam) {
        inventory.add(itemParam);
    } //method to add items in the array

    public void availableItemsWithQuantityTable(){
        String tableFormat = "| %-2d | %-41s | %-7.2f | %-4d |%n";

        System.out.format("+----+-------------------------------------------+---------+------+%n");
        System.out.format("| ID | ITEM NAME                                 | PRICE   | QTDE |%n");
        System.out.format("+----+-------------------------------------------+---------+------+%n");
        var i = 0;
        for(Item item : inventory){

            System.out.format(tableFormat,
                    i += 1,
                    item.getName(),
                    item.getPrice(),
                    item.getCurrentQuantity());

        }
        System.out.format("+----+-------------------------------------------+---------+------+%n");
    }

    public void availableItemsDetailedTable(){
        String tableFormat = "| %-2d | %-41s | %-7.2f | %-13d | %-13d | %-13d |%n";

        System.out.format("+----+-------------------------------------------+---------+---------------+---------------+---------------+%n");
        System.out.format("| ID | ITEM NAME                                 | PRICE   |  CURRENT QTDE | SOLD QTDE     |   BOUGHT QTDE |%n");
        System.out.format("+----+-------------------------------------------+---------+---------------+---------------+---------------+%n");
        var i = 0;
        for(Item item : inventory){

            System.out.format(tableFormat,
                    i += 1,
                    item.getName(),
                    item.getPrice(),
                    item.getCurrentQuantity(),
                    item.getSoldQuantity(),
                    item.getBoughtQuantity());

        }
        System.out.format("+----+-------------------------------------------+---------+---------------+---------------+---------------+%n");

    }
    public void buyItem(Warehouse originWarehouse, Item itemToBuy, int quantity){

        try{
            //find the desired item on the origin warehouse
            var itemOnOriginWarehouse = findItemOnWarehouse(originWarehouse, itemToBuy);
            //if the warehouse have enough quantity
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
                System.out.println("Item Purchased!");
            }else {
                System.out.println("Quantity not available!");
            }
        }catch (Exception e){
            //System.out.println(e.getMessage());
        }
    }
    public void sellAllInventory(){
        for(Item item : this.inventory){
            var availableQtde = item.getCurrentQuantity();
            item.itemSold(availableQtde);
        }
    }
    public Item findItemOnWarehouse(Warehouse warehouse, Item item){
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

