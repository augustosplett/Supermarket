package Item;

public class WomanLotionBuilder implements IBuilder {
    Lotion lotion;  //association

    public WomanLotionBuilder() {
        this.lotion = new Lotion("Woman Item.Lotion", 30.40);
    }

    public void buildMixQuemical() {
        this.lotion.setMixChemical("Woman fragance");
    }

    public void buildFillContainer() {
        this.lotion.setFillContainer("Woman continer");
    }
    public void buildPackProduct() {
        this.lotion.setPackProduct("Woman package");
    }

    public Lotion getLotion() {
        return this.lotion;
    }
}


