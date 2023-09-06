package shop.mtcoding.teamprojectonepick.techResume;

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
import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.tech.Tech;

@Data
@NoArgsConstructor
@Table(name = "tech_resume_tb")
@Entity
public class TechResume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    Resume resume;

    @ManyToOne(fetch = FetchType.LAZY)
    Tech tech;

    @Builder
    public TechResume(Integer id, Resume resume, Tech tech) {
        this.id = id;
        this.resume = resume;
        this.tech = tech;
    }

}