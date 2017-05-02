package my.mycompany.myapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

// Create a deployable war file
// This makes use of Spring Framework’s Servlet 3.0 support and allows you to configure 
// your application when it’s launched by the servlet container.

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootSampleShiroWebJspApplication.class);
	}

}
