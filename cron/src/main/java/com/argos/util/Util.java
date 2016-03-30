package com.argos.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.argos.util.vo.Param;

public class Util {

	public static void writeToCSV(List<Param> params, String path, Boolean end,Boolean start,Date startTime) {
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat timefmt = new SimpleDateFormat("HH:mm:00");			
			String date = fmt.format(startTime);
			String timeNow = timefmt.format(startTime);
			String tempFilePath  = path+"-temp.csv";
			File file = new File(tempFilePath);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter writer = new FileWriter(tempFilePath, true);
			
			if(start)
			{
				writer.append('\n');
				writer.append(date);
				writer.append(',');
				writer.append(timeNow);
				writer.append(',');
				
			}

			for (int i = 0; i < params.size(); i++) {
				writer.append(params.get(i).getValue());
				if(i != (params.size()-1) )
				{
					writer.append(',');
				}
					
				
				if(i == (params.size()-1) )
				{
					if(end)
					{
						
						
					}
					else
					{
						writer.append(',');
					}
				}

			}

			writer.flush();
			writer.close();
			
		}

		catch (Exception e) {
			System.out.println("Error>>" + e);
		}
	}
	
	public static boolean renameTempFile(String path){
		try{
			
			File oldfile =new File(path+"-temp.csv");
			FileWriter writer = new FileWriter(path+".csv", true);
			String sCurrentLine;
			BufferedReader br = new BufferedReader(new FileReader(oldfile));
			writer.append("\n");
			while ((sCurrentLine = br.readLine()) != null) {
				writer.append(sCurrentLine);			
				
			}
			if (br != null)br.close();
			writer.flush();
			writer.close();
			if(oldfile.exists())
				FileUtils.forceDelete(oldfile);
			return true;
			
		}
		catch(Exception e){			
			System.out.println("Error renaming the file"+e);
			return false;
		}
		
	}
	
	public static boolean deleteTempFile(String path)
	{
		try{
			File oldfile =new File(path+"-temp.csv");
			if(oldfile.exists())
				FileUtils.forceDelete(oldfile);
			
			return true;
			
		}
		catch(Exception e){
			return false;
		}
	}

}
