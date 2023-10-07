package Item.Lotion;

public class WomanLotionBuilder implements IBuilder {
    Lotion lotion;  //association

    public WomanLotionBuilder(int quantity) {
        this.lotion = new Lotion("Lotion for Ladies", 30.40, quantity);
    }

    public void buildMixChemical() {
        this.lotion.setLiquid("Woman fragrance");
    }

    public void buildFillContainer() {
        this.lotion.setContainer("Woman container");
    }
    public void buildPackProduct() {
        this.lotion.setBox("Woman package");
    }

    public Lotion getLotion() {
        return this.lotion;
    }
}


