public class WomanLotionBuilder implements Builder {
    Lotion lotion;  //association

    WomanLotionBuilder() {
        this.lotion = new Lotion("Woman Lotion", 30.40);
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


