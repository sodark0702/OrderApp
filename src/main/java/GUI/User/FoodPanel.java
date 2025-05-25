package GUI.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FoodPanel extends JPanel {

    private String[] imageUri = {
            "D:\\Documents\\OrderApp\\src\\main\\asset\\Ace-dies-in-anime.jpg",
            "D:\\Documents\\OrderApp\\src\\main\\asset\\hq720.jpg",
            "D:\\Documents\\OrderApp\\src\\main\\asset\\maxresdefault.jpg",
            "D:\\Documents\\OrderApp\\src\\main\\asset\\the-thing-that-bothers-me-the-most-about-gojos-death-v0-matamfm59ctd1.jpg",
            "D:\\Documents\\OrderApp\\src\\main\\asset\\Zeke-and-Eren-head-in-Attack-on-Titan.jpg",
    };

    public FoodPanel(Order order) {
        // Thiết lập layout chính và viền cho panel
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230))); // Viền xanh nhạt

        // Panel cho phần trên (hình ảnh và văn bản)
        JPanel topPanel = new JPanel(new BorderLayout(10, 0));
        topPanel.setBackground(Color.WHITE);

        // Thêm hình ảnh
        int randomImageIndex = (int) (Math.random() * this.imageUri.length);
        ImageIcon imageIcon = new ImageIcon(this.imageUri[randomImageIndex]); // Thay bằng đường dẫn thực tế
        Image image = imageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // Điều chỉnh kích thước
        imageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon);
        topPanel.add(imageLabel, BorderLayout.WEST);

        // Thêm văn bản "Food name"
        JLabel nameLabel = new JLabel(order.getName());
        JPanel intoPanel = new JPanel();
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18 ));
        nameLabel.setForeground(Color.decode("#222222"));
        intoPanel.setBackground(Color.WHITE);
        intoPanel.setLayout(new BoxLayout(intoPanel, BoxLayout.Y_AXIS));
        JLabel storeName = new JLabel(order.getShopper());
        intoPanel.add(nameLabel);
        intoPanel.add(storeName);

        topPanel.add(intoPanel, BorderLayout.CENTER);

        // Thêm panel trên vào layout chính
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(topPanel, BorderLayout.CENTER);

        // Panel cho nút ở góc dưới
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.WHITE);


        // status button
        JLabel priceLabel = new JLabel("230.322 VND");
        priceLabel.setForeground(Color.decode("#666666"));
        priceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        bottomPanel.add(priceLabel);

        // button delivered
        CustomButton returnsButton = new CustomButton("Return and report", Color.decode("#F2F2F2"));
        CustomButton deliveredButton = new CustomButton("Received");
        CustomButton followButton = new CustomButton("Follow order");
        if (order.isDelivery()) {
            bottomPanel.add(returnsButton);
            bottomPanel.add(deliveredButton);
        }
        if (order.isConvey()) {
            bottomPanel.add(followButton);
        }

        // Thêm panel dưới vào layout chính
        add(bottomPanel, BorderLayout.SOUTH);

        // Thiết lập kích thước panel
        setPreferredSize(new Dimension(400, 130));
    }

}
