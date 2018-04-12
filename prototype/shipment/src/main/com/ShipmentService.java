
import ShipmentDAO;
import ShipmentEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import javax.naming.AuthenticationException;


@Service
public class ShipmentService {
    private final ShipmentDAO shipmentDao;

    @Autowired
    public ShipmentService(ShipmentDAO shipmentDao) {
        this.shipmentDao = shipmentDao;
    }

    public boolean addByOrderID(int orderID, String start, String end) {
        ShipmentEntity shipmentEntity = new ShipmentEntity();
        shipmentEntity.setOrderID(orderID);
        shipmentEntity.setStart(start);
        shipmentEntity.setEnd(end);
        shipmentDao.add(shipmentEntity);
        return true;
    }
}