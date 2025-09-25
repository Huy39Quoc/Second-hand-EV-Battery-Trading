package source.tradingev_batter.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "feedbacks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedbackid")
    private long feedbackid;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "createdat")
    private Date createdat;

    @OneToOne
    @JoinColumn(name = "orderid")
    private Order orders;

    @OneToOne
    @JoinColumn(name = "productid")
    private Product products;

    @OneToOne
    @JoinColumn(name = "write_by")
    private User users;
}
