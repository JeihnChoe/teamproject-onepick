package shop.mtcoding.teamprojectonepick.notice.like;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.TypeResolutionStrategy.Lazy;
import shop.mtcoding.teamprojectonepick.notice.Notice;
import shop.mtcoding.teamprojectonepick.user.User;

@NoArgsConstructor
@Data
@Table(name = "notice_like_tb")
@Entity
public class NoticeLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notice notice;

    public NoticeLike(Integer id, User user, Notice notice) {
        this.id = id;
        this.user = user;
        this.notice = notice;
    }
}
