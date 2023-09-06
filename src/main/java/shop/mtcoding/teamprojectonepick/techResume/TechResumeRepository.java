package shop.mtcoding.teamprojectonepick.techResume;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TechResumeRepository extends JpaRepository<TechResume, Integer> {

    @Query("select tr from TechResume tr left join fetch tr.resume r where r.id = :id")
    TechResume mFindByIdJoinResume(@Param("id") Integer id);
}
