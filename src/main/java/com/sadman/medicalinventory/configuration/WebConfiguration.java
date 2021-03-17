package com.sadman.medicalinventory.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@EnableWebMvc
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

//    @Bean
//    public ClassLoaderTemplateResolver yourTemplateResolver() {
//        ClassLoaderTemplateResolver configurer = new ClassLoaderTemplateResolver();
//        configurer.setPrefix("templates/");
//        configurer.setSuffix(".html");
//        configurer.setTemplateMode(TemplateMode.HTML);
//        configurer.setCharacterEncoding("UTF-8");
//        configurer.setOrder(0);
//        configurer.setCacheable(false);
//        configurer.setCheckExistence(true);
//        return configurer;
//    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/",
            "classpath:/resources/",
            "classpath:/static/",
            "classpath:/public/"
//            "classpath:/static/lib/",
//            "classpath:/static/lib/dist/",
//            "classpath:/static/lib/plugins/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}
