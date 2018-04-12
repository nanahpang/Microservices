
import OrderEntity;
import OrderService;
import OrderService;
import OrderException;
import JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api", produces = "application/json;charset=UTF-8")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "addorder", method = RequestMethod.POST)
    public String addOrder(@RequestBody String mapString) throws Exception {
        Map map = JSONUtil.parseMap(mapString);
        int shipmentID = (int) map.get("shipmentID");
        int productID = (int) map.get("productID");
        int userID = (int) map.get("userID");
        if (orderService.addByInformation(shipmentID,productID,userID))
            return "success";
        else
            throw new OrderException();
    }

    @RequestMapping(value = "deleteorder", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) throws Exception {
        if(orderService.deleteByID(id))
            return "success";
       else
           throw new OrderException();
    }
}