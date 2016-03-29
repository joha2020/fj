package com.argos.copier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		SimpleDateFormat timefmt = new SimpleDateFormat("HH:mm:00");
		Date now = new Date();
		String timeNow = timefmt.format(now);
		System.out.println(timeNow);

	}

}
