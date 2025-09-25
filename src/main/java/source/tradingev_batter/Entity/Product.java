package source.tradingev_batter.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private long productid;

    @Column(name = "productname")
    private String productname;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private double cost;

    @Column(name = "amount")
    private int amount;

    @Column(name = "status")
    private String status;

    @Column(name = "model")
    private String model;

    @Column(name = "createdat")
    private Date createdat;

    @Column(name = "updatedat")
    private Date updatedat;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User users;

    @OneToMany(mappedBy = "products")
    private List<product_img> imgs = new ArrayList<>();

    @OneToOne(mappedBy = "products")
    private Brandcars brandcars;

    @OneToOne(mappedBy = "products")
    private Brandbattery  brandbattery;

    @OneToOne(mappedBy = "products")
    private cart_items cart_item;

    @OneToOne(mappedBy = "products")
    private Feedback feedbacks;

    @OneToOne(mappedBy = "products")
    private Post posts;

    @OneToOne(mappedBy = "products")
    private Order_detail order_detail;
}
