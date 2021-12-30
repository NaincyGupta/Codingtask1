package com.quantcast;

import java.util.*;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import java.io.*;
import java.text.SimpleDateFormat;


public class MostActiveCookie
{
	//function to find the most active cookie provided the date
	public  List<String> mostActiveCookieFinder(List<List<String>> list, String inputDate)
	{
		int max = 0;
		List<String> answer = new ArrayList<>();
		HashMap<String,Integer> map = new HashMap<>();
		for(List<String> dataList: list) 
		{
			if(dataList.get(1).equals(inputDate))							//checks if csv is having input date
			{
				if(map.containsKey(dataList.get(0)))
				{
					map.put(dataList.get(0), map.get(dataList.get(0))+1);   //if the cookie id with same input date found, it adds 1 to it
				}
				else
				{
					map.put(dataList.get(0), 1);                            //if cookie id with input date is found for the first time, it puts 1 in hashMap
				}
			}
			
		}
		
		// to find the maximum number of occurrence of cookie id
		for(String cookieId: map.keySet())
		{
			if(map.get(cookieId) > max)
				max = map.get(cookieId);
		}
		
		//adding the cookie id in list if the number of occurrence is equal to max
		for(String cookieId: map.keySet())
		{
			if(map.get(cookieId) == max)
				answer.add(cookieId);
		}
		return answer;	
	}

	
	//Main method
	public static void main(String[] args) throws Exception  
	{
	
		MostActiveCookie cf = new MostActiveCookie();
		FileReader file = new FileReader(args[0]);
		BufferedReader br = null;
		try
		{
            br = new BufferedReader(file);
           
        }
		catch (Exception e)									//if the file is not found at specified location
		{
			System.out.println("Error, FileNotFound!");
			System.exit(1);
        }
		
		if(args.length <1) 								    //if csv path is not added as argument in cmd line
		 {
		    System.out.println("Error, cookieData.csv path is not entered as argument in cmd line");
			System.exit(1);
		  }
		
		Options options = new Options();
        Option date = new Option("d", "Date", true, "Specified Date");
        date.setRequired(true);								
        options.addOption(date);
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try 
        {
            cmd = parser.parse(options, args);
        } 
        catch (ParseException e)										//if date is not passed as -d parameter
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
	    String line =  null;
	    List<List<String>> list = new ArrayList<>();
	    while((line=br.readLine())!=null)
	    {
	        String[] str = line.split(",");							
	        String cookie = str[0];
	        String timestamp = str[1].substring(11);
	        String dat = str[1].substring(0,10);
	        List<String> temp = new ArrayList<>();
	        temp.add(cookie);
	        temp.add(dat);
	        temp.add(timestamp);
	        list.add(temp);										//adding each line with cookie id, date and timestamp as different fields in list
	    }

	    String inputDate = cmd.getOptionValue("d");
	    
	    // checking if the date format entered as the input date is correct
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try 
        {
            dateFormat.parse(inputDate.trim());
            System.out.println(cf.mostActiveCookieFinder(list,inputDate));
        } 
        catch (Exception e) 
        {
        	System.out.println("Error, Date entered is not in format yyyy-MM-dd");
			System.exit(1);
        }

	}
}
