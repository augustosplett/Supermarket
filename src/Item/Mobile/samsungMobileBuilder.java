package Item.Mobile;

import Item.Item;

public class samsungMobileBuilder implements IMobileBuilder
{
    private Mobile mobile;

    @Override
    public void assembleMobile() {
        this.mobile = new Mobile();
        mobile.setMake("Samsung");
        mobile.setModel("Galaxy S23 Pro");
    }

    @Override
    public void packMobile(int quantity) {
        this.mobile.setItem(new Item(mobile.getMake() + " " + mobile.getModel(), 1300, quantity, 0, 0));
    }
    @Override
    public Mobile getMobile()
    {
        return this.mobile;
    }
}
