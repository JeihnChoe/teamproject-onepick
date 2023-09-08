package shop.mtcoding.teamprojectonepick.tech.notice;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.teamprojectonepick.notice.Notice;
import shop.mtcoding.teamprojectonepick.tech.Tech;

@NoArgsConstructor
@Data
@Table(name = "tech_notice_tb")
@Entity
public class TechNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private Notice notice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tech_id") // tech 엔티티의 외래 키 컬럼과 매핑
    private Tech tech;

    @Builder
    public TechNotice(Integer id, Notice notice, Tech tech) {
        this.id = id;
        this.notice = notice;
        this.tech = tech;
    }

}