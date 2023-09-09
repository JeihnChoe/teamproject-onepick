package shop.mtcoding.teamprojectonepick.tech.resume;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.tech.Tech;

@Data
@NoArgsConstructor
@Table(name = "tech_resume_tb")
@Entity
public class TechResume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Resume resume;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tech tech;

    @Builder
    public TechResume(Integer id, Resume resume, Tech tech) {
        this.id = id;
        this.resume = resume;
        this.tech = tech;
    }
}