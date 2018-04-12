
import ProductEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class ProductDAO {
    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public ProductDAO(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List findByExample(ProductEntity productEntity) {
        return hibernateTemplate.findByExample(productEntity);
    }
    @Transactional
    public boolean update(ProductEntity productEntity) {
        try{
            hibernateTemplate.update(productEntity);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}