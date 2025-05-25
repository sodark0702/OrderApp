package GUI.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class User extends JFrame {
    public static final int WIDTH = 720;
    public static final int HEIGHT = 480;

    private List<FoodPanel> foodPanelList;

    private FakeDataBase fakeDataBase;

    public User() {
        super("Order App");

        this.foodPanelList = new ArrayList<>();
        this.fakeDataBase = new FakeDataBase();
        for (final var e : fakeDataBase.orders) {
            foodPanelList.add(new FoodPanel(e));
        }


        // init components
        Header header = new Header();
        JPanel main = new JPanel();
        JScrollPane scroll = new JScrollPane(main);
        scroll.getVerticalScrollBar().setUnitIncrement(50);
        main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));

        for (final var element : this.foodPanelList) {
            main.add(element);
        }

        // get the container and set layout to it
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        // add all components
        container.add(header, BorderLayout.NORTH);
        container.add(scroll, BorderLayout.CENTER);

        // config the frame
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
