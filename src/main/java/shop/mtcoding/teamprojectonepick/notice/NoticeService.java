package shop.mtcoding.teamprojectonepick.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Transactional
    public void 공고등록(NoticeRequestDTO.SaveDTO saveDTO, int sessionUserId){
        Notice notice = Notice.builder()
        .open(saveDTO.isOpen())
        .bizImg(saveDTO.getBizImg())
        .semiTitle(saveDTO.getSemiTitle())
        .semiContent(saveDTO.getSemiContent())
        .workField(saveDTO.getWorkField())
        .bizName(saveDTO.getBizName())
        .bizAddress(saveDTO.getBizAddress())
        .career(saveDTO.getCareer())
        .education(saveDTO.getEducation())
        .mainContent(saveDTO.getMainContent())
        .deadLine(saveDTO.getDeadLine())
        .build();

        noticeRepository.save(notice);
    }

    

}
