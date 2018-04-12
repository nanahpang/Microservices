
import ShipmentService;
import ShipmentException;
import JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api", produces = "application/json;charset=UTF-8")
public class ShipmentController {
    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @RequestMapping(value = "ship", method = RequestMethod.POST)
    public String add(@RequestBody String mapString) throws Exception {
        Map map = JSONUtil.parseMap(mapString);
        int orderID = (int) map.get("orderID");
        String start = (String) map.get("start");
        String end = (String) map.get("end");
        if (shipmentService.addByOrderID(orderID, start, end))
            return "success";
        else
            throw new ShipmentException();
    }
}