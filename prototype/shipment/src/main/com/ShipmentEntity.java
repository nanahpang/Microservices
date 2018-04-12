
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Shipment", schema = "shipment", catalog = "")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ShipmentEntity {
    private int orderID;
    private String start
    private String end;
    private int id;

    @Basic
    @Column(name = "OrderID", nullable = false)
    public int getOrderID() {
        return orderID;
    }

    public void setInventory(int orderID) {
        this.orderID = orderID;
    }
    @Basic
    @Column(name = "Start", nullable = false)
    public String getStart() {
        return start;
    }

    public void setStart (String start) {
        this.start = start;
    }
    @Basic
    @Column(name = "End", nullable = false)
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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