package aips.duncok.common.config;

import aips.duncok.common.interceptor.CommonInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CommonMvcConfig implements WebMvcConfigurer {

    @Value("${backend-url}")
    private String backendUrl;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor(backendUrl))
            .addPathPatterns("/**")
            .excludePathPatterns("/")
            .excludePathPatterns("/log**/**")
            .excludePathPatterns("/assets/**")
            .excludePathPatterns("/sample/**")
        ;
    }
}