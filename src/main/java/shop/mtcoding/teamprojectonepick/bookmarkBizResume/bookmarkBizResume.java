package shop.mtcoding.teamprojectonepick.bookmarkBizResume;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "bookmark_tb")
@Entity
public class BookmarkBizResume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 10000)
    Integer bizId;

    @Column(nullable = false, length = 10000)
    Integer resumeId;

    @Builder
    public BookmarkBizResume(Integer id, Integer bizId, Integer resumeId) {
        this.id = id;
        this.bizId = bizId;
        this.resumeId = resumeId;

    }
}