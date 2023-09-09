package shop.mtcoding.teamprojectonepick.apply;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.teamprojectonepick.notice.Notice;
import shop.mtcoding.teamprojectonepick.resume.Resume;

@NoArgsConstructor
@Data
@Table(name = "apply_tb")
@Entity
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Resume resume;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notice notice;

    private Date applicationDate;

    public Apply(Integer id, Resume resume, Notice notice, Date applicationDate) {
        this.id = id;
        this.resume = resume;
        this.notice = notice;
        this.applicationDate = applicationDate;
    }

}
