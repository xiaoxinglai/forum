package com.nchu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by user12 on 2018/2/17.
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter{

    @Value("${web.upload-path}")
    private String path;
    /**
     * 自定义的图像映射路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadImg/**").
                addResourceLocations("file:"+path);
        //指定到外部文件夹

        super.addResourceHandlers(registry);

    }


    /**
     * 自定义的拦截器 用于验证session
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(new Interceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/index")
//        .excludePathPatterns("/login")
//        .excludePathPatterns("/sign")
//        .excludePathPatterns("/doSign")
//        .excludePathPatterns("/doLogin"); todo 这里还会把获取问题的接口一并拦截掉 所以要改


         registry.addInterceptor(new Interceptor())
                .excludePathPatterns("/**");

        super.addInterceptors(registry);
    }



}
