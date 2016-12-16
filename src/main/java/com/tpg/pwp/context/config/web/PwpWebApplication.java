package com.tpg.pwp.context.config.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
@Import(PwpWebConfig.class)
@EnableAutoConfiguration
public class PwpWebApplication extends SpringBootServletInitializer {
    private static final String MAPPING_CONTEXT = "/*";
    private static final String THROW_EXCEPTION_FOR_NO_HANDLER_KEY = "throwExceptionIfNoHandlerFound";

    private static final int LOAD_ON_STARTUP = 2;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PwpWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PwpWebApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext webApplicationContext = getContext();
        servletContext.addListener(new ContextLoaderListener(webApplicationContext));

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet",
            new DispatcherServlet(webApplicationContext));
        dispatcher.setLoadOnStartup(LOAD_ON_STARTUP);
        dispatcher.addMapping(MAPPING_CONTEXT);
        dispatcher.setInitParameter(THROW_EXCEPTION_FOR_NO_HANDLER_KEY, "true");
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        return context;
    }
}
