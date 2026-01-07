/*----------------------
package com.rvs.emarket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig_bk implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // aplica CORS a todos los endpoints
                .allowedOrigins("*") // o poner tus dominios específicos
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") ;
            //    .allowedHeaders("*")
             //   .allowCredentials(true)
             //   .maxAge(3600); // cache de pre-flight requests
    }

}


 */