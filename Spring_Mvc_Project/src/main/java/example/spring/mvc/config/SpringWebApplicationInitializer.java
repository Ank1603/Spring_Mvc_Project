package example.spring.mvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class SpringWebApplicationInitializer implements WebApplicationInitializer{

	//this class is used to configure DispatcherServlet in 
	//such a way that it accepts all incoming requests 
	
	private WebApplicationContext getWebApplicationContext() {
		
		AnnotationConfigWebApplicationContext webCtx =
				new AnnotationConfigWebApplicationContext();
		webCtx.setConfigLocation("example");
		
		//This is equivalent of @ComponentScan(basePackages = "example")
		
		
		return webCtx;
		
	}
	
	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
	System.out.println("Application is being started...");
		WebApplicationContext webAppCtx = getWebApplicationContext();
		//Building an object of DispatcherServlet based upon webAppctx
	DispatcherServlet frontController = new DispatcherServlet(webAppCtx);
	
	ServletRegistration.Dynamic registration =ctx.addServlet("myFrontController",frontController);
	
	//Configuring FrontController servlet that accepts all request
	
	registration.addMapping("/");
	}

	
}
