package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImagenConfigurer implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        
        // esta linea te da acceso a los recursos por defecto
        WebMvcConfigurer.super.addResourceHandlers(registry);
        //y agregamos la customizada :
        registry.addResourceHandler("/recursos/**")
                .addResourceLocations("file:" + "/home/diana/pruebas/recursos/");
                                                // OJO ruta harcodeada

    }
    
}
