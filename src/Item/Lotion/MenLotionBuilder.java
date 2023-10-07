package Item.Lotion;

public class MenLotionBuilder implements IBuilder {
    Lotion lotion;  //association
    public MenLotionBuilder(int quantity){
        this.lotion = new Lotion("Lotion for Men" , 25.30, quantity);
    }
    public void buildMixChemical(){
        this.lotion.setLiquid("Men fragrance");
    }
    public void buildFillContainer(){
        this.lotion.setContainer("Men Container");
    }
    public void buildPackProduct(){
        this.lotion.setBox("Men package");
    }
    public Lotion getLotion(){
        return this.lotion;
    }
}

