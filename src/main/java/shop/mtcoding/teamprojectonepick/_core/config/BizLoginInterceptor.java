package shop.mtcoding.teamprojectonepick._core.config;

import org.springframework.web.servlet.HandlerInterceptor;
import shop.mtcoding.teamprojectonepick.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BizLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User sessionUser = (User) request.getSession().getAttribute("sessionUser");
        // 로그인 되지 않았으면 sessionUser는 null임
        if (sessionUser == null) {
            response.sendRedirect("/error/401");
            return false;
        }

        // 여기부턴 로그인 된 유저
        // Biz 유저가 아니면
        if (sessionUser.getUsercode() != 2) {
            response.sendRedirect("/error/403-biz");
            return false;
        }

        return true;
    }
}
