package Item.Lotion;

import Item.Item;

public class Lotion extends Item {

    private String liquid;
    private String container;
    private String box;

    Lotion(String name, Double price, int quantity) {
        super(name, price, quantity, 0, 0);
    }

    String getLiquid() {
        return liquid;
    }

     void setLiquid(String liquid) {
        this.liquid = liquid;
    }

     String getContainer() {
        return container;
    }

     void setContainer(String container) {
        this.container = container;
    }

   String getBox() {
        return box;
    }

   void setBox (String box) {
        this.box = box;
    }
    Lotion getLotion(){
        return this;
    }

    public void display(){
        System.out.println("Mix Quemicals : " + getLiquid());
        System.out.println("Fill Container : " + getContainer());
        System.out.println("Pack Product : " + getBox());

    }

}