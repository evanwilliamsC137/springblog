package com.codeup.springblog.models;
import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {
//    auto increment Id value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
// title VARCHAR 155 NOT NULL
    @Column(nullable = false, length = 155)
    private String title;
//description not null
    @Column(nullable = false)
    private String description;

    public Ad() {
    }

    public Ad(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
