public class MenLotionBuilder implements Builder{
    Lotion lotion;  //association
     MenLotionBuilder(){
        this.lotion = new Lotion("Men Lotion " , 25.30);
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
    public Lotion  getLotion(){
        return this.lotion;
    }
}

