package Item;

public class Lotion extends Item {

    String mixQuemical;
    String fillContainer;
    String packProduct;

    Lotion(String name, Double price) {
        super(name, price);
    }

    String getMixQuemical() {
        return mixQuemical;
    }

    void setMixChemical(String mixQuemical) {
        this.mixQuemical = mixQuemical;
    }

    String getFillContainer() {
        return fillContainer;
    }

    void setFillContainer(String fillContainer) {
        this.fillContainer = fillContainer;
    }

    String getPackProduct() {
        return packProduct;
    }

    void setPackProduct(String packProduct) {
        this.packProduct = packProduct;
    }
    Lotion getLotion(){
        return this;
    }
    public void display(){
        System.out.println("Mix Quemicals : " + getMixQuemical());
        System.out.println("Fill Container : " + getFillContainer());
        System.out.println("Pack Product : " + getPackProduct());

    }

}