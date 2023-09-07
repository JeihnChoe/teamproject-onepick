package shop.mtcoding.teamprojectonepick.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.resume.ResumeRepository;

@Controller

public class UserController {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;

    @Autowired
    private ResumeRepository resumeRepository;

    @PostMapping("/logout")
    public String logout() {
        session.invalidate();
        System.out.println("로그아웃테스트 : ");
        return "redirect:/";
    }

    @PostMapping("/userUpdate")
    public String update(UserRequestDTO.UpdateDTO updateDTO) {
        System.out.println(updateDTO);
        // 1. 회원수정 (서비스)
        // 2. 세션동기화
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.회원수정(updateDTO, sessionUser.getId());
        session.setAttribute("sessionUser", user);

        return "redirect:/";
    }

    @PostMapping("/bizUserUpdate")
    public String bizUpdate(UserRequestDTO.BizUpdateDTO bizUpdateDTO) {
        System.out.println(bizUpdateDTO);
        // 1. 회원수정 (서비스)
        // 2. 세션동기화
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.기업회원수정(bizUpdateDTO, sessionUser.getId());
        System.out.println(sessionUser.username);
        session.setAttribute("sessionUser", user);
        return "redirect:/";
    }

    @PostMapping("/userLogin")
    public String userLogin(UserRequestDTO.LoginDTO loginDTO) {
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

    @GetMapping("/userJoinForm")
    public String userJoinForm() {
        return ("/user/userJoinForm");
    }

    @PostMapping("/userJoin")
    public String userJoin(UserRequestDTO.JoinDTO joinDTO) {
        userService.유저회원가입(joinDTO);

        return "/user/loginForm";
    }

    @PostMapping("/bizUserJoin")
    public String bizuserJoin(UserRequestDTO.BizJoinDTO bizjoinDTO) {
        userService.기업유저회원가입(bizjoinDTO);

        return "/user/loginForm";
    }

    @GetMapping("/bizJoinForm")
    public String bizJoinForm() {
        return "/user/bizJoinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    // 개인 변동사항

    @GetMapping("/userProfileForm")

    public String userProfile(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.회원프로필조회(sessionUser.getId());
        UserResponseDTO.UserProfileFormDTO userProfileFormDTO = new UserResponseDTO.UserProfileFormDTO(
                "" + user.getPicUrl(),
                user.getUsername(),
                user.getEmail(), user.getTel());
        model.addAttribute("userInfo", userProfileFormDTO);

        List<Resume> resumeList = resumeRepository.findByUserId(sessionUser.getId());
        model.addAttribute("resumeList", resumeList);

        return ("/user/userProfileForm");
    }

    @GetMapping("/fixUserProfileForm")
    public String fixUserProfile(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.회원정보조회(sessionUser.getId());
        UserResponseDTO.UserInfoResponseDTO userInfoResponseDTO = new UserResponseDTO.UserInfoResponseDTO(user.getId(),
                user.getPassword(), user.getUsername(), user.getTel(),
                user.getBirth(), user.getAddress(), "" + user.getPicUrl());
        model.addAttribute("userInfo", userInfoResponseDTO);
        return ("/user/fixUserProfileForm");
    }

    // 기업 변동사항

    @GetMapping("/bizProfileForm")
    public String bizProfileForm(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.기업회원프로필조회(sessionUser.getId());
        UserResponseDTO.UserProfileFormDTO userProfileFormDTO = new UserResponseDTO.UserProfileFormDTO(
                "" + user.getPicUrl(),
                user.getUsername(), user.getEmail(), user.getTel());
        model.addAttribute("userInfo", userProfileFormDTO);
        return "/user/bizProfileForm";
    }

    @GetMapping("/fixBizProfileForm")
    public String fixBizProfileForm(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        User user = userService.기업회원정보조회(sessionUser.getId());
        UserResponseDTO.BizUserInfoResponseDTO bizUserInfoResponseDTO = new UserResponseDTO.BizUserInfoResponseDTO(
                user.getPassword(), user.getBizname(), user.getUsername(), user.getTel(), user.getAddress(),
                user.getAddress2(),
                "" + user.getPicUrl());
        model.addAttribute("userInfo", bizUserInfoResponseDTO);
        return "/user/fixBizProfileForm";
    }

}