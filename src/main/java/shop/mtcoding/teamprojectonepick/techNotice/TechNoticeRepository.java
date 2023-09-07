package shop.mtcoding.teamprojectonepick.techNotice;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TechNoticeRepository extends JpaRepository<TechNotice, Integer> {
    @Query("select tr from TechNotice tr left join fetch tr.notice r where r.id = :id")
    TechNotice mFindByIdJoinNotice(@Param("id") Integer id);

}
