
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Product Service Failed ")
public class OrderException extends Exception {
    public OrderException(){
        super("Product Service Failed");
    }
}