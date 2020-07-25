package java8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import org.junit.Test;



public class DateTimeTest {
	@Test
	public void testLocalDate() {
		LocalDate date = LocalDate.of(2020, 7, 4);
		int year = date.getYear();
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		DayOfWeek dowDayOfWeek = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		boolean isLeap = date.isLeapYear();
		
		System.out.println("year: " + year + " month:" + month + " day:" 
							+ day + " dowDayOfWeek:" + dowDayOfWeek + " len:" 
							+ len + " isLeap:" + isLeap);
	}
	
	@Test
	public void testLocalTime() {
		LocalTime localTime = LocalTime.of(13, 45, 20);
		int hour = localTime.getHour();
		int minute = localTime.getMinute();
		int second = localTime.getSecond();
		
		System.out.println("hour: " + hour + " minute: " + minute + " second: " + second);
	}
}
