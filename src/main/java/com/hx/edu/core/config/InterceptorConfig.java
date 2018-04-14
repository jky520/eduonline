package com.hx.edu.core.config;

import com.hx.edu.core.interceptor.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by DT人 on 2018/4/11 13:03.
 */
@Configuration
public class InterceptorConfig  extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         String[] patterns = new String[] { "/login","/*.html","/swagger-resources/**"}; // 配置不被拦截的路径
        // 可以注册多个拦截器
        /* registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");*/
        registry.addInterceptor(new SysInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
        super.addInterceptors(registry);
    }
}
