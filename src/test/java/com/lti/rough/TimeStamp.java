package com.lti.rough;

import java.util.Date;

public class TimeStamp {
	
	
	public static void main(String[] args) {
		Date d=new Date();
		String date=d.toString().replace(":", "_").replace(" ", "_");
		System.out.println(date);
		
	}

}
