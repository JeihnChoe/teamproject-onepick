package shop.mtcoding.teamprojectonepick.apply;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamprojectonepick._core.error.ex.MyException;
import shop.mtcoding.teamprojectonepick.notice.Notice;
import shop.mtcoding.teamprojectonepick.notice.NoticeRepository;
import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.resume.ResumeRepository;

@Service
@Transactional(readOnly = true)
public class ApplyService {

    @Autowired
    private ApplyRepository applyRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    public void 지원하기(Integer resumeId, Integer noticeId) {
        // 이력서와 공고의 유효성 검사
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        Optional<Notice> optionalNotice = noticeRepository.findById(noticeId);

        if (!optionalResume.isPresent() || !optionalNotice.isPresent()) {
            // 이력서 또는 공고가 존재하지 않을 경우 오류 처리
            throw new MyException("이력서 또는 공고가 존재하지 않습니다.");
        }

        // 이력서 및 공고 정보를 사용하여 지원 정보 생성 및 저장
        Apply apply = new Apply();
        apply.setResume(optionalResume.get());
        apply.setNotice(optionalNotice.get());
        apply.setApplicationDate(new Date()); // 현재 날짜와 시간으로 설정

        applyRepository.save(apply);
    }
}
