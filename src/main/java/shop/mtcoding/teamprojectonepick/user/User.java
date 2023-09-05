package shop.mtcoding.teamprojectonepick.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    // 유저
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 10000)
    String loginId; // 로그인아이디

    @Column(nullable = false, length = 10000)
    String password; // 패스워드

    @Column(nullable = false, length = 10000)
    String username; // 사람이름

    @Column(nullable = false, length = 10000)
    String email; // 이메일

    @Column(nullable = true, length = 10000)
    String address; // 주소

    @Column(nullable = true, length = 10000)
    String address2; // 주소

    @Column(nullable = false, length = 10000)
    String tel; // 전화번호

    @Column(nullable = false, length = 10000)
    String birth; // 생년월일

    // 기업 유저
    @Column(nullable = true, length = 10000)
    String bizname; // 기업명

    // 개인 기업 구분 코드 -> 개인이면 1, 기업이면 2
    @Column(nullable = false)
    Integer usercode;

    private Timestamp createdAt;

    @Builder
    public User(Integer id, String loginId, String password, String username, String email, String address,
            String address2, String tel,
            String birth, String bizname, int usercode, Timestamp createdAt) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.username = username;
        this.email = email;
        this.address = address;
        this.address2 = address2;
        this.tel = tel;
        this.birth = birth;
        this.bizname = bizname;

        this.usercode = usercode;
    }

}