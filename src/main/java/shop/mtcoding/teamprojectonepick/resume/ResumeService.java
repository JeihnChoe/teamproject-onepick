package shop.mtcoding.teamprojectonepick.resume;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamprojectonepick.resume.ResumeRequestDTO.SaveDTO;
import shop.mtcoding.teamprojectonepick.resume.ResumeRequestDTO.UpdateDTO;
import shop.mtcoding.teamprojectonepick.tech.Tech;
import shop.mtcoding.teamprojectonepick.tech.TechRepository;
import shop.mtcoding.teamprojectonepick.techResume.TechResume;
import shop.mtcoding.teamprojectonepick.techResume.TechResumeRepository;
import shop.mtcoding.teamprojectonepick.user.User;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    private TechResumeRepository techResumeRepository;
    @Autowired
    private TechRepository techRepository;

    @Transactional
    public void 이력서작성(SaveDTO saveDTO, List<Integer> techId, Integer sessionUserId) {
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + saveDTO.getResumeImg().getOriginalFilename();
        System.out.println("fileName : " + fileName);

        Path filePath = Paths.get("./upload/" + fileName);
        try {
            Files.write(filePath, saveDTO.getResumeImg().getBytes()); // 버퍼에 쓴다.
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = User.builder().id(sessionUserId).build();
        Resume resume = Resume.builder()
                .title(saveDTO.getTitle())
                .semiContent(saveDTO.getSemiContent())
                .content(saveDTO.getContent())
                .education(saveDTO.getEducation())
                .school(saveDTO.getSchool())
                .major(saveDTO.getMajor())
                .career1(saveDTO.getCareer1())
                .careerPeriodS1(saveDTO.getCareerPeriodS1())
                .careerPeriodE1(saveDTO.getCareerPeriodE1())
                .career2(saveDTO.getCareer2())
                .careerPeriodS2(saveDTO.getCareerPeriodS2())
                .careerPeriodE2(saveDTO.getCareerPeriodE2())
                .career3(saveDTO.getCareer3())
                .careerPeriodS3(saveDTO.getCareerPeriodS3())
                .careerPeriodE3(saveDTO.getCareerPeriodE3())
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

        for (Integer techIds : techId) {
            Tech tech = techRepository.findById(techIds).get();
            TechResume techResume = TechResume.builder().resume(resume).tech(tech).build();
            techResumeRepository.save(techResume);
        }

    }

    public Resume 이력서상세보기(Integer id) {
        Resume resume = resumeRepository.mFindByIdJoinTechResumeInUser(id);
        return resume;
    }

    @Transactional
    public void 삭제하기(Integer id) {
        resumeRepository.deleteById(id);
    }

    @Transactional
    public Resume 이력서수정하기(UpdateDTO updateDTO, List<Integer> techId, Integer resumeId, Integer sessionUserId) {
        User user = User.builder().id(sessionUserId).build();
        Resume resume = resumeRepository.findById(resumeId).get();
        resume.setTitle(updateDTO.getTitle());
        resume.setSemiContent(updateDTO.getSemiContent());
        resume.setContent(updateDTO.getContent());
        resume.setEducation(updateDTO.getEducation());
        resume.setSchool(updateDTO.getSchool());
        resume.setMajor(updateDTO.getMajor());
        resume.setCareer1(updateDTO.getCareer1());
        resume.setCareerPeriodS1(updateDTO.getCareerPeriodS1());
        resume.setCareerPeriodE1(updateDTO.getCareerPeriodE1());
        resume.setCareer1(updateDTO.getCareer2());
        resume.setCareerPeriodS2(updateDTO.getCareerPeriodS2());
        resume.setCareerPeriodE2(updateDTO.getCareerPeriodE2());
        resume.setCareer1(updateDTO.getCareer3());
        resume.setCareerPeriodS3(updateDTO.getCareerPeriodS3());
        resume.setCareerPeriodE3(updateDTO.getCareerPeriodE3());
        resume.setOpen(updateDTO.getOpen());
        resume.setEtc1(updateDTO.getEtc1());
        resume.setEtc2(updateDTO.getEtc2());
        resume.setEtc3(updateDTO.getEtc3());
        resume.setEtcPeriod1(updateDTO.getEtcPeriod1());
        resume.setEtcPeriod2(updateDTO.getEtcPeriod2());
        resume.setEtcPeriod3(updateDTO.getEtcPeriod3());
        resume.setLink1(updateDTO.getLink1());
        resume.setLink2(updateDTO.getLink2());
        resume.setLink3(updateDTO.getLink3());
        resume.setWorkField(updateDTO.getWorkField());

        UUID uuid = UUID.randomUUID(); // 랜덤한 해시값을 만들어줌
        System.out.println("사진이름 : " + updateDTO.getResumeImg().getOriginalFilename());
        String fileName = uuid + "_" + updateDTO.getResumeImg().getOriginalFilename();
        resume.setResumeImg(fileName);
        for (Integer techIds : techId) {
            Tech tech = techRepository.findById(techIds).get();
            TechResume techResume = TechResume.builder().resume(resume).tech(tech).build();
            techResumeRepository.save(techResume);
        }

        return resume;
    }
}
