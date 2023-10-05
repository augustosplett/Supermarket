package Item;

public class MenLotionBuilder implements IBuilder{
    Lotion lotion;  //association
     public MenLotionBuilder(){
        this.lotion = new Lotion("Men Item.Lotion " , 25.30);
    }
    public void buildMixQuemical(){
        this.lotion.setMixChemical("Men fragance");
    }
    public void buildFillContainer(){
        this.lotion.setFillContainer("Men Container");
    }
    public void buildPackProduct(){
        this.lotion.setPackProduct("Men package");
    }
    public Lotion getLotion(){
        return this.lotion;
    }
}

