package com.xw.springboot.Config;



import com.xw.springboot.component.LoginHandlerInterceptor;
import com.xw.springboot.component.MyLocaleReolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用WebMvcConfigurer可以扩展SpringMVC的功能
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewController(registry);
        //浏览器发送/xw 请求来到 /successs 界面
        registry.addViewController("/xw").setViewName("/success");
    }

    //所有的WebMvcConfigurer都会生效
    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer config=new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源； *.css
                //spring已经做好了
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("*.do")
                        .excludePathPatterns("/","/index.html","/user/login");
            }
        };
        return config;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleReolver();
    }
}
