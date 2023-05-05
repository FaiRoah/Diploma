package com.fairoah.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.type.StandardMethodMetadata;

public class HandlersList {
	private static ArrayList<Handler> handlersList;
	
	private static ApplicationContext applicationContext;

	public static ArrayList<Handler> init(ApplicationContext appCont) {
		handlersList = new ArrayList<Handler>();
		applicationContext = appCont;
		ConfigurableListableBeanFactory factory = ((ConfigurableListableBeanFactory) applicationContext.getAutowireCapableBeanFactory());
		Arrays.stream(factory.getBeanDefinitionNames())
			.filter(beanName -> factory.getBeanDefinition(beanName).getSource() instanceof StandardMethodMetadata)
			.filter(beanName -> beanName.contains("Handler"))                
			.forEach(beanName -> handlersList.add(new Handler(beanName)));
		return handlersList;
	}
	
	public static Handler getHandler(int index){
		return handlersList.get(index);
	}
	public static ArrayList<Handler> getHandlerList(){
		return handlersList;
	}
}
