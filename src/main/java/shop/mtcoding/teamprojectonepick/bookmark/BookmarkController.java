package shop.mtcoding.teamprojectonepick.bookmark;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import shop.mtcoding.teamprojectonepick._core.util.ApiUtil;
import shop.mtcoding.teamprojectonepick.user.User;

@Controller
public class BookmarkController {

    @Autowired
    private HttpSession session;
    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("/bookmark/save")
    public ResponseEntity<?> save(@RequestBody Bookmark bookmark) {// RequestBody는 HTTP 요청의
                                                                                        // 본문(body)에 있는 데이터를 자바 객체로 변환

        // 세션에서 유저 아이디 가져오기
        User sessionUser = (User) session.getAttribute("sessionUser"); // "userId"는 세션에 저장된 사용자 아이디의 키.

        // 유저 아이디와 notice 아이디를 사용하여 BookmarkId 생성
        int bookmarkId = bookmarkService.insertBookmark(bookmark.getResume().getId(), sessionUser.getId()); // loveService를 사용하여 좋아요 정보를
                                                                                         // 저장하고, 그 결과로 생성된 좋아요 ID를
                                                                                         // loveId에 저장합니다.

        // ResponseEntity 클라이언트에게 전달되어야 하는 데이터와 HTTP 응답 코드를 결정하는 데 유용
        return new ResponseEntity<>(new ApiUtil<>(true, bookmarkId), HttpStatus.OK);
    }

}
