package shop.mtcoding.teamprojectonepick.notice;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    @Query("select n from Notice n where n.open = :open and n.user.id = :userId")
    List<Notice> findByUserId(@Param("userId") Integer userId, @Param("open") String open);

    // @Query("select r from Notice r left join fetch r.techNotice rt left join
    // fetch r.user ru where r.id = :id")
    // Notice mFindByIdJoinTechNoticeInUser(@Param("id") Integer id);

    // <DB에서 조회해서 DTO로 바로 받는 법>
    // @Query("select new shop.mtcoding.teamprojectonepick.notice.MyIndexDTO(n.open,
    // n.workField, n.address, n.career, n.education) from Notice n where
    // n.open=:open and n.workField = :workField and n.address = :address and
    // n.career = :career and n.education= :education")
    // List<MyIndexDTO> findByIndexDTO(@Param("open") String open,
    // @Param("workField") String workField,
    // @Param("address") String address, @Param("career") String career,
    // @Param("education") String education);

}
