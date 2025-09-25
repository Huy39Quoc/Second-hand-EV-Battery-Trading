package source.tradingev_batter.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "cart_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cart_items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemsid")
    private double itemsid;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "addedat")
    private Date addedat;

    @ManyToOne
    @JoinColumn(name = "cartsid")
    private Carts carts;

    @OneToOne
    @JoinColumn(name = "productid")
    private Product products;

    @OneToOne
    @JoinColumn(name = "userid")
    private User users;
}
