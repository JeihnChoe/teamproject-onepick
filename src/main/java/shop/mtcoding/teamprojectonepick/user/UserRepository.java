package shop.mtcoding.teamprojectonepick.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user_tb where login_id = :login_id", nativeQuery = true)
    User findByUsername(@Param("login_id") String loginId);

}
