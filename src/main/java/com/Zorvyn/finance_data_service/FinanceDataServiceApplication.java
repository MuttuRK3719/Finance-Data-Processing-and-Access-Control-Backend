package com.Zorvyn.finance_data_service;
import com.Zorvyn.finance_data_service.dto.request.CreateRecordRequest;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import com.Zorvyn.finance_data_service.repository.FinancialRecordRepository;
import com.Zorvyn.finance_data_service.service.DashboardService;
import com.Zorvyn.finance_data_service.service.FinancialRecordService;
import com.Zorvyn.finance_data_service.service.imp.FinancialRecordServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.time.LocalDate;


@PropertySource("classpath:messages.properties")
@SpringBootApplication

public class FinanceDataServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(FinanceDataServiceApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("1234"));
	}
}