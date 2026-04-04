package com.Zorvyn.finance_data_service;
import com.Zorvyn.finance_data_service.dto.request.CreateUserRequest;
import com.Zorvyn.finance_data_service.enums.Role;
import com.Zorvyn.finance_data_service.service.imp.UserServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FinanceDataServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(FinanceDataServiceApplication.class, args);

		UserServiceImp service = context.getBean(UserServiceImp.class);

		CreateUserRequest req = new CreateUserRequest();
		req.setEmail("test@gmail.com");
		req.setName("Test");
		req.setRole(Role.VIEWER);
		req.setPassword("Test@123");
		service.createUser(req);
	}
}