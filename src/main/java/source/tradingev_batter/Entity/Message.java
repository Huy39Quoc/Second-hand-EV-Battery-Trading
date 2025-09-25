package source.tradingev_batter.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messid")
    private long messid;

    @Column(name = "text")
    private String text;

    @Column(name = "attachUrl")
    private String attachUrl;

    @Column(name = "createdat")
    private Date createdat;

    @OneToOne
    @JoinColumn(name = "roomid")
    private Chatroom  chatroom;
}
