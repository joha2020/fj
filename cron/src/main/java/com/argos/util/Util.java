package com.argos.util;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.argos.util.vo.Param;

public class Util {

	public static void writeToCSV(List<Param> params, String path, Boolean end,Boolean start) {
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa");
			String date = fmt.format(new Date());
			File file = new File(path);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter writer = new FileWriter(path, true);
			
			if(start)
			{
				writer.append(date);
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
						writer.append('\n');
						
					}
					else
					{
						writer.append(',');
					}
				}
//				writer.append(teams.get(i).getTitle());
//				writer.append(',');
//				writer.append(teams.get(i).getKey());
//				writer.append('\n');
			}

			writer.flush();
			writer.close();
			
		}

		catch (Exception e) {
			System.out.println("Error>>" + e);
		}
	}

}
