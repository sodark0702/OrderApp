package Backend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DriverView extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private OrderController controller;
    private Driver driver;

    public DriverView(OrderController controller) { // Nhận OrderController qua constructor
        this.controller = controller;
        setTitle("Driver - Order delivery");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        driver = (Driver) SessionManager.getInstance().getCurrentUser();

        model = new DefaultTableModel(new String[]{"Order id", "State", "Customer"}, 0); // Thêm cột Khách hàng
        table = new JTable(model);

        refreshAssignedOrders(); // Tải và hiển thị các đơn hàng được giao

        JButton deliverBtn = new JButton("Delivered");
        JButton viewDetailBtn = new JButton("View Order's Details");
        JButton logoutBtn = new JButton("Logout");

        deliverBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                String id = (String) model.getValueAt(row, 0);
                boolean ok = controller.completeOrder(id); // Gọi completeOrder
                if (ok) {
                    refreshAssignedOrders(); // Làm mới danh sách sau khi cập nhật
                } else {
                    JOptionPane.showMessageDialog(this, "This order status cannot be updated!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select the order to update!");
            }
        });

        logoutBtn.addActionListener(e -> {
            SessionManager.getInstance().logout();
            new LoginView(new UserController((IUserRepository) controller.getOrderRepo()), controller).setVisible(true); // Truyền lại OrderController
            dispose();
        });
        
        viewDetailBtn.addActionListener(e -> showOrderDetail());

        JPanel panel = new JPanel();
        panel.add(deliverBtn);
        panel.add(viewDetailBtn);
        panel.add(logoutBtn);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    // Phương thức để làm mới danh sách đơn hàng được giao
    private void refreshAssignedOrders() {
        model.setRowCount(0); // Xóa tất cả các hàng hiện có
        // Lấy lại danh sách đơn hàng được gán cho tài xế từ database (qua controller)
        // để đảm bảo trạng thái mới nhất
        List<Order> assignedOrders = driver.getAssignedOrders();
        for (Order o : assignedOrders) {
            // Lấy trạng thái mới nhất của đơn hàng từ database
            Order currentOrder = controller.findOrderById(o.getOrderID());
            if (currentOrder != null && currentOrder.getDriver() != null && currentOrder.getDriver().getID().equals(driver.getID())) {
                 model.addRow(new Object[]{currentOrder.getOrderID(), currentOrder.getState().getStatus(), currentOrder.getCustomer().getName()});
            }
        }
    }
    
    private void showOrderDetail() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String orderId = (String) model.getValueAt(selectedRow, 0);
            Order order = controller.findOrderById(orderId); // Sử dụng OrderController để tìm đơn hàng

            if (order != null) {
                StringBuilder sb = new StringBuilder("Invoice details:\n");
                sb.append("Order id: ").append(order.getOrderID()).append("\n");
                sb.append("Customer: ").append(order.getCustomer().getName()).append("\n");
                sb.append("State: ").append(order.getState().getStatus()).append("\n\n");
                sb.append("Orders:\n");
                for (OrderItem item : order.getOrderItem()) {
                    Product p = item.getProduct();
                    sb.append("- ").append(p.getName())
                      .append(" x").append(item.getQuantity())
                      .append(" | Price: ").append(String.format("%,.0f VNĐ", p.getPrice()))
                      .append(" | Total: ").append(String.format("%,.0f VNĐ", item.getSubtotal())).append("\n");
                }
                sb.append("\n-----------------------------------\n");
                sb.append("Total Price: ").append(String.format("%,.0f VNĐ", order.getTotalPrice())).append("\n");
                sb.append("Delivery Fee: ").append(String.format("%,.0f VNĐ", order.getDeliveryFee())).append("\n");
                sb.append("Total Payment: ").append(String.format("%,.0f VNĐ", order.getTotalPrice() + order.getDeliveryFee())).append("\n");
                
                // Thêm thông tin tài xế nếu đã được chỉ định
                if (order.getDriver() != null) {
                    sb.append("Designated driver: ").append(order.getDriver().getName()).append("\n");
                } else {
                    sb.append("No driver assigned yet!\n");
                }
                sb.append("Order's create date: ").append(order.getCreateDate().toLocalDate()).append("\n"); // Chỉ in ngày
                sb.append("Order's create time: ").append(order.getCreateDate().toLocalTime()).append("\n"); // Chỉ in thời gian


                JOptionPane.showMessageDialog(this, sb.toString(), "Order details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "This order was not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an order in the table to view details!", "Notification", JOptionPane.WARNING_MESSAGE);
        }
    }
}