package shop.mtcoding.teamprojectonepick.notice;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamprojectonepick._core.error.ex.MyException;
import shop.mtcoding.teamprojectonepick._core.vo.MyPath;
import shop.mtcoding.teamprojectonepick.notice.NoticeRequestDTO.UpdateDTO;

import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.tech.Tech;
import shop.mtcoding.teamprojectonepick.tech.TechRepository;
import shop.mtcoding.teamprojectonepick.techNotice.TechNotice;
import shop.mtcoding.teamprojectonepick.techNotice.TechNoticeRepository;

@Service
public class NoticeService {

    @Autowired
    private TechNoticeRepository techNoticeRepository;

    @Autowired
    private TechRepository techRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    public Object 오픈공고조회;

    // 공고등록ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @Transactional
    public void 공고등록(NoticeRequestDTO.SaveDTO saveDTO, List<Integer> techId) {

        UUID uuid = UUID.randomUUID(); // 랜덤한 해시값을 만들어줌
        String fileName = uuid + "_" + saveDTO.getUserImg().getOriginalFilename();
        System.out.println("fileName : " + fileName);

        Path filePath = Paths.get(MyPath.IMG_PATH + fileName);
        try {
            Files.write(filePath, saveDTO.getUserImg().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<TechNotice> techNotices = new ArrayList<>();

        Notice notice = Notice.builder()
                .open(saveDTO.getOpen())
                .userImg(fileName)
                .semiTitle(saveDTO.getSemiTitle())
                .semiContent(saveDTO.getSemiContent())
                .workField(saveDTO.getWorkField())
                .bizName(saveDTO.getBizName())
                .address(saveDTO.getAddress())
                .address2(saveDTO.getAddress2())
                .career(saveDTO.getCareer())
                .education(saveDTO.getEducation())
                .mainContent(saveDTO.getMainContent())
                .deadLine(saveDTO.getDeadLine())
                .techNotices(techNotices)
                .build();

        // 기술스택 리스트넣기

        for (Integer techIds : techId) {
            Tech tech = techRepository.findById(techIds).get();
            TechNotice techNotice = TechNotice.builder().notice(notice).tech(tech).build();
            techNoticeRepository.save(techNotice);

        }

        noticeRepository.save(notice);

    }

    // 공고조회 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    public Notice 공고조회(Integer id) {
        Optional<Notice> noticeOP = noticeRepository.findById(id);
        return noticeOP.get();
    }

    // 공고삭제ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @Transactional
    public void 삭제하기(Integer id) {
        noticeRepository.deleteById(id);
    }

    // 공고수정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @Transactional
    public void 공고수정하기(Integer id, UpdateDTO updateDTO, List<Integer> techId) {

        UUID uuid = UUID.randomUUID(); // 랜덤한 해시값을 만들어줌
        String fileName = uuid + "_" + updateDTO.getUserImg().getOriginalFilename();

        Path filePath = Paths.get(MyPath.IMG_PATH + fileName);
        try {
            Files.write(filePath, updateDTO.getUserImg().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<TechNotice> techNotices = new ArrayList<>();

        // User user = User.builder().id(sessionUserId).build();
        // Resume resume = resumeRepository.findById(resumeId).get();
        // resume.setTitle(updateDTO.getTitle());

        Optional<Notice> noticeOP = noticeRepository.findById(id);
        if (noticeOP.isPresent()) {
            Notice notice = noticeOP.get();
            notice.setOpen(updateDTO.getOpen());
            notice.setSemiTitle(updateDTO.getSemiTitle());
            notice.setSemiContent(updateDTO.getSemiContent());
            notice.setWorkField(updateDTO.getWorkField());
            notice.setBizName(updateDTO.getBizName());
            notice.setAddress(updateDTO.getAddress());
            notice.setAddress2(updateDTO.getAddress2());
            notice.setCareer(updateDTO.getCareer());
            notice.setEducation(updateDTO.getEducation());
            notice.setMainContent(updateDTO.getMainContent());
            notice.setDeadLine(updateDTO.getDeadLine());

            for (Integer techIds : techId) {
                Tech tech = techRepository.findById(techIds).get();
                TechNotice techNotice = TechNotice.builder().notice(notice).tech(tech).build();
                techNoticeRepository.save(techNotice);

            }

            noticeRepository.save(notice);
        } // flush (더티체킹)

    }
}