package source.tradingev_batter.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "chatroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chatroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatid")
    private long chatid;

    @Column(name = "createdat")
    private Date createdat;

    @OneToOne
    @JoinColumn(name = "buyerid")
    private User buyer;

    @OneToOne
    @JoinColumn(name = "sellerid")
    private User seller;

    @OneToOne
    @JoinColumn(name = "order_detailid")
    private Order_detail order_detail;

    @OneToOne(mappedBy = "chatroom")
    private Message message;
}
