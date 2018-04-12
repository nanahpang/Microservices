
import ProductDAO;
import ProductEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import javax.naming.AuthenticationException;


@Service
public class ProductService {
    private final ProductDAO productDao;

    @Autowired
    public ProductService(ProductDAO productDao) {
        this.productDao = productDao;
    }

    public boolean decrease(int id, int amount) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setID(shipmentID);
        List list = productDao.findByExample(productEntity);
        ProductEntity p = list.get(0);
        int current = p.getInventory();
        if(current>=amount) {
            p.setInventory(current - amount);
            if (productDao.update(p))
                return true;
            else return false;
        }
        else return false;
    }
    public boolean increase(int id, int amount) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setID(shipmentID);
        List list = productDao.findByExample(productEntity);
        ProductEntity p = list.get(0);
        int current = p.getInventory();
        p.setInventory(current + amount);
        if (productDao.update(p))
            return true;
        else return false;
    }
}