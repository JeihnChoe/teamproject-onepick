package shop.mtcoding.teamprojectonepick.apply;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.mtcoding.teamprojectonepick._core.error.ex.MyException;
import shop.mtcoding.teamprojectonepick.notice.Notice;
import shop.mtcoding.teamprojectonepick.notice.NoticeRepository;
import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.resume.ResumeRepository;

@Controller
public class ApplyController {

    @Autowired
    private ApplyRepository applyRepository; // ApplicationRepository 추가

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    @PostMapping("/apply")
    public String apply(@RequestParam("resumeId") Integer resumeId,
            @RequestParam("noticeId") Integer noticeId,
            Model model) {
        // 이력서와 공고의 유효성 검사
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        Optional<Notice> optionalNotice = noticeRepository.findById(noticeId); // jobPostingId 변수 사용

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

        // 지원 완료 메시지를 모델에 추가하고 성공 페이지로 이동
        model.addAttribute("message", "지원이 완료되었습니다.");
        return "success-page"; // 성공 페이지로 리다이렉션 또는 이동
    }

}
