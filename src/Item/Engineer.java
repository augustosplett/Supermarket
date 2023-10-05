package Item;

import Item.IBuilder;

public class Engineer {

    IBuilder builder ;

    public Engineer(IBuilder builder){
        this.builder = builder;

    }
    public void createLotion(){
        builder.buildMixChemical();
        builder.buildFillContainer();
        builder.buildPackProduct();
    }

    public Lotion getLotion(){
        return builder.getLotion();
    }
}




