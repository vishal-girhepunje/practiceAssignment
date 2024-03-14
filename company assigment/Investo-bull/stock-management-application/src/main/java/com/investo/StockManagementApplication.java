package com.investo;

import com.investo.service.CandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockManagementApplication.class, args);
	}

}
