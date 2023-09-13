package shop.mtcoding.teamprojectonepick.tech.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TechNoticeRepository extends JpaRepository<TechNotice, Integer> {
    @Query("select tn from TechNotice tn left join fetch tn.notice n where n.id = :noticeId")
    List<TechNotice> mFindByIdJoinNotice(@Param("noticeId") Integer noticeId);

    @Query("select tn from TechNotice tn left join fetch tn.notice n left join fetch n.user nu where n.id = :noticeId")
    List<TechNotice> mFindByIdJoinNoticeJoinUser(@Param("noticeId") Integer noticeId);

}
