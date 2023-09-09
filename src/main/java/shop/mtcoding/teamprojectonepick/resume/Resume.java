
package shop.mtcoding.teamprojectonepick.resume;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.teamprojectonepick.tech.resume.TechResume;
import shop.mtcoding.teamprojectonepick.user.User;

@Data
@NoArgsConstructor
@Table(name = "resume_tb")
@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 10000)
    private String title;

    @Column(nullable = false, length = 10000)
    private String semiContent;

    @Column(nullable = false, length = 10000)
    private String content;

    @Column(length = 10000)
    private String education; // 학력(택1)

    @Column(length = 10000)
    private String school; // 학교

    @Column(length = 10000)
    private String major; // 전공

    @Column(length = 10000)
    private String career1;

    @Column(length = 10000)
    private String careerPeriodS1;

    @Column(length = 10000)
    private String careerPeriodE1;

    @Column(length = 10000)
    private String career2;

    @Column(length = 10000)
    private String careerPeriodS2;
    @Column(length = 10000)
    private String careerPeriodE2;

    @Column(length = 10000)
    private String career3;

    @Column(length = 10000)
    private String careerPeriodS3;

    @Column(length = 10000)
    private String careerPeriodE3;

    private String open;

    @Column(length = 10000)
    private String etc1;
    @Column(length = 10000)
    private String etc2;
    @Column(length = 10000)
    private String etc3;

    @Column(length = 10000)
    private String etcPeriod1;
    @Column(length = 10000)
    private String etcPeriod2;
    @Column(length = 10000)
    private String etcPeriod3;

    @Column(length = 10000)
    private String link1; // 리스트중에 여러개 선택

    @Column(length = 10000)
    private String link2; // 리스트중에 여러개 선택

    @Column(length = 10000)
    private String link3; // 리스트중에 여러개 선택

    private String workField; // 직군

    private String resumeImg;

    // @JsonIgnoreProperties({"password", "email", "createdAt"}) 나중에 필요하면 쓰기
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    // @JsonIgnoreProperties({ "resume" }) // 무한 직렬화 막아줌. ajax쓸 때 사용. Reply내부의
    // board를 안주겠다.??
    @JsonIgnore
    @OneToMany(mappedBy = "resume", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TechResume> techResume = new ArrayList<>();

    @Builder
    public Resume(Integer id, String title, String semiContent, String content, String education, String school,
            String major,
            String career1, String careerPeriodS1, String careerPeriodE1, String career2, String careerPeriodS2,
            String careerPeriodE2, String career3, String careerPeriodS3, String careerPeriodE3, String open,
            String etc1, String etc2, String etc3, String etcPeriod1, String etcPeriod2, String etcPeriod3,
            String link1, String link2, String link3, String workField, User user, String resumeImg) {

        this.id = id;
        this.title = title;
        this.semiContent = semiContent;
        this.content = content;
        this.education = education;
        this.school = school;
        this.major = major;
        this.career1 = career1;
        this.careerPeriodS1 = careerPeriodS1;
        this.careerPeriodE1 = careerPeriodE1;
        this.career2 = career2;
        this.careerPeriodS2 = careerPeriodS2;
        this.careerPeriodE2 = careerPeriodE2;
        this.career3 = career3;
        this.careerPeriodS3 = careerPeriodS3;
        this.careerPeriodE3 = careerPeriodE3;
        this.open = open;
        this.etc1 = etc1;
        this.etc2 = etc2;
        this.etc3 = etc3;
        this.link1 = link1;
        this.link2 = link2;
        this.link3 = link3;
        this.workField = workField;
        this.user = user;
        this.resumeImg = resumeImg;
    }

}
