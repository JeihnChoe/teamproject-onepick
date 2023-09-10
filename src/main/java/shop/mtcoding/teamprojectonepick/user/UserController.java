package shop.mtcoding.teamprojectonepick.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.resume.ResumeRepository;

@Slf4j
@Controller // 얘는 페이지 반환 용도, 얘는 페이지를 반환
public class UserController {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResumeRepository resumeRepository;

    @PostMapping("/logout") // 로그아웃
    public String logout() {
        session.invalidate();
        System.out.println("로그아웃테스트 : ");
        return "redirect:/";
    }

    @PostMapping("/userUpdate") // 수정하기
    public String update(UserRequest.UpdateDTO updateDTO) {
        System.out.println(updateDTO);
        // 1. 회원수정 (서비스)
        // 2. 세션동기화
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.회원수정(updateDTO, sessionUser.getId());
        session.setAttribute("sessionUser", user);

        return "redirect:/";
    }

    @PostMapping("/bizUserUpdate") // 기업회원수정
    public String bizUpdate(UserRequest.BizUpdateDTO bizUpdateDTO) {
        System.out.println(bizUpdateDTO);
        // 1. 회원수정 (서비스)
        // 2. 세션동기화
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.기업회원수정(bizUpdateDTO, sessionUser.getId());
        System.out.println(sessionUser.username);
        session.setAttribute("sessionUser", user);
        return "redirect:/";
    }

    @PostMapping("/userLogin") // 개인유저 로그인
    public String userLogin(UserRequest.LoginDTO loginDTO) {
        User sessionUser = userService.유저로그인(loginDTO);
        if (sessionUser.usercode == 1) {
            session.setAttribute("user", sessionUser);

        } else if (sessionUser.usercode == 2) {
            session.setAttribute("sessionBiz", sessionUser);
        }

        session.setAttribute("sessionUser", sessionUser);

        return "redirect:/";
    }

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    @GetMapping("/userJoinForm") // 개인유저회원가입페이지
    public String userJoinForm() {
        return ("/user/userJoinForm");
    }

    @PostMapping("/userJoin") // 회원가입포스트
    public String userJoin(UserRequest.JoinDTO joinDTO) {
        // 비밀번호랑 비밀번호 확인이 같지 않으면 오류 발생
        if (!joinDTO.getPassword().equals(joinDTO.getPasswordConfirm())) {
            // TODO 예외 클래스 만들어서 ControllerAdvice에서 처리하기!!
            throw new RuntimeException("비밀번호가 동일하지 않음!!");
        }

        userService.유저회원가입(joinDTO);

        return "/user/loginForm";
    }

    @PostMapping("/bizUserJoin") // 기업회원가입 포스트
    public String bizUserJoin(UserRequest.BizJoinDTO bizjoinDTO) {
        if (!bizjoinDTO.getPassword().equals(bizjoinDTO.getPasswordConfirm())) {
            // TODO 예외 클래스 만들어서 ControllerAdvice에서 처리하기!!
            throw new RuntimeException("비밀번호가 동일하지 않음!!");
        }

        userService.기업유저회원가입(bizjoinDTO);

        return "/user/loginForm";
    }

    @GetMapping("/bizJoinForm") // 기업회원가입페이지
    public String bizJoinForm() {
        return "/user/bizJoinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    // 개인 변동사항

    @GetMapping("/userProfileForm") // 개인유저프로필페이지
    public String userProfile(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.회원프로필조회(sessionUser.getId());
        UserResponse.UserProfileFormDTO userProfileFormDTO = new UserResponse.UserProfileFormDTO(
                user.getPicUrl(),
                user.getUsername(),
                user.getEmail(), user.getTel());

        log.info("userInfo : {}", userProfileFormDTO);

        model.addAttribute("userInfo", userProfileFormDTO);

        List<Resume> resumeList = resumeRepository.findByUserId(sessionUser.getId());
        model.addAttribute("resumeList", resumeList);

        return ("/user/userProfileForm");
    }

    @GetMapping("/fixUserProfileForm") // 개인수정페이지
    public String fixUserProfile(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.회원정보조회(sessionUser.getId());
        UserResponse.UserInfoResponseDTO userInfoResponseDTO = new UserResponse.UserInfoResponseDTO(user.getId(),
                user.getPassword(), user.getUsername(), user.getTel(),
                user.getBirth(), user.getAddress(), user.getPicUrl());
        model.addAttribute("userInfo", userInfoResponseDTO);
        return ("/user/fixUserProfileForm");
    }

    // 기업 변동사항

    @GetMapping("/bizProfileForm") // 기업회원프로필페이지
    public String bizProfileForm(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.기업회원프로필조회(sessionUser.getId());
        UserResponse.BizUserProfileFormDTO bizuserProfileFormDTO = new UserResponse.BizUserProfileFormDTO(
                user.getPicUrl(),
                user.getBizname(),
                user.getUsername(), user.getEmail(), user.getTel());
        model.addAttribute("userInfo", bizuserProfileFormDTO);
        return "/user/bizProfileForm";
    }

    @GetMapping("/fixBizProfileForm") // 기업회원수정페이지
    public String fixBizProfileForm(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.기업회원정보조회(sessionUser.getId());
        UserResponse.BizUserInfoResponseDTO bizUserInfoResponseDTO = new UserResponse.BizUserInfoResponseDTO(
                user.getPassword(),
                user.getBizname(),
                user.getUsername(),
                user.getTel(),
                user.getAddress(),
                user.getAddress2(),
                user.getPicUrl());

        model.addAttribute("userInfo", bizUserInfoResponseDTO);
        return "/user/fixBizProfileForm";
    }

    // 탈퇴하기
    @PostMapping("/userDelete") // 개인 유저 회원 탈퇴
    public String userDelete() {
        User sessionUser = (User) session.getAttribute("sessionUser");

        userService.회원탈퇴(sessionUser.getId());
        session.invalidate();

        return "redirect:/";
    }

    @PostMapping("/bizUserDelete") // 기업 유저 회원 탈퇴
    public String bizUserDelete() {
        User sessionUser = (User) session.getAttribute("sessionUser");

        userService.기업회원탈퇴(sessionUser.getId());

        session.invalidate();

        return "redirect:/";
    }

}
