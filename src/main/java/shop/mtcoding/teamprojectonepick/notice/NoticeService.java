package shop.mtcoding.teamprojectonepick.notice;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamprojectonepick._core.vo.MyPath;
import shop.mtcoding.teamprojectonepick.tech.Tech;
import shop.mtcoding.teamprojectonepick.tech.TechRepository;
import shop.mtcoding.teamprojectonepick.techNotice.TechNotice;
import shop.mtcoding.teamprojectonepick.techNotice.TechNoticeRepository;
import shop.mtcoding.teamprojectonepick.user.User;

@Service
public class NoticeService {

    @Autowired
    private NoticeRequestDTO noticeRequestDTO;

    @Autowired
    private TechNoticeRepository techNoticeRepository;

    @Autowired
    private TechRepository techRepository;

    @Autowired
    private NoticeRepository noticeRepository;

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
        // List<String> techStringList = new ArrayList<String>();
        // for (String techNotice : techNotices) {
        // techStringList.add(techNotice);
        // }

        // for (String techList : techNotices) {
        // Tech techEntity = Tech.builder()
        // .techname(techList)
        // .build();
        // techLists.add(techEntity);
        // }
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
                .techNotices(techNotices) // 이작업을 제대로하면 자동으로 tech—notice—tb 에 들어가지 않을까¿ 하는 생각

                // .user(User.builder().id(sessionUserId).build())
                .build();

        // 기술스택 리스트넣기
       
        for (Integer techIds : techId) {
            Tech tech = techRepository.findById(techIds).get();
            TechNotice techNotice = TechNotice.builder().notice(notice).tech(tech).build();
            techNoticeRepository.save(techNotice);
            // techNotices.add(techNotice);
        }

        // TechNotice techNotice = TechNotice.builder()
        // .noticeId(techSaveDTO.getNoticeId())
        // .techId(techSaveDTO.getTechId())
        // .build();

        // TechNotice techNotice = TechNotice.builder()
        // .notice(notice)
        // .build();

        // techNotices.add(techNotice);

        // notice.setTechNotices(techNotices);

        noticeRepository.save(notice);

    }

    public Notice 공고조회(Integer id) {

        // Notice notice = noticeRepository.mFindByIdJoinTechNoticeInUser(id);
        // return notice;
        Optional<Notice> noticeOP = noticeRepository.findById(id);
        return noticeOP.get();
    }

}
