package source.tradingev_batter.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "favorite_posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favorite_post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favoriteid")
    private long favoriteid;

    @Column(name = "createdat")
    private Date createdat;

    @ManyToMany(mappedBy = "favorite_posts")
    private List<User> users = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "postid")
    private Post posts;
}
