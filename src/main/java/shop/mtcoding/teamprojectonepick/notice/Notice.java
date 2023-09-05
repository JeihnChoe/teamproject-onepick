package shop.mtcoding.teamprojectonepick.notice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "notice_tb")
@Entity
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 10000)
    boolean open;// 공개 비공개 여부

    @Column(nullable = false, length = 10000)
    String bizImg; // 기업 대표이미지

    @Column(nullable = false, length = 10000)
    String semiTitle;// 공고 제목

    @Column(nullable = false, length = 10000)
    String semiContent;// 간단 기업소개

    @Column(nullable = false, length = 10000)
    String workField;// 직무 분야(백/프/앱)

    @Column(nullable = false, length = 10000)
    String bizName; // 기업 이름

    @Column(nullable = false, length = 10000)
    String bizAddress; // 근무 지역(택1)

    @Column(nullable = false, length = 10000)
    String career; // 요구경력(택1)

    @Column(nullable = false, length = 10000)
    String education; // 요구학력(택1)

    @Column(nullable = false, length = 10000)
    String mainContent; // 공고상세내용

    @Column(length = 10000)
    String deadLine; // 마감일

    @Builder
    public Notice(Integer id, boolean open, String bizImg, String semiTitle, String semiContent, String workField,
            String bizName, String bizAddress, String career, String education, String mainContent, String deadLine) {
        this.id = id;
        this.open = open;
        this.bizImg = bizImg;
        this.semiTitle = semiTitle;
        this.semiContent = semiContent;
        this.workField = workField;
        this.bizName = bizName;
        this.bizAddress = bizAddress;
        this.career = career;
        this.education = education;
        this.mainContent = mainContent;
        this.deadLine = deadLine;
    }

}