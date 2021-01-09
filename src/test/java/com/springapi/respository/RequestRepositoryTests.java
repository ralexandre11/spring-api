package com.springapi.respository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springapi.repository.RequestRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RequestRepositoryTests {
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Test
	public void saveTest() {
//		requestRepository.deleteAll();
//		User owner = new User();
//		owner.setId(1L);
//		
//		Request request = new Request(null, "New Laptop HP", "I5 Windows 10 8GB", new Date(), RequestState.OPEN, owner, null);
//		Request createdRequest = requestRepository.save(request);
//		
//		assertThat(createdRequest.getSubject()).isEqualTo("New Laptop HP");
	}

}
