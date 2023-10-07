package Item.Mobile;

public class ProductionDirector
{

    private IMobileBuilder iMobileBuilder;

    public ProductionDirector(IMobileBuilder iMobileBuilder)
    {
        this.iMobileBuilder = iMobileBuilder;
    }

    public Mobile getMobile()
    {
        return this.iMobileBuilder.getMobile();
    }

    public void constructMobile( int quantity )
    {
        this.iMobileBuilder.assembleMobile();
        this.iMobileBuilder.packMobile(quantity);

    }
}
