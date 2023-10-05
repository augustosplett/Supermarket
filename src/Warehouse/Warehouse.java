package Warehouse;

import Account.CheckingAccount;
import Account.StatementMovement;
import Account.TransactionType;
import Item.Item;
import java.util.ArrayList;
import java.util.Objects;

public class Warehouse {
    public CheckingAccount account = new CheckingAccount(5000);
    ArrayList<Item> inventory;
    ////<type> NAME OF VARIABLE

    public Warehouse() {
        this.inventory = new ArrayList<Item>();
    }

    public void addItem(Item itemParam) {
        inventory.add(itemParam);
    } //method to add items in the array

    public void removeItem(Item itemParam) {
        inventory.remove(itemParam);
    } ///method to remove items in the array

    public void displayItems() {
        for(Item itemVariable: inventory)
            System.out.println("name: " +itemVariable.getName()
                    + " Price: " + itemVariable.getPrice()
                    + " Current Quantity: " + itemVariable.getCurrentQuantity()
                    + " Sold Quantity: " + itemVariable.getSoldQuantity()
                    + " Bought Quantity: " + itemVariable.getBoughtQuantity()
            );   /// Display each student in the array
    }

    public boolean isTheItemOnInventory(Warehouse origin, Item item){

        for(Item inventoryItem : origin.inventory){
            if(Objects.equals(inventoryItem.getName(), item.getName())) return true;
        }
        return false;
    }

    public boolean isTheItemAvailableToBuy(Warehouse origin, Item item){
        for(Item inventoryItem : origin.inventory){
            if(Objects.equals(inventoryItem.getName(), item.getName())){
                return inventoryItem.getCurrentQuantity() > 0;
            }
        }
        return false;
    }
    public void buyItems(Warehouse origin, Warehouse buyer, Item itemToBuy){
        if(isTheItemAvailableToBuy(origin, itemToBuy)){//check if the desired item is available to buy
            if(isTheItemOnInventory(buyer, itemToBuy)){//check if the desired item already exists on the buyer's warehouse
                buyItem(buyer, itemToBuy);//increase the quantity of the item on the buyers inventory
                soldItem(origin, itemToBuy);//decrease the quantity of the item on the buyers inventory
            }else{//if the item doesn't exist on the buyer warehouse, create a new one
                var myItem = new Item(itemToBuy.getName(), itemToBuy.getPrice(),1, 0, 1);
                buyer.inventory.add(myItem);//Add the new item to the inventory
                soldItem(origin, itemToBuy);//decrease the quantity of the item on the buyers inventory
            }
        }
        registerTransaction(buyer, itemToBuy);
    }

    private void registerTransaction(Warehouse buyer, Item item) {
        var transaction = new StatementMovement(TransactionType.BUY_PRODUCTS, item.getName(), item.getPrice() );
        buyer.account.SaveMovementToStatement(transaction);
    }

    private void soldItem(Warehouse origin, Item item){
        //find the item into the origin inventory and increase the sold number and reduce the available quantity
        Item itemToReduceQuantity = origin.inventory.stream()
                .filter( product -> item.getName().equals(product.getName()))
                .findAny()
                .orElse(null);
        itemToReduceQuantity.setSoldQuantity(itemToReduceQuantity.getSoldQuantity() + 1);
        itemToReduceQuantity.setCurrentQuantity(itemToReduceQuantity.getCurrentQuantity() - 1);
    }

    private void buyItem(Warehouse warehouse, Item item){
        //find the item into the origin inventory and increase the sold number and reduce the available quantity
        Item myItem = warehouse.inventory.stream()
                .filter( product -> item.getName().equals(product.getName()))
                .findAny()
                .orElse(null);
        myItem.setBoughtQuantity(myItem.getBoughtQuantity() + 1);
        myItem.setCurrentQuantity(myItem.getCurrentQuantity() + 1);
    }

}

