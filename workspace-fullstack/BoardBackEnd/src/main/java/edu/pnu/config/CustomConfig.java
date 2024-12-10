package edu.pnu.config;

import java.net.http.HttpHeaders;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.NonNull;

@Configuration
public class CustomConfig implements WebMvcConfigurer {

//    @Override
//    public void addCorsMappings(@NonNull CorsRegistry registry) {
//        // 모든 주소
//        registry.addMapping("/**")
//                // 모든 Method
//                .allowedMethods(CorsConfiguration.ALL)
//                // 모든 출처에 대해서 허용
//                .allowedOrigins(CorsConfiguration.ALL);
//    }
	
//    @Override
//    public void addCorsMappings(@NonNull CorsRegistry registry) {
//        // /board 포함한 모든 주소
//        registry.addMapping("/board/**")
//                // Get & Post Method
//                .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name())
//                // 아래 주소가 출처인 경우에 대해서 허용
//                .allowedOrigins("http://localhost:3000", "http://127.0.0.1:3000");
//
//        // /member 포함한 모든 주소
//        registry.addMapping("/member/**")
//                // Get & Put Method
//                .allowedMethods(HttpMethod.GET.name(), HttpMethod.PUT.name())
//                // 아래 주소가 출처인 경우에 대해서 허용
//                .allowedOrigins("http://localhost:3000");
//    }
    
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true) // 클라이언트가 자격증명(쿠키/인증헤더)을 포함하도록 허용
                .allowedHeaders(org.springframework.http.HttpHeaders.AUTHORIZATION) // 클라이언트가 요청 시 사용할 수 있는 헤더 지정
                .exposedHeaders(org.springframework.http.HttpHeaders.AUTHORIZATION) // 클라이언트가 응답에 접근할 수 있는 헤더 지정
                .allowedMethods(
                    HttpMethod.GET.name(),
                    HttpMethod.POST.name(),
                    HttpMethod.PUT.name(),
                    HttpMethod.DELETE.name())
                .allowedOrigins(
                    "http://localhost:3000",
                    "http://127.0.0.1:3000");
   }


}