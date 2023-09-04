package shop.mtcoding.teamprojectonepick.applyResumeNotice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "apply_tb")
@Entity
public class ApplyResumeNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 10000)
    Integer resumeId;

    @Column(nullable = false, length = 10000)
    Integer noticeId;

    @Builder
    public ApplyResumeNotice(Integer id, Integer resumeId, Integer noticeId) {
        this.id = id;
        this.resumeId = resumeId;
        this.noticeId = noticeId;
    }
}