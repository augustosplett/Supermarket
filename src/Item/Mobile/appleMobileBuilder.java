package Item.Mobile;

import Item.Item;

public class appleMobileBuilder implements IMobileBuilder
{
    private Mobile mobile;

    @Override
    public void assembleMobile() {
        this.mobile = new Mobile();
        mobile.setMake("Apple");
        mobile.setModel("iPhone 15 pro max");
    }

    @Override
    public void packMobile( int quantity ) {
        this.mobile.setItem(new Item(mobile.getMake() + " " + mobile.getModel(), 1600, quantity, 0, 0));
    }
    @Override
    public Mobile getMobile()
    {
        return this.mobile;
    }
}
