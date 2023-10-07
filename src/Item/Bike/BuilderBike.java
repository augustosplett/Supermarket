package Item.Bike;

public interface BuilderBike {

    void assemblyBreaks();

    void assemblySeat();

    void assemblyFrame();

    void assemblyGears();

    void assemblyWheels();

    void assemblyTire();

    void assemblyShifter();

    Bicycle getBicycle();
}
