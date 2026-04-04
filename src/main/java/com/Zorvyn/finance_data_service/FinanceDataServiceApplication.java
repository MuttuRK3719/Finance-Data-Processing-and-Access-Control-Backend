package com.Zorvyn.finance_data_service;
import com.Zorvyn.finance_data_service.dto.request.CreateRecordRequest;
import com.Zorvyn.finance_data_service.dto.request.CreateUserRequest;
import com.Zorvyn.finance_data_service.enums.Category;
import com.Zorvyn.finance_data_service.enums.Role;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import com.Zorvyn.finance_data_service.service.FinancialRecordService;
import com.Zorvyn.finance_data_service.service.imp.FinancialRecordServiceImp;
import com.Zorvyn.finance_data_service.service.imp.UserServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FinanceDataServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(FinanceDataServiceApplication.class, args);

		FinancialRecordService service = context.getBean(FinancialRecordServiceImp.class);

		CreateRecordRequest req = new CreateRecordRequest();
		req.setAmount(10000.0);
		req.setType(TransactionType.INCOME);
		req.setCategory(String.valueOf(Category.SALARY));
		req.setNotes("Deposit");
		service.createRecord(req,"test@gmail.com");
	}
}