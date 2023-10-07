package Item;

public class Item {

    private String name;
    private double price;
    private int currentQuantity;
    private int soldQuantity;
    private int boughtQuantity;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.currentQuantity = 0;
        this.boughtQuantity = 0;
        this.soldQuantity = 0;
    }

    public Item(String name, double price, int currentQuantity, int soldQuantity, int boughtQuantity) {
        this.name = name;
        this.price = price;
        this.currentQuantity = currentQuantity;
        this.soldQuantity = soldQuantity;
        this.boughtQuantity = boughtQuantity;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public int getBoughtQuantity() {
        return boughtQuantity;
    }

    public void setBoughtQuantity(int boughtQuantity) {
        this.boughtQuantity = boughtQuantity;
    }

    public void itemSold( int quantity){
        this.setCurrentQuantity(this.getCurrentQuantity() - quantity);
        this.setSoldQuantity(this.getSoldQuantity() + quantity);
    }

    public void itemBought( int quantity){
        this.setBoughtQuantity(this.getBoughtQuantity() + quantity);
        this.setCurrentQuantity(this.getCurrentQuantity() + quantity);
    }
}
