package com.quantcast;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MostActiveCookieTest
{
	//Test to check if input date is not present in the csv
	@Test
	public void dateNotPresent() 
	{		
		MostActiveCookie test = new MostActiveCookie();
		List<String> temp1 = new ArrayList<>();
		List<String> temp2 = new ArrayList<>();
		List<String> temp3 = new ArrayList<>();
		List<List<String>> list = new ArrayList<>();
		temp1.add("AtY0laUfhglK3lC7");
        temp1.add("2018-12-09");
        temp1.add("14:19:00+00:00");
        list.add(temp1);
        
        temp2.add("AtY0laUfhglK3lC7");
        temp2.add("2018-12-09");
        temp2.add("06:19:00+00:00");
        list.add(temp2);
        
        temp3.add("SAZuXPGUrfbcn5UA");
        temp3.add("2018-12-09");
        temp3.add("10:13:00+00:00");
        list.add(temp3);
        
		List<String> output = test.mostActiveCookieFinder(list, "2018-12-10");
		System.out.println(output);
		List<String> expected = new ArrayList<>();
		assertEquals(expected,output);
	}
	
	
	//Test to check if empty string is passed as date
	@Test
	public void dateIsEmpty() 
	{		
		MostActiveCookie test = new MostActiveCookie();
		List<String> temp1 = new ArrayList<>();
		List<String> temp2 = new ArrayList<>();
		List<String> temp3 = new ArrayList<>();
		List<List<String>> list = new ArrayList<>();
		temp1.add("AtY0laUfhglK3lC7");
        temp1.add("2018-12-09");
        temp1.add("14:19:00+00:00");
        list.add(temp1);
        
        temp2.add("AtY0laUfhglK3lC7");
        temp2.add("2018-12-09");
        temp2.add("06:19:00+00:00");
        list.add(temp2);
        
        temp3.add("SAZuXPGUrfbcn5UA");
        temp3.add("2018-12-09");
        temp3.add("10:13:00+00:00");
        list.add(temp3);
        
		List<String> output = test.mostActiveCookieFinder(list, "");
		System.out.println(output);
		List<String> expected = new ArrayList<>();
		assertEquals(expected,output);
	}
	
	//Test to check if more than one most active cookie is present in csv for a particular date
	@Test
	public void multipleMostActiveCookies() 
	{		
		MostActiveCookie test = new MostActiveCookie();
		List<String> temp1 = new ArrayList<>();
		List<String> temp2 = new ArrayList<>();
		List<List<String>> list = new ArrayList<>();
		temp1.add("AtY0laUfhglK3lC7");
        temp1.add("2018-12-09");
        temp1.add("14:19:00+00:00");
        list.add(temp1);
        
        temp2.add("SAZuXPGUrfbcn5UA");
        temp2.add("2018-12-09");
        temp2.add("10:13:00+00:00");
        list.add(temp2);
        
		List<String> output = test.mostActiveCookieFinder(list, "2018-12-09");
		System.out.println(output);
		List<String> expected = Arrays.asList("AtY0laUfhglK3lC7","SAZuXPGUrfbcn5UA");
		assertEquals(expected,output);
	}
	
	//Test to check if one most active cookie is present in csv with particular date
	@Test
	public void oneMostActiveCookie() 
	{		
		MostActiveCookie test = new MostActiveCookie();
		List<String> temp1 = new ArrayList<>();
		List<String> temp2 = new ArrayList<>();
		List<String> temp3 = new ArrayList<>();
		List<List<String>> list = new ArrayList<>();
		temp1.add("AtY0laUfhglK3lC7");
        temp1.add("2018-12-09");
        temp1.add("14:19:00+00:00");
        list.add(temp1);
        
        temp2.add("AtY0laUfhglK3lC7");
        temp2.add("2018-12-09");
        temp2.add("06:19:00+00:00");
        list.add(temp2);
        
        temp3.add("SAZuXPGUrfbcn5UA");
        temp3.add("2018-12-09");
        temp3.add("10:13:00+00:00");
        list.add(temp3);
        
        List<String> output = test.mostActiveCookieFinder(list, "2018-12-09");
		System.out.println(output);
		List<String> expected = Arrays.asList("AtY0laUfhglK3lC7");
		assertEquals(expected,output);
	}

	//Test to check if empty cookieData.csv is passed
	@Test
	public void isEmptyCSV() 
	{		
		MostActiveCookie test = new MostActiveCookie();
		List<List<String>> list = new ArrayList<>();
        List<String> output = test.mostActiveCookieFinder(list, "2018-12-09");
		System.out.println(output);
		List<String> expected = Arrays.asList();
		assertEquals(expected,output);
	}
	
	//Test to check if the input date is is missing in CookieData.csv file
	@Test
	public void noDateInCSV() 
	{		
		MostActiveCookie test = new MostActiveCookie();
		List<String> temp1 = new ArrayList<>();
		List<String> temp2 = new ArrayList<>();
		List<String> temp3 = new ArrayList<>();
		List<List<String>> list = new ArrayList<>();
		temp1.add("AtY0laUfhglK3lC7");
        temp1.add("14:19:00+00:00");
        list.add(temp1);
        
        temp2.add("AtY0laUfhglK3lC7");
        temp2.add("06:19:00+00:00");
        list.add(temp2);
        
        temp3.add("SAZuXPGUrfbcn5UA");
        temp3.add("2018-12-10");
        temp3.add("10:13:00+00:00");
        list.add(temp3);
        
        List<String> output = test.mostActiveCookieFinder(list, "2018-12-09");
		System.out.println(output);
		List<String> expected = Arrays.asList();
		assertEquals(expected,output);
	}
	
	//Test to check if the input date is present with no cookie id in Cookiedata.csv file
	@Test
	public void noCookieIdInCSV() 
	{	
		MostActiveCookie test = new MostActiveCookie();
		List<String> temp1 = new ArrayList<>();
		List<String> temp2 = new ArrayList<>();
		List<String> temp3 = new ArrayList<>();
		List<List<String>> list = new ArrayList<>();
        temp1.add("2018-12-09");
        temp1.add("14:19:00+00:00");
        list.add(temp1);
        
        temp2.add("2018-12-09");
        temp2.add("06:19:00+00:00");
        list.add(temp2);
        
        temp3.add("SAZuXPGUrfbcn5UA");
        temp3.add("2018-12-10");
        temp3.add("10:13:00+00:00");
        list.add(temp3);
        
        List<String> output = test.mostActiveCookieFinder(list, "2018-12-09");
		System.out.println(output);
		List<String> expected = Arrays.asList();
		assertEquals(expected,output);
	}
	

}

