package shop.mtcoding.teamprojectonepick.tech;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TechNoticeRepository extends JpaRepository<TechNotice, Integer> {

    // @Query("select r from TechNotice r where r.notice.id = :noticeId")
    // //TechNotice엔티티에서 noticeId 값이 일치하는 항목 필터링
    // List<TechNotice> findByNoticeId(@Param("noticeId") Integer
    // noticeId);//Tech엔티티 목록 리스트로 반환

}
