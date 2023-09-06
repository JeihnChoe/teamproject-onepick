package shop.mtcoding.teamprojectonepick.resume;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResumeRepository extends JpaRepository<Resume, Integer> {

    @Query("select r from Resume r left join fetch r.techResume rt left join fetch r.user ru where r.id = :id")
    Resume mFindByIdJoinTechResumeInUser(@Param("id") Integer id);
}
