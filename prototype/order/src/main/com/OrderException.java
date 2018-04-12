
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Order Service Failed ")
public class OrderException extends Exception {
    public OrderException(){
        super("Order Service Failed");
    }
}