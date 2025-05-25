package GUI.User;

public class Order {
    private String name;
    private String shopper;
    private String price;

    private boolean confirm = false; // trang thai da xac nhan don hang tu chu shop
    private boolean convey = false; // trang thai dang giao
    private boolean delivery = false; // trang thai giao hang
    private boolean cancel = false;


    public Order(String name, String shopper) {
	    this.name = name;
	    this.shopper = shopper;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isConfirm() {
	    return this.confirm;
    }

    public boolean isConvey() {
	    return this.convey;
    }

    public boolean isDelivery() {
	    return this.delivery;
    }

    public boolean isCancel() {
        return this.cancel;
    }

    public String getName() {
        return name;
    }

    public String getShopper() {
        return shopper;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShopper(String shopper) {
        this.shopper = shopper;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public void setConvey(boolean convey) {
        this.convey = convey;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}
