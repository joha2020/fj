package com.argos.copier;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CronJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		// InputStream inStream = null;
		// OutputStream outStream = null;

		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("config.properties");
			prop.load(input);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = df.format(new Date());
			File source = new File(prop.getProperty("filepath"));
			// File destination =new
			// File("C:\\Anwar\\testing\\copy\\first"+currentDate+".csv");
			File destination = new File(prop.getProperty("destinationpath")
					+ prop.getProperty("destinationfileprefix") + currentDate
					+ ".csv");
			FileUtils.copyFile(source, destination);
			System.out.println("File is copied successfully!");

		} catch (Exception e) {
			System.out.println("Error"+e);
		}

	}

}
