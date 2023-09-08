package shop.mtcoding.teamprojectonepick.applyResumeNotice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.teamprojectonepick.notice.Notice;
import shop.mtcoding.teamprojectonepick.resume.Resume;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Resume resume;

    @ManyToOne
    private Notice notice;

    private Date applicationDate;

    @Builder
    public Application(Integer id, Resume resume, Notice notice, Date applicationDate) {
        this.id = id;
        this.resume = resume;
        this.notice = notice;
        this.applicationDate = applicationDate;
    }

}
