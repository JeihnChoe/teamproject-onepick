package shop.mtcoding.teamprojectonepick.user;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamprojectonepick._core.error.ex.MyException;
import shop.mtcoding.teamprojectonepick._core.error.ex.PasswordNotMatchedException;
import shop.mtcoding.teamprojectonepick._core.vo.MyPath;
import shop.mtcoding.teamprojectonepick.user.UserRequestDTO.BizUpdateDTO;
import shop.mtcoding.teamprojectonepick.user.UserRequestDTO.LoginDTO;
import shop.mtcoding.teamprojectonepick.user.UserRequestDTO.UpdateDTO;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 유저회원가입(UserRequestDTO.JoinDTO joinDTO) {
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
    public void 기업유저회원가입(UserRequestDTO.BizJoinDTO bizjoinDTO) {
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

    @Transactional
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
        UUID uuid = UUID.randomUUID(); // 랜덤한 해시값을 만들어줌
        String fileName = uuid + "_" + updateDTO.getPic().getOriginalFilename();
        System.out.println("fileName : " + fileName);

        // 프로젝트 실행 파일변경 -> blogv2-1.0.jar
        // 해당 실행파일 경로에 images 폴더가 필요함
        Path filePath = Paths.get(MyPath.IMG_PATH + fileName);
        try {
            Files.write(filePath, updateDTO.getPic().getBytes());
        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }

        // 1. 조회 (영속화)
        User user = userRepository.findById(id).get();

        // 2. 변경

        user.setPassword(updateDTO.getPassword());
        user.setUsername(updateDTO.getUsername());
        user.setTel(updateDTO.getTel());
        user.setBirth(updateDTO.getBirth());
        user.setAddress(updateDTO.getAddress());
        // user.setPicUrl(fileName);

        return user;
    }

    @Transactional
    public User 기업회원수정(BizUpdateDTO bizUpdateDTO, Integer id) {
        UUID uuid = UUID.randomUUID(); // 랜덤한 해시값을 만들어줌
        // String fileName = uuid + "_" + bizUpdateDTO.getPic().getOriginalFilename();
        // System.out.println("fileName : " + fileName);

        // // 프로젝트 실행 파일변경 -> blogv2-1.0.jar
        // // 해당 실행파일 경로에 images 폴더가 필요함
        // Path filePath = Paths.get(MyPath.IMG_PATH + fileName);
        // try {
        // Files.write(filePath, bizUpdateDTO.getPic().getBytes());
        // } catch (Exception e) {
        // throw new MyException(e.getMessage());
        // }

        // 1. 조회 (영속화)
        User user = userRepository.findById(id).get();

        user.setPassword(bizUpdateDTO.getPassword());
        user.setBizname(bizUpdateDTO.getBizname());
        user.setUsername(bizUpdateDTO.getUsername());
        user.setTel(bizUpdateDTO.getTel());
        user.setAddress(bizUpdateDTO.getAddress());

        return user;
    }
}
