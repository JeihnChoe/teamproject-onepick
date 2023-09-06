package shop.mtcoding.teamprojectonepick.techResume;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.resume.ResumeRequestDTO.SaveDTO;
import shop.mtcoding.teamprojectonepick.user.User;

@Service
public class TechResumeService {

    @Autowired
    private TechResumeRepository techResumeRepository;

    @Transactional
    public void 이력서기술저장(SaveDTO saveDTO) {

    }

}
