package com.argos.copier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
@DisallowConcurrentExecution
public class CronJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("config.properties");
			prop.load(input);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = df.format(new Date());
			File source = new File(prop.getProperty("filepath"));
			File destination = new File(prop.getProperty("destinationpath")
					+ prop.getProperty("destinationfileprefix") + currentDate
					+ ".csv");
			FileUtils.copyFile(source, destination);
			System.out.println("File is copied successfully!");
			if(new File(prop.getProperty("filepath")).exists())
			{
				FileUtils.forceDelete(new File(prop.getProperty("filepath")));
				File emptyFile = new File(prop.getProperty("emptyfilepath"));
				File file = new File(prop.getProperty("filepath"));				

				if (!file.exists()) {
					file.createNewFile();
				}
				
				FileWriter writer = new FileWriter(prop.getProperty("filepath"), true);
				String sCurrentLine;
				BufferedReader br = new BufferedReader(new FileReader(emptyFile));				
				while ((sCurrentLine = br.readLine()) != null) {
					writer.append(sCurrentLine);					
				}
				if (br != null)br.close();
				writer.flush();
				writer.close();

			}

		} catch (Exception e) {
			System.out.println("Error in the copy job"+e);
		}

	}

}
