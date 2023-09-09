package shop.mtcoding.teamprojectonepick.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @PostMapping("/apply")
    public String apply(ApplyRequest.AddDTO dto,
            Model model) {
        applyService.지원하기(dto.getResumeId(), dto.getNoticeId());

        // 지원 완료 메시지를 모델에 추가하고 성공 페이지로 이동
        model.addAttribute("message", "지원이 완료되었습니다.");
        return "redirect:/userProfileForm"; // 성공 페이지로 리다이렉션 또는 이동
    }

}
