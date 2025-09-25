package source.tradingev_batter.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    private long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password",  nullable = false)
    private String password;

    @Column(name = "isactive")
    private boolean isactive;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dateofbirth")
    private Date dateofbirth;

    @Column(name = "email",  nullable = false)
    private String email;

    @Column(name = "displayname")
    private String displayname;

    @Column(name = "createdat",   nullable = false)
    private Date createdat;

    @Column(name = "updatedat")
    private Date updatedat;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "users")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<Notification> notifications = new ArrayList<>();

//    @OneToMany(mappedBy = "user")
//    private List<Carts> carts = new ArrayList<>();

    @OneToOne(mappedBy = "users")
    private Carts carts;

    @OneToOne(mappedBy = "users")
    private cart_items cart_items;

    @OneToMany(mappedBy = "buyers")
    private List<Contracts> buyerContracts = new ArrayList<>();

    @OneToMany(mappedBy = "sellers")
    private List<Contracts> sellerContracts = new ArrayList<>();

    @OneToOne(mappedBy = "users")
    private Feedback feedbacks;

    @OneToOne(mappedBy = "users")
    private Post posts;

    @OneToOne(mappedBy = "userReviewed")
    private Post userReviewed;

    @ManyToMany
    @JoinTable(
            name = "like_post",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "favoriteid")
    )
    private List<Favorite_post> favorite_posts =  new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "createdBy")
    private List<Transaction> transactions = new ArrayList<>();

    @OneToOne(mappedBy = "buyer")
    private Chatroom chatroomBuyer;

    @OneToOne(mappedBy = "seller")
    private Chatroom chatroomSeller;
}
