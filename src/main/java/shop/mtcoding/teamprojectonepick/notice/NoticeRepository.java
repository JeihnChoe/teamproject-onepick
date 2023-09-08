package shop.mtcoding.teamprojectonepick.notice;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shop.mtcoding.teamprojectonepick.notice.NoticeRequestDTO.NoticeSummaryDTO;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    @Query("select n from Notice n where n.open = :open")
    List<Notice> findByOpen(@Param("open") String open);

    @Query("select n from Notice n where n.user_id = user_id")
    NoticeSummaryDTO findByUserId(Integer id);

    // @Query("select r from Notice r left join fetch r.techNotice rt left join
    // fetch r.user ru where r.id = :id")
    // Notice mFindByIdJoinTechNoticeInUser(@Param("id") Integer id);
}
