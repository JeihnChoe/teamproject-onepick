package shop.mtcoding.teamprojectonepick.tech.resume;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TechResumeRepository extends JpaRepository<TechResume, Integer> {

    @Query("select tr from TechResume tr left join fetch tr.resume r where r.id = :resumeId")
    List<TechResume> mFindByIdJoinResume(@Param("resumeId") Integer resumeId);

    @Query("select tr from TechResume tr left join fetch tr.resume r left join fetch r.user where r.id = :resumeId")
    List<TechResume> mFindByIdJoinResumeJoinUser(@Param("resumeId") Integer resumeId);

    @Modifying
    @Query("delete from TechResume tr where tr.resume.id = :resumeId and tr.tech.id = :techId")
    void deleteByResumeIdAndTechId(@Param("resumeId") Integer resumeId, @Param("techId") Integer techId);
}
