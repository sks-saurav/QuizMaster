package com.exam;

import com.exam.helper.UserFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting of the code");

//		try {
//
//			User user = new User();
//			user.setFirstName("Gaurav");
//			user.setLastName("Kumar");
//			user.setUsername("sks");
//			user.setPassword(this.bCryptPasswordEncoder.encode("password"));
//			user.setEmail("sks_saurav@myemail.com");
//			user.setProfile("dafault.png");
//
//			Role role1 = new Role();
//			role1.setRoleId(44l);
//			role1.setRoleName("ADMIN");
//
//			Set<UserRole> userRoleSet = new HashSet<>();
//			UserRole userRole = new UserRole();
//			userRole.setRole(role1);
//			userRole.setUser(user);
//			userRoleSet.add(userRole);
//
//			User user1 = this.userService.createUser(user, userRoleSet);
//			System.out.println(user1.toString());
//		} catch (UserFoundException e) {
//			e.printStackTrace();
//		}
	}
}
