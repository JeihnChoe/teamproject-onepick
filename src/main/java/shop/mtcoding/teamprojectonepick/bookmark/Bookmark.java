package shop.mtcoding.teamprojectonepick.bookmark;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "bookmark_tb")
@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 10000)
    Integer bizId;

    @Column(nullable = false, length = 10000)
    Integer resumeId;

    public Bookmark(Integer id, Integer bizId, Integer resumeId) {
        this.id = id;
        this.bizId = bizId;
        this.resumeId = resumeId;
    }

    
}
