
import OrderEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderDAO {
    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public OrderDAO(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public void add(OrderEntity orderEntity) {
        hibernateTemplate.save(orderEntity);
    }

    @Transactional
    public void delete(OrderEntity orderEntity) {
        hibernateTemplate.delete(orderEntity);
    }
}