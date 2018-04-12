
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Shipment Service Failed ")
public class OrderException extends Exception {
    public OrderException(){
        super("Shipment Service Failed");
    }
}