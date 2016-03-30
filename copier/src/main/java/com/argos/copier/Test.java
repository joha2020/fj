package com.argos.copier;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		SimpleDateFormat timefmt = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1); 
		System.out.println(timefmt.format(cal.getTime()));

	}

}
