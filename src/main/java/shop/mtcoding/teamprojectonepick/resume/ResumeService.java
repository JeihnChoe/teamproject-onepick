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
    public void 이력서작성(SaveDTO saveDTO) {
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
                .careerPeriod1(saveDTO.getCareerPeriod1())
                .careerPeriod1_1(saveDTO.getCareerPeriod1_1())
                .career2(saveDTO.getCareer2())
                .careerPeriod2(saveDTO.getCareerPeriod2())
                .careerPeriod2_1(saveDTO.getCareerPeriod2_1())
                .career3(saveDTO.getCareer3())
                .careerPeriod3(saveDTO.getCareerPeriod3())
                .careerPeriod3_1(saveDTO.getCareerPeriod3_1())
                .open(saveDTO.getOpen())
                .etc1(saveDTO.getEtc1())
                .etcPeriod1(saveDTO.getEtcPeriod1())
                .etc2(saveDTO.getEtc2())
                .etcPeriod2(saveDTO.getEtcPeriod2())
                .etc3(saveDTO.getEtc3())
                .etcPeriod3(saveDTO.getEtcPeriod3())
                .link1(saveDTO.getLink1())
                .link2(saveDTO.getLink2())
                .link3(saveDTO.getLink3())
                .workField(saveDTO.getWorkField())
                .resumeImg(fileName) // 29dcac58-b578-42c2-a807-68bf435cfb5f_기업.png -> 이렇게
                // 들어옴
                .user(user)
                .build();
        resumeRepository.save(resume);

    }

    // public Resume 이력서목록보기(Integer id) {
    // return resumeRepository.findById(id).get();
    // }
}
