package com.nsdl.soapdemo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapWSConfig {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*");
	}

	@Bean(name = "loanEligibility") // any name we can give
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("LoanEligibilityindicator"); // any name we can give
		defaultWsdl11Definition.setLocationUri("/ws"); // same url we provide which mapped to servlet
		defaultWsdl11Definition.setTargetNamespace("http://www.nsdl.com/soapdemo/api/loanEligibility"); // target name url which is on xsd
		defaultWsdl11Definition.setSchema(schema);
		return defaultWsdl11Definition;

	}

	@Bean
	public XsdSchema schema() {
		return new SimpleXsdSchema(new ClassPathResource("loaneligibility.xsd"));
	}
	
	
	@Bean(name = "addition") // any name we can give
	public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema schema2) {
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("LoanEligibilityindicator"); // any name we can give
		defaultWsdl11Definition.setLocationUri("/ws"); // same url we provide which mapped to servlet
		defaultWsdl11Definition.setTargetNamespace("http://www.nsdl.com/soapdemo/api/add"); // target name url which is on xsd
		defaultWsdl11Definition.setSchema(schema2);
		return defaultWsdl11Definition;

	}

	@Bean
	public XsdSchema schema2() {
		return new SimpleXsdSchema(new ClassPathResource("add.xsd"));
	}

}
