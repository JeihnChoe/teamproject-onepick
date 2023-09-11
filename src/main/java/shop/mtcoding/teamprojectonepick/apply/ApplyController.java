package shop.mtcoding.teamprojectonepick.apply;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamprojectonepick._core.util.ApiUtil;

@Controller
public class ApplyController { // 주석

    @Autowired
    private ApplyService applyService;

    @Autowired
    private HttpSession session;

    @PostMapping("/apply")
    public @ResponseBody ApiUtil<String> apply(@RequestBody ApplyRequest.AddDTO dto, Model model) {
        System.out.println("테스트 : " + dto.getResumeId());
        System.out.println("테스트 : " + dto.getNoticeId());
        applyService.지원하기(dto.getResumeId(), dto.getNoticeId());

        return new ApiUtil<>(true, "지원성공"); // json 으로 변경
    }

}
