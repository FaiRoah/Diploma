package com.fairoah.diploma_stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.fairoah.diploma_stuff.repo.TaskQueueRepo;
import com.fairoah.diploma_stuff.repo.models.Task;
import com.fairoah.diploma_stuff.service.TaskQueueService;
import com.fairoah.lib.Handler;
import com.fairoah.lib.HandlerCreator;
import com.fairoah.lib.HandlersList;
import com.fairoah.lib.Lib;
import com.fairoah.lib.TasksList;
import com.fairoah.lib.TaskQueue;


@SpringBootApplication
public class DiplomaStuffApplication {
	private static final Logger log = LoggerFactory.getLogger(DiplomaStuffApplication.class);

//	@Autowired
//	ApplicationContext applicationContext;
	@Autowired
	private TaskQueueService service;

	private ConfigurableApplicationContext applicationContext;

	
	public static void main(String[] args) throws InterruptedException {

		ConfigurableApplicationContext ctx = SpringApplication.run(DiplomaStuffApplication.class, args);
		
		ctx.close();
	}

	@Autowired
	public void setAppContext(ConfigurableApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Bean
	public CommandLineRunner TheApp() {

		return (args) -> {
			Lib.init(applicationContext, service);

			//Lib.getTaskList().stream().forEach(x -> System.out.println(x.getHandler()));
//			for (Map.Entry m : Lib.getQueueMap().entrySet()) {
//				System.out.println("========================================");
//				System.out.println(m.getKey() + ":");
//				((TaskQueue)m.getValue()).getTasksList().stream().forEach(System.out::println);
//				System.out.println("========================================");
//			}
			Lib.getHandlerList().stream().forEach(System.out::println);
		};
		
	}

	//TODO попробовать объявить bean в отдельном файле и поработать с этим
	
	
	@Bean
	public CommandLineRunner DownloadHandler() {
		return (args) ->{
			System.out.println(service.getTask("Download").toString());
		};
	}

	@Bean
	public CommandLineRunner CallHandler() {
		return (args) ->{
			System.out.println(service.getTask("Call").toString());
		};
	}

//	@Bean
//	public CommandLineRunner TaskQueueHandler(TaskQueueRepo repo) {
//
//		return (args) -> {
//			Runnable daemonThread = new Runnable() {
//				public void run(){
////					for(int i=0; i < 10; i++)
////						service.addTask(i, i);
//					while (true) {
//						log.info("=====================");
//						for (Taskqueue task : repo.findAll())
//							log.info(task.toString());
//						log.info("=====================");
//						log.info("*********************");
////						log.info("deleting first task from queue");
//						log.info("Executing first task");
//						log.info("*********************");
//						if (service.executeFirstTask()) {
//							System.out.println("First task in Taskqueue table executed successfully");							
//						}
//						else {
//							System.out.println("Task sent to queue end");
//						}
////						service.deleteFirstTask();
//						try {
//							Thread.sleep(20000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			};
//			Thread daemon = new Thread(daemonThread);
//			daemon.setName("TaskQueue Handler");
//			daemon.start();
//		};
//	}

}
