package entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity(name = "bookmark")
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="title", length=15, nullable = false,unique = false )
    private String title;

    @Column(name="img_url", length=25, nullable = false,unique = false )
    private String imgUrl;

    @Column(name="description", nullable = false,unique = false )
    private String description;

    @Column(name="created_on", nullable = false,unique = false )
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name="user_name", nullable=false)
    private User user;

    public Bookmark() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
