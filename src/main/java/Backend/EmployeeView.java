package Backend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeView extends JFrame {
	private JTable table;
	private DefaultTableModel model;
	private OrderController controller;
	private IUserRepository userRepo; // Cần lấy driver từ userRepo

	public EmployeeView(OrderController controller) { // Nhận OrderController qua constructor
		this.controller = controller;
		this.userRepo = (IUserRepository) controller.getOrderRepo(); // Giả định OrderController có thể cung cấp
																		// IUserRepository hoặc bạn truyền thêm

		setTitle("Employee - Order Management");
		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		model = new DefaultTableModel(new String[] { "Order id", "State", "Customer", "Driver" }, 0); // Thêm cột
																											// Driver
		table = new JTable(model);

		refreshOrderList(); // Gọi phương thức để tải và hiển thị danh sách đơn hàng

		JButton confirmBtn = new JButton("Browse Order");
		JButton assignBtn = new JButton("Assign Driver");
		JButton reportBtn = new JButton("Today's Report");
		JButton viewDetailBtn = new JButton("View Order's Details");
		JButton logoutBtn = new JButton("Logout");

		confirmBtn.addActionListener(e -> updateState("confirm"));
		assignBtn.addActionListener(e -> updateState("assign"));
		reportBtn.addActionListener(e -> showTodayReport());
		viewDetailBtn.addActionListener(e -> showOrderDetail());
		logoutBtn.addActionListener(e -> {
			SessionManager.getInstance().logout();
			new LoginView(new UserController((IUserRepository) controller.getOrderRepo()), controller).setVisible(true); // Truyền
																															// lại
																															// OrderController
			dispose();
		});

		JPanel panel = new JPanel();
		panel.add(confirmBtn);
		panel.add(assignBtn);
		panel.add(reportBtn);
		panel.add(viewDetailBtn);
		panel.add(logoutBtn);

		add(new JScrollPane(table), BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}

	private void updateState(String action) {
		int row = table.getSelectedRow();
		if (row >= 0) {
			String id = (String) model.getValueAt(row, 0);
			boolean success = false;
			if (action.equals("confirm")) {
				success = controller.confirmOrder(id);
			} else if (action.equals("assign")) {
				// Lấy danh sách tài xế để nhân viên chọn (hoặc gán cứng một tài xế mẫu)
				// Hiện tại đang gán cứng Driver d1. Trong thực tế, bạn sẽ có một danh sách tài
				// xế
				List<Driver> drivers = userRepo.getAllUser().stream().filter(user -> user instanceof Driver)
						.map(user -> (Driver) user).collect(Collectors.toList());

				if (drivers.isEmpty()) {
					JOptionPane.showMessageDialog(this, "No drivers available to assign!");
					return;
				}

				// Create an array of driver names for the dialog
				String[] driverNames = drivers.stream().map(Driver::getName).toArray(String[]::new);

				String selectedDriverName = (String) JOptionPane.showInputDialog(this, "Select a driver:",
						"Assign Driver", JOptionPane.QUESTION_MESSAGE, null, driverNames, driverNames[0]);

				if (selectedDriverName != null) {
					Driver selectedDriver = drivers.stream().filter(d -> d.getName().equals(selectedDriverName))
							.findFirst().orElse(null);
					if (selectedDriver != null) {
						success = controller.assignDriver(id, selectedDriver);
					} else {
						JOptionPane.showMessageDialog(this, "Selected driver not found!");
					}
				} else {
					// User canceled the dialog
					return;
				}
			}
			if (success) {
				refreshOrderList(); // Refresh lại bảng sau khi cập nhật trạng thái
			} else {
				JOptionPane.showMessageDialog(this, "This action cannot be performed.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please select order!");
		}
	}

	private void showTodayReport() {
		IReportService report = new ReportService(controller.getOrderRepo()); // Dùng repo từ controller
		StringBuilder sb = new StringBuilder("Today's order report:\n");

		for (Order o : report.getOrdersForToday()) {
			sb.append("- ").append(o.getOrderID()).append(" | ").append(o.getCustomer().getName()).append(" | ")
					.append(o.getState().getStatus()).append("\n");
		}

		JOptionPane.showMessageDialog(this, sb.toString(), "Today's Report", JOptionPane.INFORMATION_MESSAGE);
	}

	// Phương thức để làm mới bảng đơn hàng
	private void refreshOrderList() {
		model.setRowCount(0); // Xóa tất cả các hàng hiện có
		List<Order> allOrders = controller.getAllOrder();
		for (Order o : allOrders) {
			String driverName = (o.getDriver() != null) ? o.getDriver().getName() : "Not assigned yet!";
			model.addRow(
					new Object[] { o.getOrderID(), o.getState().getStatus(), o.getCustomer().getName(), driverName });
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
					sb.append("- ").append(p.getName()).append(" x").append(item.getQuantity()).append(" | Price: ")
							.append(String.format("%,.0f VNĐ", p.getPrice())).append(" | Total: ")
							.append(String.format("%,.0f VNĐ", item.getSubtotal())).append("\n");
				}
				sb.append("\n-----------------------------------\n");
				sb.append("Total Price: ").append(String.format("%,.0f VNĐ", order.getTotalPrice())).append("\n");
				sb.append("Delivery Fee: ").append(String.format("%,.0f VNĐ", order.getDeliveryFee())).append("\n");
				sb.append("Total Payment: ")
						.append(String.format("%,.0f VNĐ", order.getTotalPrice() + order.getDeliveryFee()))
						.append("\n");

				// Thêm thông tin tài xế nếu đã được chỉ định
				if (order.getDriver() != null) {
					sb.append("Designated driver: ").append(order.getDriver().getName()).append("\n");
				} else {
					sb.append("No driver assigned yet!\n");
				}
				sb.append("Order's create date: ").append(order.getCreateDate().toLocalDate()).append("\n"); // Chỉ in
																												// ngày
				sb.append("Order's create time: ").append(order.getCreateDate().toLocalTime()).append("\n"); // Chỉ in
																												// thời
																												// gian

				JOptionPane.showMessageDialog(this, sb.toString(), "Order details",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "This order was not found!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please select an order in the table to view details!", "Notification",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}