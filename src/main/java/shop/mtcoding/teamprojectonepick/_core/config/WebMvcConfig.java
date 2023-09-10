package shop.mtcoding.teamprojectonepick._core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + "./upload/")
                .setCachePeriod(10) // 10 (초)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor()) // 인터셉터 등록
                // 어디 경로에 인터셉터 적용할지 지정
                // user 관련 인터셉터니까 user 경로에만 설정
                .addPathPatterns("/userUpdate", "/resume/writeForm", "/resume/write", "/resume/{id}/viewForm",
                        "/resume/{id}/delete", "/resume/{id}/updateForm", "/resume/{id}/update", "/api/resumeSession",
                        "/logout", "/userUpdate", "/userProfileForm", "/fixUserProfileForm", "/userDelete");

        registry.addInterceptor(new BizLoginInterceptor()) // 인터셉터 등록
                // biz 관련 경로에만 Biz 인터셉터 적용
                .addPathPatterns("/notice/writeNoticeForm", "/notice/{id}", "/api/noticeSession", "/notice/writeNotice",
                        "/notice/updateNoticeForm/{id}", "/notice/{id}/update", "/notice/{id}/delete", "/bizUserUpdate",
                        "/bizProfileForm", "/fixBizProfileForm", "/bizUserDelete");
    }
}
