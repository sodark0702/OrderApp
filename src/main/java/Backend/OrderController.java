//package Order_Delivery_Management_System;
//
//import java.util.*;
//
//public class OrderController {
//    private IOrderRepository orderRepo;
//
//    public OrderController(IOrderRepository repo) {
//        this.orderRepo = repo;
//    }
//
//    public boolean confirmOrder(String id) {
//        Order o = orderRepo.findOrderByID(id);
//        if (o != null && o.getState().getStatus().equals("Pending")) {
//            o.changeState(new ConfirmState());
//            return true;
//        }
//        return false;
//    }
//
//    public boolean assignDriver(String id, Driver driver) {
//        Order o = orderRepo.findOrderByID(id);
//        if (o != null && o.getState().getStatus().equals("Confirmed")) {
//            o.assignDriver(driver);
//            o.changeState(new ConveyState());
//            return true;
//        }
//        return false;
//    }
//
//    public boolean completeOrder(String id) {
//        Order o = orderRepo.findOrderByID(id);
//        if (o != null && o.getState().getStatus().equals("Conveying")) {
//            o.changeState(new DeliveredState());
//            return true;
//        }
//        return false;
//    }
//
//    public List<Order> getAllOrder() {
//        return orderRepo.getAllOrder();
//    }
//
//    public Order findOrderById(String id) {
//        return orderRepo.findOrderByID(id);
//    }
//}
//
//
// OrderController.java
package Backend;

import java.util.*;

public class OrderController {
    private IOrderRepository orderRepo;
    // Thêm một reference đến IUserRepository nếu orderRepo của bạn không phải là FakeDatabase trực tiếp
    // Hoặc nếu FakeDatabase implement cả hai interface.
    // Trong trường hợp này, FakeDatabase implements cả hai, nên có thể ép kiểu.

    public OrderController(IOrderRepository repo) {
        this.orderRepo = repo;
    }

    // Getter để EmployeeView có thể truy cập IUserRepository
    public IOrderRepository getOrderRepo() {
        return orderRepo;
    }

    public boolean confirmOrder(String id) {
        Order o = orderRepo.findOrderByID(id);
        if (o != null && o.getState().getStatus().equals("Pending")) {
            o.changeState(new ConfirmState());
            return true;
        }
        return false;
    }

    public boolean assignDriver(String id, Driver driver) {
        Order o = orderRepo.findOrderByID(id);
        if (o != null && o.getState().getStatus().equals("Confirmed")) {
            o.assignDriver(driver);
            o.changeState(new ConveyState());
            return true;
        }
        return false;
    }

    public boolean completeOrder(String id) {
        Order o = orderRepo.findOrderByID(id);
        if (o != null && o.getState().getStatus().equals("Conveying")) {
            o.changeState(new DeliveredState());
            return true;
        }
        return false;
    }

    public List<Order> getAllOrder() {
        return orderRepo.getAllOrder();
    }

    public Order findOrderById(String id) {
        return orderRepo.findOrderByID(id);
    }
}