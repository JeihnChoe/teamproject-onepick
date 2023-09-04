package shop.mtcoding.teamprojectonepick.like;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "like_tb")
@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 10000)
    Integer userId;

    @Column(nullable = false, length = 10000)
    Integer noticeId;

    @Builder
    public Like(Integer id, Integer userId, Integer noticeId) {
        this.id = id;
        this.userId = userId;
        this.noticeId = noticeId;
    }

    
}
