package GUI.User;

import java.util.*;

public class FakeDataBase {
    List<Order> orders;

    public FakeDataBase() {
        this.orders = new ArrayList<>();

        Order o1 = new Order("Thit chien nuoc mam", "Nhung chang trai");
        o1.setDelivery(true);
        Order o2 = new Order("Thit chien nuoc mam", "Nhung chang trai");
        o2.setDelivery(true);
        Order o3 = new Order("Thit chien nuoc mam", "Nhung chang trai");
        o3.setDelivery(true);
        Order o4 = new Order("Thit chien nuoc mam", "Nhung chang trai");
        o4.setDelivery(true);

        Order o5 = new Order("Thit chien nuoc mam", "Nhung chang trai");
        o4.setConvey(true);
        Order o6 = new Order("Thit chien nuoc mam", "Nhung chang trai");
        o4.setConvey(true);
        Order o7 = new Order("Thit chien nuoc mam", "Nhung chang trai");
        o4.setConvey(true);
        Order o8 = new Order("Thit chien nuoc mam", "Nhung chang trai");
        o4.setConvey(true);
        Order o9 = new Order("Thit chien nuoc mam", "Nhung chang trai");
        o4.setConvey(true);


        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        orders.add(o4);
        orders.add(o5);
        orders.add(o6);
        orders.add(o7);
        orders.add(o8);
        orders.add(o9);

    }

}
