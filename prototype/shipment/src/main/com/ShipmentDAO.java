
import ServiceEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class ServiceDAO {
    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public ServiceDAO(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List findByExample(ShipmentEntity shipmentEntity) {
        return hibernateTemplate.findByExample(shipmentEntity);
    }
    @Transactional
    public void add(ShipmentEntity shipmentEntity) {
        hibernateTemplate.save(shipmentEntity);
    }
}