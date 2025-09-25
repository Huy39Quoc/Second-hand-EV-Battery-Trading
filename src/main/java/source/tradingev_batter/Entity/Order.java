package source.tradingev_batter.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private long orderid;

    @Column(name = "total_amount")
    private double totalamount;

    @Column(name = "shipping_fee")
    private double shippingfee;

    @Column(name = "total_final")
    private double totalfinal;

    @Column(name = "shipping_address")
    private String shippingaddress;

    @Column(name = "paymentMethod")
    private String paymentmethod;

    @Column(name = "createdat")
    private Date createdat;

    @Column(name = "updatedat")
    private Date updatedat;

    @Column(name = "status")
    private String status;

    @OneToOne(mappedBy = "orders")
    private Contracts  contracts;

    @OneToOne(mappedBy = "orders")
    private Feedback feedbacks;

    @ManyToOne
    @JoinColumn(name = "buyerid")
    private User users;

    @OneToMany(mappedBy = "orders")
    private List<Order_detail> details = new ArrayList<>();

    @OneToMany(mappedBy = "orders")
    private List<Transaction> transactions = new ArrayList<>();

    @OneToOne(mappedBy = "orders")
    private Refund refunds;
}
