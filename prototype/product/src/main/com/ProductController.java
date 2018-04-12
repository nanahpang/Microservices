
import ProductService;
import ProductException;
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

    @RequestMapping(value = "addamount", method = RequestMethod.POST)
    public String addAmount(@RequestBody String mapString) throws Exception {
        Map map = JSONUtil.parseMap(mapString);
        int id = (int) map.get("id");
        int amount = (int) map.get("amount");
        if (productService.increase(id, amount))
            return "success";
        else
            throw new ServiceException();
    }
    @RequestMapping(value = "reduceamount", method = RequestMethod.POST)
    public String reduceAmount(@RequestBody String mapString) throws Exception {
        Map map = JSONUtil.parseMap(mapString);
        int id = (int) map.get("id");
        int amount = (int) map.get("amount");
        if (productService.decrease(id, amount))
            return "success";
        else
            throw new ServiceException();
    }

}