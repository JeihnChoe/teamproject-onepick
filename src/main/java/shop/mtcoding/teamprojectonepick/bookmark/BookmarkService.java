package shop.mtcoding.teamprojectonepick.bookmark;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.resume.ResumeRepository;

@Service
public class BookmarkService {

    @Autowired
    BookmarkRepository bookmarkRepository;
    @Autowired
    ResumeRepository resumeRepository;

    @Transactional
    public int insertBookmark(int resumeId, int bizId) {

        // 게시글 존재 여부 체크
        Optional<Resume> resumePS = resumeRepository.findById(resumeId);
        if (!resumePS.isPresent()) { // 해당 optional객체가 값이 없을경우
            throw new EntityNotFoundException("해당 게시글은 없는 게시글입니다.");
        }
        // DB에 해당 이력서 번호가 있을 경우

        Bookmark bookmark = new Bookmark(); // 북마크 객체생성
        bookmark.getResume().setId(resumeId);// 북마크필드에 속성부여
        bookmark.getUser().setId(bizId); // 세션 유저아이디(기업으로 로그인한.)
        bookmarkRepository.save(bookmark); // 북마크DB에 북마크객체 저장

        return bookmark.getId();

    }
}
