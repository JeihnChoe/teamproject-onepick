package shop.mtcoding.teamprojectonepick.notice;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.teamprojectonepick.user.User;

@NoArgsConstructor
@Data
@Table(name = "notice_tb")
@Entity
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 10000)
    private String open;// 공개 비공개 여부

    @Column(nullable = false, length = 10000)
    private String userImg; // 기업 대표이미지

    @Column(nullable = false, length = 10000)
    private String semiTitle;// 공고 제목

    @Column(nullable = false, length = 10000)
    private String semiContent;// 간단 기업소개

    @Column(nullable = false, length = 10000)
    private String workField;// 직무 분야(백/프/앱)

    @Column(nullable = false, length = 10000)
    private String bizName; // 기업 이름(담당자 이름말고.)

    @Column(nullable = false, length = 10000)
    private String userAddress; // 근무 지역(택1)

    @Column(nullable = false, length = 10000)
    private String career; // 요구경력(택1)

    @Column(nullable = false, length = 10000)
    private String education; // 요구학력(택1)

    @Column(nullable = false, length = 10000)
    private String mainContent; // 공고상세내용

    @Column(nullable = false, length = 10000)
    private String deadLine; // 마감일

    
    //회사랑 포링키 엮어주기
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Notice(Integer id, String open, String userImg, String semiTitle, String semiContent, String workField,
            String bizName, String userAddress, String career, String education, String mainContent, String deadLine) {
        this.id = id;
        this.open = open;
        this.userImg = userImg;
        this.semiTitle = semiTitle;
        this.semiContent = semiContent;
        this.workField = workField;
        this.bizName = bizName;
        this.userAddress = userAddress;
        this.career = career;
        this.education = education;
        this.mainContent = mainContent;
        this.deadLine = deadLine;
    }

 

}
