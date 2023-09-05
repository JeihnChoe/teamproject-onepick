
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

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import shop.mtcoding.teamprojectonepick.tech.TechResume;
import shop.mtcoding.teamprojectonepick.user.User;

@Table(name = "resume_tb")
@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 10000)
    String title;

    @Column(nullable = false, length = 10000)
    String semiContent;

    @Column(nullable = false, length = 10000)
    String content;

    @Column(length = 10000)
    String education; // 학력(택1)

    @Column(length = 10000)
    String school; // 학교

    @Column(length = 10000)
    String major; // 전공

    @Column(length = 10000)
    String career1;

    @Column(length = 10000)
    String career_period1;

    @Column(length = 10000)
    String career_period1_1;

    @Column(length = 10000)
    String career2;

    @Column(length = 10000)
    String career_period2;
    @Column(length = 10000)
    String career_period2_1;

    @Column(length = 10000)
    String career3;

    @Column(length = 10000)
    String career_period3;

    @Column(length = 10000)
    String career_period3_1;

    boolean open = false;

    @Column(length = 10000)
    String etc1;
    @Column(length = 10000)
    String etc2;
    @Column(length = 10000)
    String etc3;

    @Column(length = 10000)
    String etc_period1;
    @Column(length = 10000)
    String etc_period2;
    @Column(length = 10000)
    String etc_period3;

    @Column(length = 10000)
    String link1; // 리스트중에 여러개 선택

    @Column(length = 10000)
    String link2; // 리스트중에 여러개 선택

    @Column(length = 10000)
    String link3; // 리스트중에 여러개 선택

    String workField; // 직군

    String resumeImg;

    // @JsonIgnoreProperties({"password", "email", "createdAt"}) 나중에 필요하면 쓰기
    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @JsonIgnoreProperties({ "resume" }) // 무한 직렬화 막아줌. ajax쓸 때 사용. Reply내부의 board를 안주겠다.??
    @OneToMany(mappedBy = "resume", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<TechResume> techResume = new ArrayList<>();

    @Builder
    public Resume(Integer id, String title, String semiContent, String content, String education, String school,
            String major,
            String career1, String career_period1, String career_period1_1, String career2, String career_period2,
            String career_period2_1, String career3, String career_period3, String career_period3_1, boolean open,
            String etc1, String etc2, String etc3, String etc_period1, String etc_period2, String etc_period3,
            String link1, String link2, String link3, String workField, User user, String resumeImg) {
        this.id = id;
        this.title = title;
        this.semiContent = semiContent;
        this.content = content;
        this.education = education;
        this.school = school;
        this.career1 = career1;
        this.career_period1 = career_period1;
        this.career_period1_1 = career_period1_1;
        this.career2 = career2;
        this.career_period2 = career_period2;
        this.career_period2_1 = career_period2_1;
        this.career3 = career3;
        this.career_period3 = career_period3;
        this.career_period3_1 = career_period3_1;
        this.open = open;
        this.etc1 = etc1;
        this.etc2 = etc2;
        this.etc3 = etc3;
        this.etc_period1 = etc_period1;
        this.etc_period2 = etc_period2;
        this.etc_period3 = etc_period3;
        this.link1 = link1;
        this.link2 = link2;
        this.link3 = link3;
        this.workField = workField;
        this.user = user;
        this.resumeImg = resumeImg;
    }
}
