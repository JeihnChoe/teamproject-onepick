package shop.mtcoding.teamprojectonepick.notice;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamprojectonepick.user.User;

@Service
public class NoticeService {

@Autowired
private NoticeRequestDTO noticeRequestDTO;

    @Autowired
    private NoticeRepository noticeRepository;


    @Transactional
    public void 공고등록(NoticeRequestDTO.SaveDTO saveDTO, int sessionUserId) {


        Notice notice = Notice.builder()
                .open(saveDTO.getOpen())
                .userImg(saveDTO.getUserImg())
                .semiTitle(saveDTO.getSemiTitle())
                .semiContent(saveDTO.getSemiContent())
                .workField(saveDTO.getWorkField())
                .bizName(saveDTO.getBizName())
                .userAddress(saveDTO.getUserAddress())
                .career(saveDTO.getCareer())
                .education(saveDTO.getEducation())
                .mainContent(saveDTO.getMainContent())
                .deadLine(saveDTO.getDeadLine())
                // .user(User.builder().id(sessionUserId).build())
                .build();

        // TechNotice techNotice = TechNotice.builder()
        //         .noticeId(techSaveDTO.getNoticeId())
        //         .techId(techSaveDTO.getTechId())
        //         .build();
                
        //         notice.setTechNotice(techNotice);

        noticeRepository.save(notice);
    }

}
