package shop.mtcoding.teamprojectonepick.notice;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

        UUID uuid = UUID.randomUUID(); // 랜덤한 해시값을 만들어줌
        String fileName = uuid+"_"+saveDTO.getUserImg().getOriginalFilename();
        System.out.println("fileName : "+fileName);

        Path filePath=Paths.get( "./images/" +fileName);

       try {
        Files.write(filePath, saveDTO.getUserImg().getBytes());
       } catch (Exception e) {
        // TODO: handle exception
       }

        Notice notice = Notice.builder()
                .open(saveDTO.getOpen())
                .userImg(fileName)
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
    public Notice 상세보기 (Integer id) {
        // Notice를 가져오려고 시도합니다.
      Optional<Notice> noticeOP = noticeRepository.findById(id);
      return noticeOP.get();

            }
        
}


