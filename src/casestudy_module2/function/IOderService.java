package casestudy_module2.function;

import casestudy_module2.items.Order;

import java.util.List;

public interface IOderService {
    List<Order> getOrders();

    void add(Order newOrder);

    void update();


    Order getOrderById(double id);

    boolean exist(double id);

    boolean checkDuplicateId(double id);

    void remove(Order order);
}
