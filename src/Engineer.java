public class Engineer {

    Builder Builder ;

    Engineer(Builder Builder ){
        this.Builder = Builder;

    }
    void createLotion(){
        Builder.buildMixQuemical();
        Builder.buildFillContainer();
        Builder.buildPackProduct();
    }

    Lotion getLotion(){
        return Builder.getLotion();
    }
}




