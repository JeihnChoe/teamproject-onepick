package shop.mtcoding.teamprojectonepick.bookmark;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.user.User;

@NoArgsConstructor
@Data
@Table(name = "bookmark_tb")
@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // userCode = 2

    @ManyToOne(fetch = FetchType.LAZY)
    private Resume resume;

    public Bookmark(Integer id, User user, Resume resume) {
        this.id = id;
        this.user = user;
        this.resume = resume;
    }
    
}
