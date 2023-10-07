package Item.Bike;

import Item.Item;

public class Bicycle extends Item {
    String breaks;
    String seat;
    String frame;
    String gears;
    String wheel;
    String tire;
    String shifter;

    Bicycle getBicycle(){
        return this;
    }
    public Bicycle(String name, double price) {
        super(name, price);
        this.breaks= breaks;
        this.seat= seat;
        this.frame= frame;
        this.gears=gears;
        this.wheel=wheel;
        this.tire= tire;
        this.shifter=shifter;
    }





}


