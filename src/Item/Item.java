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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Item(String name, double price, int currentQuantity, int soldQuantity, int boughtQuantity) {
        this.name = name;
        this.price = price;
        this.currentQuantity = currentQuantity;
        this.soldQuantity = soldQuantity;
        this.boughtQuantity = boughtQuantity;
    }



}
