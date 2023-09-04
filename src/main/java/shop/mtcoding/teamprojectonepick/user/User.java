package shop.mtcoding.teamprojectonepick.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 10000)
    String loginId;

    @Column(nullable = false, length = 10000)
    String password;

    @Column(nullable = false, length = 10000)
    String email;

    @Column(nullable = false, length = 10000)
    String username;

    @Column(nullable = false, length = 10000)
    String address;

    @Column(nullable = false, length = 10000)
    String tel;

    @Column(nullable = false, length = 10000)
    String birth;

    private Timestamp createdAt;

    public User(Integer id, String loginId, String password, String email, String username, String address,
            String school, String career, String tel, String birth, Timestamp createdAt) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.username = username;
        this.address = address;
        this.tel = tel;
        this.birth = birth;
        this.createdAt = createdAt;
    }

}
