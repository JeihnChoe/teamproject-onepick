package shop.mtcoding.teamprojectonepick.tech;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.teamprojectonepick.resume.Resume;

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

    @ManyToOne
    Tech tech;
}
