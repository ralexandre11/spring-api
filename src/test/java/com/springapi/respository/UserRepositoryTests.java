package com.springapi.respository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springapi.domain.User;
import com.springapi.domain.enums.Role;
import com.springapi.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void saveTest() {
		userRepository.deleteAll();
		User user = new User(null, "User Test", "usertest.gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);
		
		assertThat(createdUser.getName()).isEqualTo("User Test");
	}
	
	@Test
	public void updateTest() {
		userRepository.deleteAll();
		User user = new User(null, "User Test", "usertest.gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);
		User user2 = new User(createdUser.getId(), "User Test Updated", "usertest.gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User updatedUser = userRepository.save(user2);
		
		assertThat(updatedUser.getName()).isEqualTo("User Test Updated");
	}
	
	@Test
	public void getByIdTest() {
		userRepository.deleteAll();
		User user = new User(null, "User Test", "usertest.gmail.com", "123456", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);
		Long myId = createdUser.getId();

		Optional<User> result = userRepository.findById(myId);
		User userResult = result.get();
			
		assertThat(userResult.getPassword()).isEqualTo("123456");
	}
	
	@Test
	public void listTest() {
		userRepository.deleteAll();
		User user1 = new User(null, "User Test", "usertest.gmail.com", "123456", Role.ADMINISTRATOR, null, null);
		userRepository.save(user1);
		User user2 = new User(null, "User Test 02", "usertest2.gmail.com", "1234", Role.ADMINISTRATOR, null, null);
		userRepository.save(user2);
		List<User> users = userRepository.findAll();
		
		assertThat(users.size()).isEqualTo(2);
	}
	
	@Test
	public void loginTest() {
		userRepository.deleteAll();
		User user3 = new User(null, "User Test 03", "usertest3.gmail.com", "123456", Role.ADMINISTRATOR, null, null);
		userRepository.save(user3);
		Optional<User> result = userRepository.login("usertest3.gmail.com", "123456");
		User loggedUser = result.get();
		
		assertThat(loggedUser.getName()).isEqualTo("User Test 03");
	}
	
}
