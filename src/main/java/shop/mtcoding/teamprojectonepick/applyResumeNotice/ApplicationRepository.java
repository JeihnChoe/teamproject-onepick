package shop.mtcoding.teamprojectonepick.applyResumeNotice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javafx.application.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    
}
