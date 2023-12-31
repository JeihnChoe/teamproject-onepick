package shop.mtcoding.teamprojectonepick.user;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamprojectonepick._core.error.ex.MyException;
import shop.mtcoding.teamprojectonepick._core.error.ex.PasswordNotMatchedException;
import shop.mtcoding.teamprojectonepick._core.vo.MyPath;
import shop.mtcoding.teamprojectonepick.user.UserRequest.BizUpdateDTO;
import shop.mtcoding.teamprojectonepick.user.UserRequest.LoginDTO;
import shop.mtcoding.teamprojectonepick.user.UserRequest.UpdateDTO;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 유저회원가입(UserRequest.JoinDTO joinDTO) {
        if (!joinDTO.isLoginIdCheck()) {
            throw new LoginIdNotCheckedException();
        }

        User user = User.builder()
                .loginId(joinDTO.getLoginId())
                .password(joinDTO.getPassword())
                .username(joinDTO.getUsername())
                .email(joinDTO.getEmail())
                .tel(joinDTO.getTel())
                .birth(joinDTO.getBirth())
                .usercode(joinDTO.getUsercode())

                .build();
        userRepository.save(user);
    }

    @Transactional
    public void 기업유저회원가입(UserRequest.BizJoinDTO bizjoinDTO) {
           if (!bizjoinDTO.isLoginIdCheck()) {
            throw new LoginIdNotCheckedException();
        }

        User user = User.builder()
                .loginId(bizjoinDTO.getLoginId())
                .password(bizjoinDTO.getPassword())
                .bizname(bizjoinDTO.getBizname())
                .username(bizjoinDTO.getUsername())
                .email(bizjoinDTO.getEmail())
                .tel(bizjoinDTO.getTel())
                .usercode(bizjoinDTO.getUsercode())
                .build();
        userRepository.save(user);
    }

    public User 회원정보보기(Integer id) { // 2번
        return userRepository.findById(id).get();
    }

    public User 유저로그인(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getLoginId());

        // 1. 유저네임 검증
        if (user == null) {
            throw new MyException("유저네임이 없습니다");
        }

        // 2. 패스워드 검증
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new PasswordNotMatchedException();
        }

        // 3. 로그인 성공
        return user;
    }

    @Transactional
    public User 회원수정(UpdateDTO updateDTO, Integer id) {

        String fileName = null;
        if (!updateDTO.getPic().isEmpty()) {
            UUID uuid = UUID.randomUUID(); // 랜덤한 해시값을 만들어줌
            fileName = uuid + "_" + updateDTO.getPic().getOriginalFilename();
            System.out.println("fileName : " + fileName);

            // 프로젝트 실행 파일변경 -> blogv2-1.0.jar
            // 해당 실행파일 경로에 images 폴더가 필요함
            Path filePath = Paths.get(MyPath.IMG_PATH + fileName);
            try {
                Files.write(filePath, updateDTO.getPic().getBytes());
            } catch (Exception e) {
                throw new MyException(e);
            }
        }

        // 1. 조회 (영속화)
        User user = userRepository.findById(id).get();
        // 2. 변경
        user.setPassword(updateDTO.getPassword());
        user.setUsername(updateDTO.getUsername());
        user.setTel(updateDTO.getTel());
        user.setBirth(updateDTO.getBirth());
        user.setAddress(updateDTO.getAddress());
        // 새로 받은 파일이 없으면 안바꿈!!
        if (fileName != null) {
            user.setPicUrl(fileName);
        }
        System.out.println("테스트" + fileName);
        return user;

    }

    @Transactional
    public User 기업회원수정(BizUpdateDTO bizUpdateDTO, Integer id) {
        String fileName = null;
        if (!bizUpdateDTO.getPic().isEmpty()) {
            UUID uuid = UUID.randomUUID(); // 랜덤한 해시값을 만들어줌
            fileName = uuid + "_" + bizUpdateDTO.getPic().getOriginalFilename();
            System.out.println("fileName : " + fileName);

            // 프로젝트 실행 파일변경 -> blogv2-1.0.jar
            // 해당 실행파일 경로에 images 폴더가 필요함
            Path filePath = Paths.get(MyPath.IMG_PATH + fileName);
            try {
                Files.write(filePath, bizUpdateDTO.getPic().getBytes());
            } catch (Exception e) {
                throw new MyException(e);
            }
        }
        // 1. 조회 (영속화)
        User user = userRepository.findById(id).get();

        user.setPassword(bizUpdateDTO.getPassword());
        user.setBizname(bizUpdateDTO.getBizname());
        user.setUsername(bizUpdateDTO.getUsername());
        user.setTel(bizUpdateDTO.getTel());
        user.setAddress(bizUpdateDTO.getAddress());
        user.setAddress2(bizUpdateDTO.getAddress2());
        if (fileName != null) {
            user.setPicUrl(fileName);
        }

        return user;
    }

    public User 회원정보조회(Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public User 기업회원정보조회(Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public User 회원프로필조회(Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public User 기업회원프로필조회(Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @Transactional
    public void 회원탈퇴(Integer id) {

        User user = userRepository.findById(id).orElseThrow(() -> new MyException("해당 사용자를 찾을 수 없습니다."));

        userRepository.delete(user);
    }

    @Transactional
    public void 기업회원탈퇴(Integer id) {

        User user = userRepository.findById(id).orElseThrow(() -> new MyException("기업 사용자를 찾을 수 없습니다."));

        userRepository.delete(user);
    }
    @Transactional
    public void resetPassword(Integer loginId, String newPassword) {
        // 사용자 ID를 기반으로 사용자 정보를 조회.
        User user = userRepository.findById(loginId).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 새로운 비밀번호로 업데이트.
        user.setPassword(newPassword);

        // 변경된 비밀번호를 저장.
        userRepository.save(user);
    }

    public boolean 로그인아이디중복체크(String loginId) {
        // true가 아니면? 그 아이디를 쓰는 사람이 있음. 오류 발생!!
        if (!userRepository.findByLoginId(loginId).isEmpty()) {
            throw new LoginIdDuplicatedException();
        }

        return true;
    }
}
