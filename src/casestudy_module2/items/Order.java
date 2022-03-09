package casestudy_module2.items;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private String drink_name;
    private int quantity;
    private double price;
    private double total_price;
    private String time_oder;

    private List<Order> orders = new ArrayList<>();

    public Order() {
    }

    public Order(String draw) {
        String[] field = draw.split(",");
        id = Long.parseLong(field[0]);
        drink_name = field[1];
        quantity = Integer.parseInt(field[2]);
        price = Double.parseDouble(field[3]);
        total_price = Double.parseDouble(field[4]);
        time_oder = field[5];
    }

    public Order(long id, String drink_name, int quantity, double price, double total_price, String time_oder, List<Order> orders) {
        this.id = id;
        this.drink_name = drink_name;
        this.quantity = quantity;
        this.price = price;
        this.total_price = total_price;
        this.time_oder = time_oder;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getTime_oder() {
        return time_oder;
    }

    public void setTime_oder(String time_oder) {
        this.time_oder = time_oder;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", drink_name='" + drink_name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total_price=" + total_price +
                ", time_oder='" + time_oder + '\'' +
                ", orders=" + orders +
                '}';
    }
}
