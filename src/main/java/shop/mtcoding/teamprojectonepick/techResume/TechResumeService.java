package shop.mtcoding.teamprojectonepick.techResume;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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

    public List<Integer> 체크된기술아이디가져오기(Integer id, List<TechResume> techResumes) {
        List<Integer> checkedIds = new ArrayList<>();

        for (TechResume techResume : techResumes) {
            checkedIds.add(techResume.getTech().getId());
        }
        return checkedIds;
    }

}
