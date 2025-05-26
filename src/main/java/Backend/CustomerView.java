package Backend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CustomerView extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private Customer customer;
    private OrderController orderController; // Thêm OrderController

    public CustomerView(OrderController orderController) { // Thêm tham số orderController
        this.orderController = orderController; // Gán orderController
        setTitle("Customer - Order List");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        customer = (Customer) SessionManager.getInstance().getCurrentUser();
        model = new DefaultTableModel(new String[]{"Order id", "State", "Total Price"}, 0);
        table = new JTable(model);

        // Lấy danh sách đơn hàng từ OrderController để đảm bảo đồng bộ
        // Thay vì customer.getOrders() chỉ lấy danh sách ban đầu của customer
        refreshOrderList(); 

        JButton detailBtn = new JButton("View Details");
        JButton logoutBtn = new JButton("Logout");

        detailBtn.addActionListener(e -> showDetail());
        logoutBtn.addActionListener(e -> {
            SessionManager.getInstance().logout();
            new LoginView(new UserController(new FakeDatabase()), orderController).setVisible(true); // Truyền lại OrderController
            dispose();
        });

        JPanel panel = new JPanel();
        panel.add(detailBtn);
        panel.add(logoutBtn);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    private void showDetail() {
      int selected = table.getSelectedRow();
      if (selected >= 0) {
          String id = (String) model.getValueAt(selected, 0);
          Order o = customer.getOrders().stream()
                  .filter(order -> order.getOrderID().equals(id)).findFirst().orElse(null);
          if (o != null) {
              StringBuilder sb = new StringBuilder("Order id: " + o.getOrderID() + "\nState: " + o.getState().getStatus() + "\n\n");
              for (OrderItem item : o.getOrderItem()) {
                  Product p = item.getProduct();
                  sb.append("- ").append(p.getName())
                    .append(" x").append(item.getQuantity())
                    .append(", Price: ").append(String.format("%,.0f VNĐ", p.getPrice()))
                    .append(", Total: ").append(String.format("%,.0f VNĐ", item.getSubtotal())).append("\n");
              }
              sb.append("\nTotal Price: ").append(String.format("%,.0f VNĐ", o.getTotalPrice()))
                .append("\nDelivery Fee: ").append(String.format("%,.0f VNĐ", o.getDeliveryFee()))
                .append("\nTotal Payment: ").append(String.format("%,.0f VNĐ", o.getTotalPrice() + o.getDeliveryFee()));
              JOptionPane.showMessageDialog(this, sb.toString(), "Order Details", JOptionPane.INFORMATION_MESSAGE);
          }
      } else {
          JOptionPane.showMessageDialog(this, "Please select 1 order to see details!");
      }
  }

    // Thêm phương thức để làm mới danh sách đơn hàng
    private void refreshOrderList() {
        model.setRowCount(0); // Xóa dữ liệu cũ
        List<Order> orders = customer.getOrders(); // Giữ nguyên cách lấy order của customer
        for (Order o : orders) {
            // Lấy trạng thái mới nhất từ database (thông qua controller)
            Order currentOrder = orderController.findOrderById(o.getOrderID()); 
            model.addRow(new Object[]{
                    currentOrder.getOrderID(), currentOrder.getState().getStatus(),
                    String.format("%,.0f VNĐ", currentOrder.getTotalPrice() + currentOrder.getDeliveryFee())
            });
        }
    }
}
