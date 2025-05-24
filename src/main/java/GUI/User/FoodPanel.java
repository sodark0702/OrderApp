package GUI.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FoodPanel extends JPanel {
    public FoodPanel() {
        // Thiết lập layout chính và viền cho panel
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230))); // Viền xanh nhạt

        // Panel cho phần trên (hình ảnh và văn bản)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        // Thêm hình ảnh
        ImageIcon imageIcon = new ImageIcon("D:\\Picture\\z6191116983543_5ed08a62d83e3795cbb0b5130065f9e4.jpg"); // Thay bằng đường dẫn thực tế
        Image image = imageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // Điều chỉnh kích thước
        imageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon);
        topPanel.add(imageLabel, BorderLayout.WEST);

        // Thêm văn bản "Food name"
        JLabel nameLabel = new JLabel("Food name");
        nameLabel.setForeground(Color.GRAY);
        topPanel.add(nameLabel, BorderLayout.CENTER);

        // Thêm panel trên vào layout chính
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(topPanel, BorderLayout.CENTER);

        // Panel cho nút ở góc dưới
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));


        // Thêm nút "Delivered"
        JButton deliveredButton = new JButton("Delivered");
        deliveredButton.setBackground(new Color(0, 120, 215)); // Màu xanh cho nút
        deliveredButton.setForeground(Color.WHITE);
        deliveredButton.setFocusPainted(false);
        bottomPanel.add(deliveredButton);

        // Thêm panel dưới vào layout chính
        add(bottomPanel, BorderLayout.SOUTH);

        // Thiết lập kích thước panel
        setPreferredSize(new Dimension(400, 150));
    }

}
