package spittr.config;

import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.web.WebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }

 @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

  @Override
  public void onStartup(ServletContext servletContext)
          throws ServletException {
    super.onStartup(servletContext);
    ServletRegistration.Dynamic servlet = servletContext
            .addServlet("h2-console", new WebServlet());
    servlet.setLoadOnStartup(2);
    servlet.addMapping("/console/*");
  }
}