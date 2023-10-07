package Item.Bike;

public abstract class CrossBike implements BuilderBike{


    Bicycle bicycle;

    public CrossBike(){
        this.bicycle= new Bicycle("CrossBike", 89.4);
    }

    public void assemblyBreaks(){}

    public void assemblyFrame(){}

    public void assemblyGears(){}

    public void assemblyWheels(){}

    public void assemblyTire(){}

}

