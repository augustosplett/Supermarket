package Item;

public class MenLotionBuilder implements IBuilder{
    Lotion lotion;  //association
     public MenLotionBuilder(){
        this.lotion = new Lotion("Men Item.Lotion " , 25.30);
    }
    public void buildMixChemical(){
        this.lotion.setLiquid("Men fragance");
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

