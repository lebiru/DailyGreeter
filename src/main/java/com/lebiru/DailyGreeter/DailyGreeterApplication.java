package com.lebiru.DailyGreeter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.conditional.ElseAction;

@RestController
@SpringBootApplication
public class DailyGreeterApplication {

	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }

	@RequestMapping("/greeter")
	String greeter() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime localTime = LocalTime.now();
		String greeter = "";

		if(localTime.getHour() < 12)
		{
			greeter = "morning";
		}
		else if(localTime.getHour() > 12 && localTime.getHour() < 18)
		{
			greeter = "afternoon";
		}
		else{
			greeter = "evening";
		}
		
		return "Good " + greeter + "! Time now: " + dtf.format(localTime);
	}

	public static void main(String[] args) {
		SpringApplication.run(DailyGreeterApplication.class, args);
	}

}
