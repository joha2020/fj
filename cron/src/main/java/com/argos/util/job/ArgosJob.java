package com.argos.util.job;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.argos.util.Util;
import com.argos.util.vo.Param;
import com.argos.util.vo.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ArgosJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			if(this.getFirstSet())				
				if(this.getSecondSet())
					if(this.getThirdSet())
						this.getFourthSet();
			
			System.out.println("Job Done !!!");
		}

		catch (Exception e) {
			System.out.println("Error>>" + e);
		}

	}
	
	private boolean getFirstSet(){
		try{
			
			RequestConfig.Builder requestBuilder = RequestConfig.custom();
			Properties prop = new Properties();
			InputStream input = new FileInputStream("config.properties");
			prop.load(input);
			String endPoint = "https://api.netbiter.net/operation/v1/rest/json/system/003011FAD084/live/async?accesskey=31E7ECB9D88D78C25BEB2987CAB2BF53&id=51968.0.103317&id=51968.0.103318&id=51968.0.103319&id=51968.0.103648&id=51968.0.103313&id=51968.0.103315&id=51968.0.103646&id=51968.0.103647&id=51968.0.103649&id=51968.0.103663&id=51968.0.103664&id=51968.0.103665&id=51968.0.103668&id=51968.0.103661&id=51968.0.103662&id=51968.0.103666&id=51968.0.103667&id=51968.0.103669&id=51968.0.103672&id=51968.0.103673&id=51968.0.103674&id=51968.0.103677&id=51968.0.103670&id=51968.0.103671&id=51968.0.103675&id=51968.0.103678&id=51968.0.103676&id=51968.0.103681&id=51968.0.103682&id=51968.0.103683&id=51968.0.103686&id=51968.0.103679&id=51968.0.103680&id=51968.0.103684&id=51968.0.103687&id=51968.0.103685";
			requestBuilder = requestBuilder.setConnectTimeout(20000);
			requestBuilder = requestBuilder.setConnectionRequestTimeout(20000);
			HttpClientBuilder builder = HttpClientBuilder.create();
			builder.setDefaultRequestConfig(requestBuilder.build());
			HttpClient client = builder.build();
			// HttpClient client = HttpClients.createDefault();
			HttpGet getResponse = new HttpGet(endPoint);			
			HttpResponse response = client.execute(getResponse);

//			if (response.getStatusLine().getStatusCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//						+ response.getStatusLine().getStatusCode());
//			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			Gson gson = new Gson();
			Response resp = gson.fromJson(br, Response.class);
			if(resp.getId() != null)
			{
				
				this.getData(resp.getId(),false,resp.getEstimatedWaitTime(),true);
			}
			
			return true;
			
		}
		
		catch(Exception e)
		{
			System.out.println("Error in 1st iteration"+e);
			return false;
		}
	}
	
	private boolean getSecondSet(){
		try{
			
			RequestConfig.Builder requestBuilder = RequestConfig.custom();
			Properties prop = new Properties();
			InputStream input = new FileInputStream("config.properties");
			prop.load(input);
			String endPoint = "https://api.netbiter.net/operation/v1/rest/json/system/003011FAD084/live/async?accesskey=31E7ECB9D88D78C25BEB2987CAB2BF53&id=51968.0.103690&id=51968.0.103692&id=51968.0.103693&id=51968.0.103696&id=51968.0.103688&id=51968.0.103689&id=51968.0.103694&id=51968.0.103697&id=51968.0.103695&id=51968.0.103700&id=51968.0.103701&id=51968.0.103702&id=51968.0.103705&id=51968.0.103698&id=51968.0.103699&id=51968.0.103701&id=51968.0.103703&id=51968.0.103706&id=51968.0.103704&id=51968.0.103709&id=51968.0.103710&id=51968.0.103711&id=51968.0.103714&id=51968.0.103707&id=51968.0.103708&id=51968.0.103712&id=51968.0.103715&id=51968.0.103713&id=51968.0.103718&id=51968.0.103719&id=51968.0.103720&id=51968.0.103723&id=51968.0.103716&id=51968.0.103717&id=51968.0.103721&id=51968.0.103724&id=51968.0.103722";
			requestBuilder = requestBuilder.setConnectTimeout(20000);
			requestBuilder = requestBuilder.setConnectionRequestTimeout(20000);
			HttpClientBuilder builder = HttpClientBuilder.create();
			builder.setDefaultRequestConfig(requestBuilder.build());
			HttpClient client = builder.build();
			// HttpClient client = HttpClients.createDefault();
			HttpGet getResponse = new HttpGet(endPoint);			
			HttpResponse response = client.execute(getResponse);

//			if (response.getStatusLine().getStatusCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//						+ response.getStatusLine().getStatusCode());
//			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			Gson gson = new Gson();
			Response resp = gson.fromJson(br, Response.class);
			if(resp.getId() != null)
			{
				//Thread.sleep(2*resp.getEstimatedWaitTime());
				this.getData(resp.getId(),false,resp.getEstimatedWaitTime(),false);
			}
			
			return true;
			
		}
		
		catch(Exception e)
		{
			System.out.println("Error in 2nd iteration"+e);
			return false;
		}
	}
	
	private boolean getThirdSet(){
		try{
			
			RequestConfig.Builder requestBuilder = RequestConfig.custom();
			Properties prop = new Properties();
			InputStream input = new FileInputStream("config.properties");
			prop.load(input);
			String endPoint = "https://api.netbiter.net/operation/v1/rest/json/system/003011FAD084/live/async?accesskey=31E7ECB9D88D78C25BEB2987CAB2BF53&id=51968.0.103727&id=51968.0.103728&id=51968.0.103729&id=51968.0.103732&id=51968.0.103725&id=51968.0.103726&id=51968.0.103730&id=51968.0.103733&id=51968.0.103731&id=51968.0.103736&id=51968.0.103737&id=51968.0.103738&id=51968.0.103741&id=51968.0.103734&id=51968.0.103735&id=51968.0.103739&id=51968.0.103742&id=51968.0.103740&id=51968.0.103746&id=51968.0.103747&id=51968.0.103748&id=51968.0.103751&id=51968.0.103744&id=51968.0.103745&id=51968.0.103749&id=51968.0.103752&id=51968.0.103750&id=51968.0.103755&id=51968.0.103756&id=51968.0.103757&id=51968.0.103760&id=51968.0.103753&id=51968.0.103754&id=51968.0.103758&id=51968.0.103761&id=51968.0.103759";
			requestBuilder = requestBuilder.setConnectTimeout(20000);
			requestBuilder = requestBuilder.setConnectionRequestTimeout(20000);
			HttpClientBuilder builder = HttpClientBuilder.create();
			builder.setDefaultRequestConfig(requestBuilder.build());
			HttpClient client = builder.build();
			// HttpClient client = HttpClients.createDefault();
			HttpGet getResponse = new HttpGet(endPoint);			
			HttpResponse response = client.execute(getResponse);

//			if (response.getStatusLine().getStatusCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//						+ response.getStatusLine().getStatusCode());
//			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			Gson gson = new Gson();
			Response resp = gson.fromJson(br, Response.class);
			if(resp.getId() != null)
			{
				//Thread.sleep(2*resp.getEstimatedWaitTime());
				this.getData(resp.getId(),false,resp.getEstimatedWaitTime(),false);
			}
			
			return true;
			
		}
		
		catch(Exception e)
		{
			System.out.println("Error in 3rd iteration"+e);
			return false;
		}
	}
	
	private boolean getFourthSet(){
		try{
			
			RequestConfig.Builder requestBuilder = RequestConfig.custom();
			Properties prop = new Properties();
			InputStream input = new FileInputStream("config.properties");
			prop.load(input);
			String endPoint = "https://api.netbiter.net/operation/v1/rest/json/system/003011FAD084/live/async?accesskey=31E7ECB9D88D78C25BEB2987CAB2BF53&id=51968.0.101860&id=51968.0.101861&id=51968.0.101862&id=51968.0.101863&id=51968.0.101864&id=51968.0.101865&id=51968.0.101866&id=51968.0.101867&id=51968.0.101868&id=51968.0.101869&id=51968.0.102373&id=51968.0.102375&id=51968.0.102378&id=51968.0.102379&id=51968.0.102380&id=51968.0.102382&id=51968.0.102376&id=54576.0.108797&id=54576.0.108798&id=54576.0.108799";
			requestBuilder = requestBuilder.setConnectTimeout(20000);
			requestBuilder = requestBuilder.setConnectionRequestTimeout(20000);
			HttpClientBuilder builder = HttpClientBuilder.create();
			builder.setDefaultRequestConfig(requestBuilder.build());
			HttpClient client = builder.build();
			// HttpClient client = HttpClients.createDefault();
			HttpGet getResponse = new HttpGet(endPoint);			
			HttpResponse response = client.execute(getResponse);

//			if (response.getStatusLine().getStatusCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//						+ response.getStatusLine().getStatusCode());
//			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			Gson gson = new Gson();
			Response resp = gson.fromJson(br, Response.class);
			if(resp.getId() != null)
			{
				
				this.getData(resp.getId(),true,resp.getEstimatedWaitTime(),false);
			}
			
			return true;
			
		}
		
		catch(Exception e)
		{
			System.out.println("Error in 4th iteration"+e);
			return false;
		}
	}

	

	
	private void getData(String key, Boolean end,int waitTime,Boolean start)
	{
		try{
		Thread.sleep(waitTime);
		RequestConfig.Builder requestBuilder = RequestConfig.custom();
		Properties prop = new Properties();
		InputStream input = new FileInputStream("config.properties");
		prop.load(input);
		String endPoint = "https://api.netbiter.net/operation/v1/rest/json/system/003011FAD084/live/async/"+key+"?accesskey=31E7ECB9D88D78C25BEB2987CAB2BF53";
		requestBuilder = requestBuilder.setConnectTimeout(20000);
		requestBuilder = requestBuilder.setConnectionRequestTimeout(20000);
		HttpClientBuilder builder = HttpClientBuilder.create();
		builder.setDefaultRequestConfig(requestBuilder.build());
		HttpClient client = builder.build();
		// HttpClient client = HttpClients.createDefault();
		HttpGet getResponse = new HttpGet(endPoint);			
		HttpResponse response = client.execute(getResponse);

		if (response.getStatusLine().getStatusCode() == 204) {			
			getData(key,end,waitTime,start);	
			return;
		}
		
		System.out.println("Code>>"+response.getStatusLine().getStatusCode()+"  KEY>>>"+key);
		//content = EntityUtils.toString(response.getEntity());
		

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(response.getEntity().getContent())));

		Gson gson = new Gson();
		List<Param> params = gson.fromJson(br, new TypeToken<List<Param>>() {
			}.getType());
		
		String path = "";
		path = prop.getProperty("filepath");
		Util.writeToCSV(params, path,end,start);
		
	}
		catch(Exception e){
			//System.out.println("Response>>>"+content);
			System.out.println("Error in reading the output>>"+e);
		}
	}
	
	

}
