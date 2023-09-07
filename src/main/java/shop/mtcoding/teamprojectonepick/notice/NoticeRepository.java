package shop.mtcoding.teamprojectonepick.notice;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    @Query("select n from Notice n where n.open = :open")
    List<Notice> findByOpen(@Param("open") String open);
}
