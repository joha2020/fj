package com.argos.copier;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Copier {

	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("config.properties");
			prop.load(input);
			JobDetail job = JobBuilder.newJob(CronJob.class)
					.withIdentity("argos", "group").build();
			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity("trigger", "group1")
					.withSchedule(
							CronScheduleBuilder.cronSchedule(prop
									.getProperty("quartz.expression"))).build();

			// schedule it
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {

			System.out.println("Error" + e);
		}

	}

}
