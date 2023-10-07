package Item.Bike;

public abstract class RoadBike implements BuilderBike{

    Bicycle bicycle;

    public RoadBike(){
        this.bicycle= new Bicycle("RoadBike", 105.4);
    }

    public void assemblyBreaks(){}

    public void assemblySeat(){}

    public void assemblyFrame(){}

    public void assemblyGears(){}

    public void assemblyWheels(){}

    public void assemblyTire(){}

    public void assemblyShifter(){}
}

