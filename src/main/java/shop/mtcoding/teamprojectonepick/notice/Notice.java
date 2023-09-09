package shop.mtcoding.teamprojectonepick.notice;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.teamprojectonepick.tech.notice.TechNotice;
import shop.mtcoding.teamprojectonepick.user.User;

@Data
@NoArgsConstructor
@Table(name = "notice_tb")
@Entity
public class Notice {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(length = 10000)
        private String open;// on , off 로 구분

        private String userImg; // 기업 대표이미지 (bizImg or User user FK 걸고, 사진은 user에!!)

        @Column(length = 10000)
        private String semiTitle;// 공고 제목

        @Column(length = 10000)
        private String semiContent;// 간단 기업소개

        @Column(length = 10000)
        private String workField;// 직무 분야(백/프/앱)

        @Column(length = 10000)
        private String bizName; // 기업 이름(담당자 이름말고.)

        @Column(length = 10000)
        private String address; // 근무 지역(택1)

        @Column(length = 10000)
        private String address2; // 근무 지역(택1)

        @Column(length = 10000)
        private String career; // 요구경력(택1)

        @Column(length = 10000)
        private String education; // 요구학력(택1)

        @Column(length = 10000)
        private String mainContent; // 공고상세내용

        @Column(length = 10000)
        private String deadLine; // 마감일

        // 회사랑 포링키 엮어주기
        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        private User user; // 1+N

        @JsonIgnore // 아래는 양방향 매핑이다.
        @OneToMany(mappedBy = "notice", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // (한개공고 다수 기술)
        // 조회하기 위해서 포링키로 엮어와서 글쓰는게 아니라
        private List<TechNotice> techNotices = new ArrayList<>();

        @Builder
        public Notice(Integer id, String open, String userImg, String semiTitle, String semiContent, String workField,
                        String bizName, String address, String address2, String career, String education,
                        String mainContent,
                        String deadLine, User user, List<TechNotice> techNotices) {
                this.id = id;
                this.open = open;
                this.userImg = userImg;
                this.semiTitle = semiTitle;
                this.semiContent = semiContent;
                this.workField = workField;
                this.bizName = bizName;
                this.address = address;
                this.address2 = address2;
                this.career = career;
                this.education = education;
                this.mainContent = mainContent;
                this.deadLine = deadLine;
                this.user = user; // ORM
                this.techNotices = techNotices;
        }

}
