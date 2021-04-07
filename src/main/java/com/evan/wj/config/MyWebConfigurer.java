package com.evan.wj.config;

import com.evan.wj.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/5 22:53
 * @param
 * @return
 */
@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有的应用路径添加拦截器
        registry.addInterceptor(getLoginIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/logout");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 所有请求都允许跨域
        registry.addMapping("/**")
                .allowCredentials(true)
                // 跨域问题
                .allowedOrigins("http://localhost:8081")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "d:/workspace/img/");
    }
}
