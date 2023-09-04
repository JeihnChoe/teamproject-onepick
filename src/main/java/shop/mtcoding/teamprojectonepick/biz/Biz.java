package shop.mtcoding.teamprojectonepick.biz;

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
@Table(name = "biz_tb")
@Entity
public class Biz {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(nullable = false, length = 10000)
  String loginId;

  @Column(nullable = false, length = 10000)
  String password;

  @Column(nullable = false, length = 10000)
  String bizname;

  @Column(nullable = false, length = 10000)
  String managerName;

  @Column(nullable = false, length = 10000)
  String managerTel;

  @Column(nullable = false, length = 10000)
  String managerEmail;

  @Column(nullable = true, length = 10000)
  String address;
}