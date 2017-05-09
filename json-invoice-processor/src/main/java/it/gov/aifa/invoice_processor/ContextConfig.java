package it.gov.aifa.invoice_processor;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAspectJAutoProxy
@EnableTransactionManagement
// See https://spring.io/blog/2015/03/26/what-s-new-in-spring-data-fowler#jsr-310-and-threeten-backport-support
@EntityScan(basePackageClasses = { ContextConfig.class, Jsr310JpaConverters.class })
public class ContextConfig{
	private static final Logger log = LoggerFactory.getLogger(ContextConfig.class);
	
	private ApplicationContext applicationContext;
	
	public ContextConfig(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	@PostConstruct
	public void postInitialization(){
		echoApplicationConfiguration();
	}
	
	/**
	 * Load the configuration and echoes it.
	 */
	private void echoApplicationConfiguration(){
		log.debug("Searching for beans with @ConfigurationProperties annotation");
		Map<String,Object> beans = applicationContext.getBeansWithAnnotation(ConfigurationProperties.class);
		Map<String,String> beansToString = new HashMap<>(beans.size());
		for(String beanName : beans.keySet()){
			beansToString.put(beanName, ToStringBuilder.reflectionToString(beans.get(beanName)));
		}
		log.debug("Current configuration: {}", beansToString);
	}
	
	@Bean
	public CustomizableTraceInterceptor customizableTraceInterceptor() {
	    CustomizableTraceInterceptor cti = new CustomizableTraceInterceptor();
	    cti.setEnterMessage("Entering method '" + CustomizableTraceInterceptor.PLACEHOLDER_METHOD_NAME + "("+ CustomizableTraceInterceptor.PLACEHOLDER_ARGUMENTS+", types: " + CustomizableTraceInterceptor.PLACEHOLDER_ARGUMENT_TYPES + ")' of class [" + CustomizableTraceInterceptor.PLACEHOLDER_TARGET_CLASS_NAME + "]");
	    cti.setExitMessage("Exiting method '" + CustomizableTraceInterceptor.PLACEHOLDER_METHOD_NAME + "' of class [" + CustomizableTraceInterceptor.PLACEHOLDER_TARGET_CLASS_NAME + "] took " + CustomizableTraceInterceptor.PLACEHOLDER_INVOCATION_TIME+"ms. Return: " + CustomizableTraceInterceptor.PLACEHOLDER_RETURN_VALUE);
	    return cti;
	}
	
	public static void main(String[] args) {
        SpringApplication.run(ContextConfig.class, args).close();
    }
	
	@Bean
	public Advisor traceAdvisor() {
	    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	    pointcut.setExpression("execution(* it.gov.aifa..*.*(..))");
	    return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
	}
}
