package Item;

public class WomanLotionBuilder implements IBuilder {
    Lotion lotion;  //association

    public WomanLotionBuilder() {
        this.lotion = new Lotion("Woman Item.Lotion", 30.40);
    }

    public void buildMixChemical() {
        this.lotion.setLiquid("Woman fragance");
    }

    public void buildFillContainer() {
        this.lotion.setContainer("Woman continer");
    }
    public void buildPackProduct() {
        this.lotion.setBox("Woman package");
    }

    public Lotion getLotion() {
        return this.lotion;
    }
}


