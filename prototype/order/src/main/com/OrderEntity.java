
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Order", schema = "order", catalog = "")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class OrderEntity {
    private int shipmentID;
    private int productID
    private int userID;
    private int id;

    @Basic
    @Column(name = "shipmentID", nullable = false)
    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }
    @Basic
    @Column(name = "productID", nullable = false)
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    @Basic
    @Column(name = "userID", nullable = false)
    public int getUserID() {
        return userID;
    }

    public void setUserID(int usrID) {
        this.userID = userID;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}