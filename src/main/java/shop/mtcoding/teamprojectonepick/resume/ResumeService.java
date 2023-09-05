package shop.mtcoding.teamprojectonepick.resume;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamprojectonepick.resume.ResumeRequestDTO.SaveDTO;
import shop.mtcoding.teamprojectonepick.user.User;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Transactional
    public void 이력서작성(SaveDTO saveDTO, Integer sessionId) {

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + saveDTO.getResumeImg().getOriginalFilename();
        System.out.println("fileName : " + fileName);

        Path filePath = Paths.get("./images/" + fileName);
        try {
            Files.write(filePath, saveDTO.getResumeImg().getBytes()); // 버퍼에 쓴다.
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = User.builder().id(1).build();
        Resume resume = Resume.builder()
                .title(saveDTO.getTitle())
                .semiContent(saveDTO.getSemiContent())
                .content(saveDTO.getContent())
                .education(saveDTO.getEducation())
                .school(saveDTO.getSchool())
                .major(saveDTO.getMajor())
                .career1(saveDTO.getCareer1())
                .career1(saveDTO.getCareer_period1())
                .career1(saveDTO.getCareer_period1_1())
                .career1(saveDTO.getCareer2())
                .career1(saveDTO.getCareer_period2())
                .career1(saveDTO.getCareer_period2_1())
                .career1(saveDTO.getCareer3())
                .career1(saveDTO.getCareer_period3())
                .career1(saveDTO.getCareer_period3_1())
                .open(false)
                .etc1(saveDTO.getEtc1())
                .etc1(saveDTO.getEtc_period1())
                .etc1(saveDTO.getEtc2())
                .etc1(saveDTO.getEtc_period2())
                .etc1(saveDTO.getEtc3())
                .etc1(saveDTO.getEtc_period3())
                .link1(saveDTO.getLink1())
                .link2(saveDTO.getLink2())
                .link3(saveDTO.getLink3())
                .workField(saveDTO.getWorkField())
                .resumeImg(fileName)
                .user(user)
                .build();
        resumeRepository.save(resume);
    }

    // public Resume 이력서목록보기(Integer id) {
    // return resumeRepository.findById(id).get();
    // }
}
