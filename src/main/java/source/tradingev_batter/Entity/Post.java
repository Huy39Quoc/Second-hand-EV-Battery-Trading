package source.tradingev_batter.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postid")
    private long postid;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "createdat")
    private Date createdat;

    @Column(name = "updatedat")
    private Date updatedat;

    @OneToMany(mappedBy = "posts")
    private List<Comment> comments = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "posts")
    private Product products;

    @OneToOne
    @JoinColumn(name = "created_by")
    private User users;

    @OneToOne
    @JoinColumn(name = "reviewed_by")
    private User userReviewed;

    @OneToOne(mappedBy = "posts")
    private Favorite_post favorite_post;
}
