
import OrderDAO;
import OrderEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import javax.naming.AuthenticationException;


@Service
public class OrderService {
    private final OrderDAO orderDao;

    @Autowired
    public OrderService(OrderDAO orderDao) {
        this.orderDao = orderDao;
    }

    public boolean addByInformation(int shipmentID, int productID,int userID) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setShipmentID(shipmentID);
        orderEntity.setProductID(productID);
        orderEntity.setUserID(userID);
        orderDao.add(orderEntity);
        return true;
    }

    public boolean deleteByID(int id) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setID(id);
        orderDao.delete(orderEntity);
        return true;
    }

}